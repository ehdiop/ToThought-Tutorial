package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xyz.myproject.model.projet.TSProjetCanada;

public class DAOTSProjetCanada extends DAO<TSProjetCanada> {

	public DAOTSProjetCanada() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(TSProjetCanada obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TSProjetCanada obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TSProjetCanada obj) {
		// TODO Auto-generated method stub
		return false;
	}


	public TSProjetCanada find(int id_projet) {
		System.out.println("---------------------------------------");
		System.out.println("recup TSprojetCanada");
		Statement st;
		TSProjetCanada tsProjetCanada = new TSProjetCanada();
		try {
			st = connection.createStatement();
			ResultSet res = st.executeQuery("select * from tsprojet_canada,projet where tsprojet_canada.id_projet='"+id_projet+"'");
			while(res.next()){
			double mo_non_determinee_ca = res.getDouble("mo_non_det");
			double mo_determinee_ca = res.getDouble("mo_det");
			double mo_soutien = res.getDouble("mo_soutien");
			tsProjetCanada = new TSProjetCanada(mo_non_determinee_ca, mo_determinee_ca, mo_soutien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tsProjetCanada;
	}

	@Override
	public TSProjetCanada find() {
		// TODO Auto-generated method stub
		return null;
	}

}
