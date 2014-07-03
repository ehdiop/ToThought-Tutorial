package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xyz.myproject.model.general.SousTraitanceSoutien;

public class DAOSousTraitanceSoutien extends DAO<SousTraitanceSoutien>{

	public DAOSousTraitanceSoutien() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(SousTraitanceSoutien obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(SousTraitanceSoutien obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(SousTraitanceSoutien obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SousTraitanceSoutien find() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public SousTraitanceSoutien find(int annee, String ne) {
		System.out.println("---------------------------------------");
		System.out.println("recup Sous traitance soutien");
		SousTraitanceSoutien Sst_sout = new SousTraitanceSoutien();
		try {
			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery("select montant from total_Sous_Traitance_RD where total_Sous_Traitance_RD.annee='"+annee+"'"
					+ "and total_Sous_Traitance_RD.ne_client='"+ne+"'");
			
			while(res.next()){
				double montant = res.getDouble("montant");
				Sst_sout = new SousTraitanceSoutien(montant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Sst_sout;
	}
}
