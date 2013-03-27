package databaseInspection;

public interface JoinTable
{
	public String getSqlJoin();
	public boolean isTable1(String name);
	public boolean isTableN(String name);
	public boolean containTable(String name);
	boolean containTable(String name1, String name2);
	boolean containTableInTheOrder(String name1, String nameN);
}
