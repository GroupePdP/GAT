package databaseInspection;

import java.util.ArrayList;



public interface Base 
{

	public String getName();
	public Table getTable(String name);
	public void addTable(Table newTable);
	public ArrayList<JoinTable> getJoin();
	public void addJoin(JoinTable newJoin);

}
