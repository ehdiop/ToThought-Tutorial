package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.xyz.myproject.model.exceptions.EmailException;
import com.xyz.myproject.model.general.ListE;
import com.xyz.myproject.model.general.ListeEmployee;
import com.xyz.myproject.model.general.ListeEmployee.EMPLOYEE;
import com.xyz.myproject.model.projet.Email;
import com.xyz.myproject.model.projet.Employee;

public class DAOListeEmploye extends DAO<List<Employee>>{

	public DAOListeEmploye() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(List<Employee> obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(List<Employee> obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(List<Employee> obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> find() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> find(int annee, String ne) {
		System.out.println("---------------------------------------");
		System.out.println("recup Liste employes");
		ListE<Employee> listEmp = new ListeEmployee();
		try {
			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery("select * from employe,employe_client"
					+ " where employe.id_employe=employe_client.id_employe"
					+ " and employe_client.ne_client='"+ne+"' "
					+ "and employe_client.annee='"+annee+"'");

			while(res.next()){
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
				boolean determine = res.getBoolean("determine");
				String mail = res.getString("mail");
				Email email;
				String qualification = res.getString("qualification");			
				try {
					email = new Email(mail);
					Employee newEmp = new Employee(nom, prenom, null, qualification, determine, email);
					listEmp.add(newEmp, EMPLOYEE.ADD);
				} catch (EmailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listEmp.getList();
	}
}
