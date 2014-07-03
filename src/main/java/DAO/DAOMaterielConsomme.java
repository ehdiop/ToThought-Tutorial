package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xyz.myproject.model.projet.MaterielConsomme;

public class DAOMaterielConsomme extends DAO<MaterielConsomme> {

	public DAOMaterielConsomme() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(MaterielConsomme obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(MaterielConsomme obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(MaterielConsomme obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MaterielConsomme find() {
		// TODO Auto-generated method stub
				Statement st;
				MaterielConsomme mat_cons = new MaterielConsomme();
				try {
					st = connection.createStatement();
					ResultSet res = st.executeQuery("select montant from mat_conso,projet where mat_conso.num_projet=projet.num_projet and mat_conso.NE_client=projet.NE_client");
					while(res.next()){
					mat_cons.setMontant(res.getDouble("montant"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return mat_cons;
			}

		}
