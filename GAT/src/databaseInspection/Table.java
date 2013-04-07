package databaseInspection;

import java.util.Map;

public interface Table {
	
	public String getName();
	public Column getColumn(String key);
	public void addColumn(Column line);
	public Map<String, Column> getColumn();
}
