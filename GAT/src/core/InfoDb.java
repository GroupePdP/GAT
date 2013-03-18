package src.core;

public class InfoDb {
 
	private String link;
	private String typeDataBase;
	private String user;
	private String passwordEncrypted;

	
	private void  initBase(String link, String tdb, String user, String pe)
	{
		this.link = link;
		this.typeDataBase = tdb;
		this.user = user;
		this.passwordEncrypted = pe;
	}
	
	public InfoDb (String link, String tdb, String user, String pe)
	{
		this.initBase(link, tdb, user, pe);
	}
	public InfoDb (String link, String tdb, String user)
	{
		this.initBase(link, tdb, user, null);
	}
	
	public String getLink()
	{
		return this.link;
	}
	
	public String getTypeDB()
	{
		return this.typeDataBase;
	}
	public String getPassWord()
	{
		return this.passwordEncrypted;
	}
	
	public String getUser()
	{
			return this.user;
	}
	
}
