package databaseInspection;

public interface RequestMaker{
	
	public String getRequest();
	public void addColumn(String table, String column);
	public void newRequest();
}
