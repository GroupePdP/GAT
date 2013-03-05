package ihm.basedonnees;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnexionImpl implements DBConnexion {

	private Connection connexion;	
	private String url;
	private String user;
	private String pwd;
	
	public DBConnexionImpl(String url, String user, String pwd){
		this.url = url;
		this.user = user;
		this.pwd = pwd;		
	}
	
	@Override
	public Connection connexion() {
		// TODO Auto-generated method stub
		try{
			connexion = DriverManager.getConnection(url, user, pwd);
		}catch(Exception e){
			e.printStackTrace();
		}		
		return connexion;
	}

	@Override
	public Connection deconnexion() {
		// TODO Auto-generated method stub	
		return null;
	}

}
