package core;

import databaseConnection.DBConnection;
import databaseConnection.DBConnectionImpl;

public class InfoDb {
 
	private String link;
	private String typeDataBase;
	private String user;
	private String passwordEncrypted;

	private void  initBase(String link, String tdb, String user, String pe){
		this.link = link;
		this.typeDataBase = tdb;
		this.user = user;
		this.passwordEncrypted = pe;
	}
	
	public InfoDb (String link, String tdb, String user, String password){
		this.initBase(link, tdb, user, (PasswordManager.encrypt(password)));
	}
	
	public InfoDb (String link, String tdb, String user){
		this.initBase(link, tdb, user, null);
	}
	
	public DBConnection getDBCfromInfoDB()
	{
		String url = this.getLink();
		String usr = this.getUser();
		String pwd = (PasswordManager.decrypt(this.getPassWord()));
		
		return (new DBConnectionImpl(url, usr, pwd));
	}
	
	public String getLink(){
		return this.link;
	}
	
	public String getTypeDB(){
		return this.typeDataBase;
	}
	
	public String getPassWord(){
		return this.passwordEncrypted;
	}
	
	public String getUser(){
			return this.user;
	}
	
}
