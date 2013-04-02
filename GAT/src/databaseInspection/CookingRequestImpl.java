package databaseInspection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class CookingRequestImpl implements CookingRequest 
{

	private Base db;
	private Queue <String[]> listeColumn;
	
	public CookingRequestImpl (Base db)
	{
		this.db = db;
		this.listeColumn = new LinkedList<String[]>();
	}

	private String getSelect (ArrayList<String> listTable)
	{
		String select = "SELECT";
		
		for(String [] el : this.listeColumn)
		{
			if(!listTable.contains(el[0]))
				listTable.add(el[0]);

			select += " "+el[0]+"."+el[1]+",";
		}
		
		return select.substring(0,select.length()-1);		
	}
	
	
	//@TODO a refair 100/100 hack
	private String getJoin (ArrayList<String> listTable)
	{
		String join = "";
		
		if(listTable.size() > 1)
		{
			ArrayList<AgloTableImpl> aglo = new ArrayList<AgloTableImpl>();
			for(String table : listTable)
			{
				ArrayList<JoinTable> ajt = new ArrayList<JoinTable>();
				for(JoinTable jt : db.getJoin())
				{
					if(jt.containTable(table))
						ajt.add(jt);
				}
				
				aglo.add(new AgloTableImpl(table, ajt));
				
				
			}
			
			
			
		}
		
		return join;
	}
	
	private String getFrom (ArrayList<String> listTable)
	{
		String from = "";
		
		for(String table : listTable )
		{
			from += table +" ";
		}
		
		
		return from;
	}
	@Override
	public String getRequest() {
		
		String newRequest = "";
		
		if(!this.listeColumn.isEmpty())
		{
			ArrayList<String> listTable = new ArrayList<String>();
			
			newRequest += this.getSelect(listTable);
			
			String sqljointure = this.getJoin(listTable);
			
			newRequest += " FROM " + this.getFrom(listTable);
			
			if(!sqljointure.isEmpty())
				newRequest += " WHERE " + sqljointure;
			
			newRequest += ";";
		}
		return newRequest;
	}

	@Override
	public void newRequest()
	{
		this.listeColumn.removeAll(listeColumn);
	}
	
	@Override
	public void addColumn(String table, String column) {
		String el[] = {table , column};
		
		this.listeColumn.add(el);
	}
}
