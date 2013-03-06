package database_connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionImpl implements DBConnection {

	private Connection connection;	
	private String url;
	private String user;
	private String pwd;
	
	public DBConnectionImpl(String url, String user, String pwd){
		this.url = url;
		this.user = user;
		this.pwd = pwd;		
	}
	
	@Override
	public Connection connection() {
		// TODO Auto-generated method stub
		try{
			connection = DriverManager.getConnection(url, user, pwd);
		}catch(Exception e){
			e.printStackTrace();
		}		
		return connection;
	}

	@Override
	public Connection deconnection() {
		// TODO Auto-generated method stub	
		return null;
	}

}
