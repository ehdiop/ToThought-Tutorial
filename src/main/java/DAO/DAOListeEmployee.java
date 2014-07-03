package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xyz.myproject.model.exceptions.EmailException;
import com.xyz.myproject.model.general.ListeEmployee;
import com.xyz.myproject.model.projet.Email;
import com.xyz.myproject.model.projet.Employee;

public class DAOListeEmployee extends DAO<ListeEmployee> {

	public DAOListeEmployee() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(ListeEmployee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ListeEmployee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ListeEmployee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ListeEmployee find() {
		System.out.println("---------------------------------------");
		System.out.println("recup Liste employeee");
		// TODO Auto-generated method stub
		ListeEmployee employees = new ListeEmployee();
		try {
			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery("select * from employe");
			
			while (res.next()){
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
//				String fonction = res.getString("");
				String qualification = res.getString("qualification");
				boolean determine = res.getBoolean("determine");
				Email email;
				try {
					email = new Email(res.getString("mail"));
					Employee newEmp = new Employee(nom, prenom, null, qualification, determine, email);
					employees.add(newEmp);
				} catch (EmailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	
	public ListeEmployee find(int id_projet) {
		// TODO Auto-generated method stub
		ListeEmployee employees = new ListeEmployee();
		try {
			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery("select * "
					+ "from employe,employe_projet "
					+ "where employe_projet.id_projet="+id_projet+" "
					+ "and employe_projet.id_employe=employe.id_employe ");
			
			while (res.next()){
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
//				String fonction = res.getString("");
				String qualification = res.getString("qualification");
				boolean determine = res.getBoolean("determine");
				Email email;
				try {
					email = new Email(res.getString("mail"));
					Employee newEmp = new Employee(nom, prenom, null, qualification, determine, email);
					employees.add(newEmp);
				} catch (EmailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
	
	public ListeEmployee find(int annee, String ne) {
		// TODO Auto-generated method stub
		ListeEmployee employees = new ListeEmployee();
		try {
			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery("select * from employe,employe_client "
					+ "where employe.id_employe=employe_client.id_employe "
					+ "and employe_client.ne_client='"+ne+"' "
					+ "and employe_client.annee='"+annee+"'");
			
			while (res.next()){
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
//				String fonction = res.getString("");
				String qualification = res.getString("qualification");
				boolean determine = res.getBoolean("determine");
				Email email;
				try {
					email = new Email(res.getString("mail"));
					Employee newEmp = new Employee(nom, prenom, null, qualification, determine, email);
					employees.add(newEmp);
				} catch (EmailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
	
}
