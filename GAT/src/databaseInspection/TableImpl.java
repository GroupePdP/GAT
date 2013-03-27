package databaseInspection;

import java.util.HashMap;
import java.util.Map;



public class TableImpl implements Table
{

	private String name;
	private Map<String,Line>  relation;
	
	public TableImpl (String name)
	{
		this.relation = new HashMap<String,Line>();
		this.name = name;
	}

	@Override
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public Line getLine(String key)
	{
		return this.relation.get(key);
	}

	@Override
	public void addLine(Line line) 
	{
		this.relation.put(line.getName(),line);
	}

}
