package database_connection;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DBConnection 
{
	public boolean connection() throws SQLException;
	public boolean disconnection() throws SQLException;
	public ResultSet selectQuery(String query) throws SQLException;
}