package br.com.ifsp.livro.pool;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ServiceLocator {

	
	public static Connection searchConnection(String JNDINome) throws SQLException{
		
		Context initContext = null;
		
		try {
			initContext = new InitialContext();
		} catch (NamingException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		Context envContext = null;
			
		try {
			envContext = (Context) initContext.lookup("java:comp/env");
		} catch (NamingException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		DataSource ds = null;
		
		try {
			ds = (DataSource) envContext.lookup(JNDINome);
		} catch (NamingException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return ds.getConnection();
	}
	
}
