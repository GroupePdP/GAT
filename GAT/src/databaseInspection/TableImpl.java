package databaseInspection;

import java.util.HashMap;
import java.util.Map;

public class TableImpl implements Table{

	private String name;
	private Map<String,Column> relation;
	
	public TableImpl (String name){
		this.relation = new HashMap<String,Column>();
		this.name = name;
	}

	@Override
	public String getName(){
		return this.name;
	}
	
	@Override
	public Column getColumn(String key){
		return this.relation.get(key);
	}
	
	@Override
	public Map<String,Column> getColumn(){
		return this.relation;
	}
	@Override
	public void addColumn(Column col){
		this.relation.put(col.getName(),col);
	}
}
