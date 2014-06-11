package br.com.ifsp.livro.pool;

import java.sql.Connection;
import java.sql.SQLException;

public class Pool {

	private Connection coon = null;
	
	public Connection getConnection(){
		
		try {
			this.coon = ServiceLocator.searchConnection("jdbc/MySQL");
		} catch (SQLException e) {
			return this.coon = null;
		}
		
		return this.coon;
	}
	
}
