package com.xyz.myproject.bdd.enums;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;
 

/**
 * A generic UserType implementation for Enum. To work with my mysql database, enum names must be uppercase.
 * @author Some guy on the internet
 *
 * @param <E>
 */
public class EnumUserType<E extends Enum<E>> implements UserType { 
    private Class<E> clazz = null; 
    protected EnumUserType(Class<E> c) { 
        this.clazz = c; 
    } 
 
    private static final int[] SQL_TYPES = {Types.VARCHAR}; 
    public int[] sqlTypes() { 
        return SQL_TYPES; 
    } 
 
    public Class returnedClass() { 
        return clazz; 
    } 
 
 

    public Object deepCopy(Object value) throws HibernateException{ 
        return value; 
    } 
 
    public boolean isMutable() { 
        return false; 
    } 
 
    public Object assemble(Serializable cached, Object owner) throws HibernateException  {
         return cached;
    } 
 
    public Serializable disassemble(Object value) throws HibernateException { 
        return (Serializable)value; 
    } 
 
    public Object replace(Object original, Object target, Object owner) throws HibernateException { 
        return original; 
    } 
    public int hashCode(Object x) throws HibernateException { 
        return x.hashCode(); 
    } 
    public boolean equals(Object x, Object y) throws HibernateException { 
        if (x == y) 
            return true; 
        if (null == x || null == y) 
            return false; 
        return x.equals(y); 
    }

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,
			SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		   String name = rs.getString(names[0]); 
	        E result = null; 
	        if (!rs.wasNull()) { 
	            result = Enum.valueOf(clazz, name.toUpperCase()); 
	        } 
	        return result; 
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor session) throws HibernateException, SQLException {
		   if (null == value) { 
	            st.setNull(index, Types.VARCHAR); 
	        } else { 
	            st.setString(index, ((Enum)value).name()); 
	        } 
		
	} 
} 