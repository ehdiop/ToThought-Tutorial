package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xyz.myproject.model.general.TSGeneralEtr;

public class DAOTSGeneralEtr extends DAO<TSGeneralEtr> {

	public DAOTSGeneralEtr() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(TSGeneralEtr obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TSGeneralEtr obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TSGeneralEtr obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TSGeneralEtr find() {
		Statement st;
		TSGeneralEtr tsGeneralEtr = new TSGeneralEtr();
		try {
			st = connection.createStatement();
			ResultSet res = st.executeQuery("select * from tsgeneral_etr,projet where tsgeneral_etr.num_projet=projet.num_projet and tsgeneral_etr.NE_client=projet.NE_client");
			while(res.next()){
			double mo_non_determinee_ca = res.getDouble("mo_non_det");
			double mo_determinee_ca = res.getDouble("mo_det");
			double boni = res.getDouble("boni");
			tsGeneralEtr = new TSGeneralEtr(mo_non_determinee_ca, mo_determinee_ca, boni);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tsGeneralEtr;
	}
	public TSGeneralEtr find(int annee, String ne) {
		System.out.println("---------------------------------------");
		System.out.println("recup TSGeneralEtr");
		Statement st;
		TSGeneralEtr tsGenEtr = new TSGeneralEtr();
		try {
			st = connection.createStatement();
			ResultSet res = st.executeQuery("select * from TSGeneral_Etr where TSGeneral_Etr.annee='"+annee+"'"
					+ "and TSGeneral_Etr.ne_client='"+ne+"'");
			while(res.next()){
				double mo_non_determinee = res.getDouble("mo_non_det");
				double mo_determinee = res.getDouble("mo_det");
				double boni = res.getDouble("boni");
				tsGenEtr = new TSGeneralEtr(mo_non_determinee, mo_determinee, boni);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tsGenEtr;
	}
}
