package databaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DBConnection{
	
	public boolean connection() throws SQLException;
	public boolean disconnection() throws SQLException;
	public String getNameBase();
	public ResultSet selectQuery(String query) throws SQLException;
}