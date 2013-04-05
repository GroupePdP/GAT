package databaseInspection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class CookingRequestImpl implements CookingRequest 
{

	private Base db;
	private String requestCashe;
	private Queue <String[]> listeColumn;
	
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
	
	private String getFrom (ArrayList<String> listTable)
	{
		String from = "";
		
		for(String table : listTable )
		{
			from += table +" ";
		}
		
		
		return from;
	}
	
	//@TODO algo ni rapide ni meilleur solution 
	private String getJoin (ArrayList<String> listTable)
	{
		String join = "";
		//todo retire teste toujours faux quand le reste fonctionnera
		if(listTable.size() >2 && false == true)
		{
			ArrayList<String> ListTableTraveled = new ArrayList<String>();
			ArrayList<String> ListTableRequiredtraveled = new ArrayList<String>(listTable);
			
			String currentTable = ListTableRequiredtraveled.get(0);
			ListTableRequiredtraveled.remove(0);
			
			boolean nextTableFound = false;
			
			while(!ListTableRequiredtraveled.isEmpty())
			{
				for(JoinTable currentJoin : this.db.getJoinTable())
				{
					String nextTable = currentJoin.getAnotherTable(currentTable);
					if(!nextTable.isEmpty())
					{
						for(String RequiredTable : ListTableRequiredtraveled )
						{
							if(nextTable.equals(RequiredTable))
							{
								join += currentJoin.getSqlJoin();
								ListTableRequiredtraveled.remove(nextTable);
								ListTableTraveled.add(nextTable);
								nextTableFound = true;
								break;
							}
						}
					}
					if(nextTableFound)
					{
						break;
					}
				}
				if(!nextTableFound)
				{
					
				}
				
			}
			
		}
		
		return join;
	}
	
	private String makeRequest()
	{
		String newRequest ="";
		ArrayList<String> listTable = new ArrayList<String>();
		
		newRequest += this.getSelect(listTable);
		
		String sqljointure = this.getJoin(listTable);
		
		newRequest += " FROM " + this.getFrom(listTable);
		
		if(!sqljointure.isEmpty())
			newRequest += " WHERE " + sqljointure;
		
		newRequest += ";";
		
		return newRequest;
	}

	public CookingRequestImpl (Base db)
	{
		this.db = db;
		this.listeColumn = new LinkedList<String[]>();
		this.requestCashe = "";
	}
	
	@Override
	public String getRequest() {
		
		if(this.requestCashe.isEmpty()) {
			if(!this.listeColumn.isEmpty()) {
				this.requestCashe = makeRequest();
			}
		}
		
		return this.requestCashe;
	}

	@Override
	public void newRequest(){
		this.listeColumn.removeAll(listeColumn);
		this.requestCashe = "";
	}
	
	//@TODO pas de protection sur la validite des information donnee par l'utilisateur
	@Override
	public void addColumn(String table, String column) {
		String el[] = {table , column};
		this.requestCashe = "";
		this.listeColumn.add(el);
	}
}
