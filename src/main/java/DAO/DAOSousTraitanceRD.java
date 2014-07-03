package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xyz.myproject.model.general.SousTraitanceRD;

public class DAOSousTraitanceRD extends DAO<SousTraitanceRD>{

	public DAOSousTraitanceRD() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(SousTraitanceRD obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(SousTraitanceRD obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(SousTraitanceRD obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SousTraitanceRD find() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public SousTraitanceRD find(int annee,String ne) {
		System.out.println("---------------------------------------");
		System.out.println("recup Sous Traitance RD");
		SousTraitanceRD Sst_Rd = new SousTraitanceRD();
		try {
			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery("select montant from total_Sous_Traitance_RD where total_Sous_Traitance_RD.annee='"+annee+"'"
					+ "and total_Sous_Traitance_RD.ne_client='"+ne+"'");
			
			while(res.next()){
//				double montant = res.getDouble("montant");
//				Sst_Rd = new SousTraitanceRD(montant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Sst_Rd;
	}
}
