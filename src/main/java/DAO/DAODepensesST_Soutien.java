package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xyz.myproject.model.general.SousTraitant;
import com.xyz.myproject.model.projet.DepenseST_Soutien;
import com.xyz.myproject.model.projet.DepensesSousTraitance;

public class DAODepensesST_Soutien extends DAO<DepensesSousTraitance<DepenseST_Soutien>>{

	public DAODepensesST_Soutien() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(DepensesSousTraitance<DepenseST_Soutien> obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(DepensesSousTraitance<DepenseST_Soutien> obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(DepensesSousTraitance<DepenseST_Soutien> obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DepensesSousTraitance<DepenseST_Soutien> find() {
		// TODO Auto-generated method stub
		return null;
	}

	public DepensesSousTraitance<DepenseST_Soutien> find(int id_projet) {
		System.out.println("---------------------------------------");
		System.out.println("recup Depenses ST_Soutien");
		Statement st;
		DepensesSousTraitance<DepenseST_Soutien> depenses_st_sout = new DepensesSousTraitance<DepenseST_Soutien>();
		try {
			st = connection.createStatement();
				ResultSet res = st.executeQuery("select DepenseST_Soutien.montant "
						+ "from DepenseST_Soutien,sous_traitant,client,Projet_Client "
						+ "where DepenseST_Soutien.NE_sous_traitant= Sous_Traitant.NE and "
						+ "Sous_Traitant.NE_client = client.ne and "
						+ "Projet_Client.ne_client = client.ne and "
						+ "Projet_Client.id_projet = '"+id_projet+"'");
				while(res.next()){
					String neSsT = res.getString("NE_sous_traitant");
					double montant = res.getDouble("montant");
					DAOSousTraitant daoSsTr = new DAOSousTraitant();					
					SousTraitant sst = daoSsTr.find(neSsT);
					DepenseST_Soutien dep = new DepenseST_Soutien(montant, sst);
					depenses_st_sout.add(dep);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return depenses_st_sout;
	}
}
