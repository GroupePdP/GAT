package databaseInspection;

public interface JoinTable
{
	public String getSqlJoin();
	public boolean isTable1(String name);
	public boolean isTableN(String name);
	public boolean containeTable(String name);
	boolean containeTable(String name1, String name2);
	boolean containeTableInTheOrder(String name1, String nameN);
}
