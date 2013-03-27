package databaseInspection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BaseImpl implements Base
{
	private String name;
	private Map<String,Table> listTable;
	private ArrayList<JoinTable> listJoin;

	public BaseImpl(String name){
		this.name = name;
		this.listTable = new HashMap<String, Table>();
		this.listJoin = new ArrayList<JoinTable>();
	}

	@Override
	public String getName(){
		return this.name;
	}

	@Override
	public Table getTable(String name){
		return this.listTable.get(name);
	}
	
	@Override
	public List<JoinTable> getJoin(){
		return this.listJoin;
	}
	
	@Override
	public void addTable(Table newTable){
		this.listTable.put(newTable.getName(), newTable);		
	}
	
	@Override
	public void addJoin(JoinTable newJoin){
		this.listJoin.add(newJoin);
	}

}
