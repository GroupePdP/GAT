package database_connection;

import java.sql.Connection;

public interface DBConnection {
	
	public boolean connection();
	public boolean disconnection();
	public ResultSet selectquery(String query);
