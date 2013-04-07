package databaseInspection;

public interface Table {
	
	public String getName();
	public Column getColumn(String key);
	public void addColumn(Column line);
}
