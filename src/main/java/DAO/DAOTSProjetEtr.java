package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xyz.myproject.model.projet.TSProjetEtr;

public class DAOTSProjetEtr extends DAO<TSProjetEtr>{

	public DAOTSProjetEtr() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(TSProjetEtr obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TSProjetEtr obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TSProjetEtr obj) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public TSProjetEtr find(int id_projet) {
		System.out.println("---------------------------------------");
		System.out.println("recup TSprojetEtr");
		Statement st;
		TSProjetEtr tsProjetEtr = new TSProjetEtr();
		try {
			st = connection.createStatement();
			ResultSet res = st.executeQuery("select * from tsprojet_etr where tsprojet_etr.id_projet='"+id_projet+"'");
			while(res.next()){
			double mo_non_determinee_ca = res.getDouble("mo_non_det");
			double mo_determinee_ca = res.getDouble("mo_det");
			tsProjetEtr = new TSProjetEtr(mo_non_determinee_ca, mo_determinee_ca);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tsProjetEtr;
	}

	@Override
	public TSProjetEtr find() {
		// TODO Auto-generated method stub
		return null;
	}

}
