package databaseInspection;

import java.util.List;
import java.util.Map;

public interface Base{
	
	public String getName();
	public Map<String, Table> getListTable();
	public List<JoinTable> getJoinTable();

	public Table getTable(String name);
	public void addTable(Table newTable);
	public void addJoin(JoinTable newJoin);
}
