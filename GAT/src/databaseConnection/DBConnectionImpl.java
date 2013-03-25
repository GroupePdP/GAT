package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;     
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionImpl implements DBConnection 
{

	private Connection connection;
	private ResultSet resultSet;
	private Statement statement;
	private String url ;
	private String user;
	private String pwd ;
	
	public DBConnectionImpl(String url, String user, String pwd)
	{	
		this.connection = null;
		this.statement = null;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
	}
	
	
	@Override
	public boolean connection() throws SQLException 
	{
		boolean success = false;
		if(connection ==null)
		{
			this.connection = DriverManager.getConnection(url, user, pwd);
			this.statement = connection.createStatement();
			success = true;
		}
		return success ;
	}
	
	@Override
	public boolean disconnection() throws SQLException
	{
		boolean success = false;
		
		if ( connection != null )
		{
			this.connection.close();
			this.connection = null;
			this.statement = null;
			success = true;
		}
		return success;
	}
	
	public ResultSet selectQuery(String query) throws SQLException
	{
		ResultSet resultSet = null;
		
		if(statement != null)
		{
			resultSet = this.statement.executeQuery(query);
		}
		return resultSet;

	}

}