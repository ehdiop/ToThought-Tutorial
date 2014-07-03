package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xyz.myproject.model.general.TSGeneralCanada;

public class DAOTSGeneralCanada extends DAO<TSGeneralCanada> {

	public DAOTSGeneralCanada() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(TSGeneralCanada obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TSGeneralCanada obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TSGeneralCanada obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TSGeneralCanada find() {
		System.out.println("---------------------------------------");
		System.out.println("recup TSGeneralCanada");
		Statement st;
		TSGeneralCanada tsGeneralCanada = new TSGeneralCanada();
		try {
			st = connection.createStatement();
			ResultSet res = st.executeQuery("select * from tsgeneral_canada,projet where tsgeneral_canada.num_projet=projet.num_projet and tsgeneral_canada.NE_client=projet.NE_client");
			while(res.next()){
			double mo_non_determinee_ca = res.getDouble("mo_non_det");
			double mo_determinee_ca = res.getDouble("mo_det");
			double mo_soutien = res.getDouble("mo_soutien");
			double boni = res.getDouble("boni");
			tsGeneralCanada = new TSGeneralCanada(mo_non_determinee_ca, mo_determinee_ca, mo_soutien, boni);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tsGeneralCanada;
	}

	public TSGeneralCanada find(int annee, String ne) {
		Statement st;
		TSGeneralCanada tsGenCa = new TSGeneralCanada();
		try {
			st = connection.createStatement();
			ResultSet res = st.executeQuery("select * from TSGeneral_Canada where TSGeneral_Canada.annee='"+annee+"'"
					+ "and TSGeneral_Canada.ne_client='"+ne+"'");
			while(res.next()){
				double mo_non_determinee_ca = res.getDouble("mo_non_det");
				double mo_determinee_ca = res.getDouble("mo_det");
				double mo_soutien = res.getDouble("mo_soutien");
				double boni = res.getDouble("boni");
				tsGenCa = new TSGeneralCanada(mo_non_determinee_ca, mo_determinee_ca, mo_soutien, boni);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tsGenCa;
	}
}
