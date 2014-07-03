package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xyz.myproject.model.general.SousTraitant;
import com.xyz.myproject.model.projet.DepenseST_RD;
import com.xyz.myproject.model.projet.DepensesSousTraitance;

public class DAODepensesST_RD extends DAO<DepensesSousTraitance<DepenseST_RD>> {

	public DAODepensesST_RD() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(DepensesSousTraitance<DepenseST_RD> obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(DepensesSousTraitance<DepenseST_RD> obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(DepensesSousTraitance<DepenseST_RD> obj) {
		// TODO Auto-generated method stub
		return false;
	}


	public DepensesSousTraitance<DepenseST_RD> find(int id_projet) {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------------");
		System.out.println("recup depense ST_RD");
		Statement st;
		DepensesSousTraitance<DepenseST_RD> depenses_st_rd = new DepensesSousTraitance<DepenseST_RD>();
		try {
			st = connection.createStatement();
				ResultSet res = st.executeQuery("select depensest_rd.montant,depensest_rd.NE_sous_traitant "
						+ "from depensest_rd,sous_traitant,client,Projet_Client "
						+ "where DepenseST_RD.NE_sous_traitant= Sous_Traitant.NE and "
						+ "Sous_Traitant.NE_client = client.ne and "
						+ "Projet_Client.ne_client = client.ne and "
						+ "Projet_Client.id_projet = '"+id_projet+"'");
				while(res.next()){
					String neSsT = res.getString("NE_sous_traitant");
					double montant = res.getDouble("montant");
					DAOSousTraitant daoSsTr = new DAOSousTraitant();					
					SousTraitant sst = daoSsTr.find(neSsT);
					DepenseST_RD dep = new DepenseST_RD(montant, sst);
					depenses_st_rd.add(dep);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return depenses_st_rd;
	}

	@Override
	public DepensesSousTraitance<DepenseST_RD> find() {
		// TODO Auto-generated method stub
		return null;
	}

}
