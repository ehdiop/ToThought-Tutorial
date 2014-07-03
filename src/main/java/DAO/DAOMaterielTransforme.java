package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xyz.myproject.model.projet.MaterielTransforme;

public class DAOMaterielTransforme extends DAO<MaterielTransforme> {

	public DAOMaterielTransforme() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(MaterielTransforme obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(MaterielTransforme obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(MaterielTransforme obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MaterielTransforme find() {
		// TODO Auto-generated method stub
		Statement st;
		MaterielTransforme mat_transfo = new MaterielTransforme();
		try {
			st = connection.createStatement();
			ResultSet res = st.executeQuery("select montant from mat_transfo,projet where mat_transfo.num_projet=projet.num_projet and mat_transfo.NE_client=projet.NE_client");
			while(res.next()){
			mat_transfo.setMontant(res.getDouble("montant"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mat_transfo;
	}

}
