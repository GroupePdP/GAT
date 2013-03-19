package database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;     
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionImpl implements DBConnection 
{

	private static volatile DBConnectionImpl instance = null;
	private Connection connection;
	private ResultSet resultset;
	private Statement statement;
	private String url ;
	private String user;
	private String pwd ;
	
	private DBConnectionImpl(String url, String user, String pwd)
	{	
		this.connection = null;
		this.statement = null;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
	}
	
	public static boolean resetInstance( String url, String user, String pwd)
	{
		boolean set =false;
		if (DBConnectionImpl.instance == null || DBConnectionImpl.instance.connection == null)
		{
			synchronized(DBConnectionImpl.class)
			{
				if (DBConnectionImpl.instance == null || DBConnectionImpl.instance.connection == null)
				{
					DBConnectionImpl.instance = new DBConnectionImpl(url,user,pwd);
					set =true;
				}
			}
		}
		return set;
	}
	
	public static DBConnectionImpl getInstance()
	{
		return DBConnectionImpl.instance;
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
		ResultSet resultset = null;
		
		if(statement != null)
		{
			resultset = this.statement.executeQuery(query);
		}
		return resultset;

	}

}
