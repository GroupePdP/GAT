package databaseInspection;


public interface CookingRequest {
	
	public String getRequest();
	public void addColumn(String table , String column);
	public void newRequest();
}
