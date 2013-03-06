package database_connection;

import java.sql.Connection;

public interface DBConnection {
	
	public Connection connection();
	public Connection deconnection();

}
