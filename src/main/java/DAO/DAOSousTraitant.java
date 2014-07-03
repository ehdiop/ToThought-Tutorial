package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xyz.myproject.model.exceptions.NEException;
import com.xyz.myproject.model.general.CodePostal;
import com.xyz.myproject.model.general.NEQ;
import com.xyz.myproject.model.general.NumeroEntreprise;
import com.xyz.myproject.model.general.NumeroIdProv;
import com.xyz.myproject.model.general.SousTraitant;

public class DAOSousTraitant extends DAO<SousTraitant> {

	public DAOSousTraitant() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	public SousTraitant find(String ne) {
		System.out.println("---------------------------------------");
		System.out.println("recup Sous traitant");
		// TODO Auto-generated method stub
		Statement st;
		SousTraitant ssT = new SousTraitant();
		try {
			st = connection.createStatement();
			ResultSet res = st.executeQuery("select * from Sous_Traitant where ne='"+ne+"'");
			while (res.next()){
				String nom_st = res.getString("nom");
				String description = res.getString("description");
				String adresse = res.getString("adresse");
				String ville = res.getString("ville");
//				Province province = new Province(res.getString("province"));
				CodePostal cp = new CodePostal(res.getString("cp"));
				boolean dependance = res.getBoolean("dependance");
				try {
					NumeroEntreprise NE = new NumeroEntreprise(res.getString("NE"));
					NumeroIdProv numProv = new NumeroIdProv(res.getString("numero_id_prov"));
					NEQ NEQ = new NEQ(res.getString("NEQ"));
					
					ssT =new SousTraitant(nom_st, description,adresse, ville, null, cp,null,null,dependance, NE, numProv, NEQ);
					

				} catch (NEException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ssT;
	}



	@Override
	public boolean create(SousTraitant obj) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean delete(SousTraitant obj) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean update(SousTraitant obj) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public SousTraitant find() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
