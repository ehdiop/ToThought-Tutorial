package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xyz.myproject.model.exceptions.EmailException;
import com.xyz.myproject.model.general.EmployesImpliques;
import com.xyz.myproject.model.projet.Email;
import com.xyz.myproject.model.projet.Employee;

public class DAOEmployeImplique extends DAO<EmployesImpliques> {

	public DAOEmployeImplique() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(EmployesImpliques obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(EmployesImpliques obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(EmployesImpliques obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EmployesImpliques find() {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployesImpliques find(int id_projet) {
		System.out.println("---------------------------------------");
		System.out.println("recup Employe impliques");
		EmployesImpliques empImp = new EmployesImpliques();
		try {
			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery("select * "
					+ "from employe,employe_projet where "
					+ "employe.id_employe = employe_projet.id_employe "
					+ "and employe_projet.id_projet = "+id_projet+"");
			
			while(res.next()){
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
				boolean determine = res.getBoolean("determine");
				String qualification = res.getString("qualification");
				Email email;
				try {
					email = new Email(res.getString("mail"));
					Employee e = new Employee(nom, prenom, null, qualification, determine, email);
					empImp.add(e);
				} catch (EmailException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empImp;
	}
}
