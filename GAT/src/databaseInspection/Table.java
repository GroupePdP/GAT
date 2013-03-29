package databaseInspection;

public interface Table 
{
	public Column getLine(String key);
	
	public void addLine(Column line);

	public String getName();
}
