package databaseInspection;

import java.util.List;
import java.util.Map;

public interface Base 
{
	public String getName();
	public Table getTable(String name);
	public void addTable(Table newTable);
	public void addJoin(JoinTable newJoin);
	public List<JoinTable> getJoinTable();
	Map<String, Table> getListTable();

}
