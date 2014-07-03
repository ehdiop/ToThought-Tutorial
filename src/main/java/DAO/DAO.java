package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO<T> {
	protected Connection connection = null;

	
	public DAO() throws SQLException{
		this.connection=DriverManager.getConnection("jdbc:mysql://localhost/bdd_ficanada","root","f-iniciativas");
	}
	
	public abstract boolean create(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract T find();

}
