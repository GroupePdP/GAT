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
	
	public static boolean setInstance( String url, String user, String pwd)
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
	
	//TODO void *** trows
	@Override
	public boolean connection() 
	{
		boolean success = false;
		if(connection ==null)
		try{
			this.connection = DriverManager.getConnection(url, user, pwd);
			this.statement = connection.createStatement();
			success = true;
		}catch(Exception e){
			e.printStackTrace();
		}		
		return success ;
	}
	
	//TODO void *** trows
	@Override
	public boolean disconnection()
	{
		boolean success = false;
		if ( connection != null )
        try {
            this.connection.close();
            this.connection = null;
            this.statement = null;
            success = true;
        } catch ( SQLException ignore ) {
            ignore.printStackTrace();
        }	
		return success;
	}
	
	public ResultSet selectquery(String query)
	{
		resultset = null;
		
		if(statement != null)
		{
			try{
		 	resultset = this.statement.executeQuery(query);
			}
			catch(Exception e){
				
			}
		}
		
		return resultset;
			
	}

}
