package databaseInspection;

import java.util.ArrayList;

public class JoinTableImpl implements JoinTable 
{
	private String table1;
	private String tableN;
	private ArrayList<String> keys1;
	private ArrayList<String> keysN;
	
	private String ligneJointureSql(int i)
	{
		String sql ="";
		sql.concat(this.table1);
		sql.concat(".");
		sql.concat(this.keys1.get(i));
		sql.concat(" = ");
		sql.concat(this.tableN);
		sql.concat(".");
		sql.concat(this.keysN.get(i));
		
		return sql;
	}
	
	
	public JoinTableImpl(String newTable1, String newTableN,ArrayList<String> newKeys1, ArrayList<String> newKeysN )
	{
		if(newKeys1.size()==newKeysN.size())
		{
			//@TODO déclancher une erreur si les deux list de cle n'ont pas la meme taille
		}
		
		this.table1=newTable1;
		this.tableN=newTableN;
		this.keys1=newKeys1;
		this.keysN=newKeysN;
	}
	
	@Override
	public String getSqlJoin() 
	{
		int i =0;
		String sql = this.ligneJointureSql(i);
		
		for(i =1; i<this.keys1.size(); i++ )
		{
			sql.concat(" AND ");
			sql.concat(this.ligneJointureSql(i));
 		}
		
		return sql;
	}

	@Override
	public boolean isTable1(String name) 
	{
		return this.table1.compareTo(name)==0;
	}

	@Override
	public boolean isTableN(String name) 
	{
		return this.tableN.compareTo(name)==0;
	}

	@Override
	public boolean containeTable(String name) 
	{
		return this.isTable1(name) || this.isTableN(name);
	}
	
	@Override
	public boolean containeTable(String name1, String name2)
	{
		return this.containeTable(name1) && this.containeTable(name2);
	}
	
	@Override
	public boolean containeTableInTheOrder(String name1, String nameN)
	{
		return this.isTable1(name1) && this.isTableN(nameN);
	}
	

}
