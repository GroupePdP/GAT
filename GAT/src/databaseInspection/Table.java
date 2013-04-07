package databaseInspection;

public interface Table {
	
	public String getName();
	public Column getLine(String key);
	public void addLine(Column line);
}
