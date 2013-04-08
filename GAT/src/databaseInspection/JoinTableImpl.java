package databaseInspection;

import java.util.ArrayList;

public class JoinTableImpl implements JoinTable{
	
	private String table1;
	private String tableN;
	private ArrayList<String> keys1;
	private ArrayList<String> keysN;
	

	
	public JoinTableImpl(String newTable1, String newTableN, 
			ArrayList<String> newKeys1, ArrayList<String> newKeysN){
		if(newKeys1.size() == newKeysN.size())
		{
			//@TODO declencher une erreur si les deux list de cle n'ont pas la meme taille
		}
		this.table1 = newTable1;
		this.tableN = newTableN;
		this.keys1 = newKeys1;
		this.keysN = newKeysN;
	}
	public JoinTableImpl(String newTable1, String newTableN, String newKeys1, String newKeysN){
		
		this.table1 = newTable1;
		this.tableN = newTableN;
		this.keys1 = new ArrayList<String>();
		this.keys1.add(newKeys1);
		this.keysN = new ArrayList<String>();
		this.keysN.add(newKeysN);
	}
	
	@Override
	public String getTable1(){
		return this.table1;
	}
	@Override
	public String getTableN(){
		return this.tableN;
	}
	
	private String ligneJointureSql(int i){
		String sql =""; // ?????
		sql += (this.table1);
		sql += (".");
		sql += (this.keys1.get(i));
		sql += (" = ");
		sql += (this.tableN);
		sql += (".");
		sql += (this.keysN.get(i));
		return sql;
	}
	
	@Override
	public String getSqlJoin(){
		int i = 0;
		String sql = this.ligneJointureSql(i);
		for(i = 1; i < this.keys1.size(); i++)
		{
			sql += ("AND");
			sql += (this.ligneJointureSql(i));
 		}
		return sql;
	}

	@Override
	public boolean isTable1(String name){
		return this.table1.compareTo(name) == 0;
	}

	@Override
	public boolean isTableN(String name){
		return this.tableN.compareTo(name) == 0;
	}

	@Override
	public boolean containTable(String name){
		return (this.isTable1(name) || this.isTableN(name));
	}
	
	@Override
	public boolean containTable(String name1, String name2){
		return (this.containTable(name1) && this.containTable(name2));
	}
	
	@Override
	public boolean containTableInTheOrder(String name1, String nameN){
		return (this.isTable1(name1) && this.isTableN(nameN));
	}

	@Override
	public String getAnotherTable(String name){
		String anotherTable ="";
		if(this.isTable1(name))
			anotherTable = this.tableN;
		else if(this.isTableN(name))
			anotherTable = this.table1;
		return anotherTable;
	}

}
