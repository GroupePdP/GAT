package databaseInspection;

import java.util.List;

public interface Base 
{
	public String getName();
	public Table getTable(String name);
	public void addTable(Table newTable);
	public List<JoinTable> getJoin();
	public void addJoin(JoinTable newJoin);

}
