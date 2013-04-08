package databaseInspection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RequestMakerImpl implements RequestMaker{

	private Base db;
	private String requestCache;
	private Queue <String[]> listeColumn;

	private String getSelect (ArrayList<String> listTable){
		String select = "SELECT";
		for(String [] el : this.listeColumn)
		{
			if(!listTable.contains(el[0]))
				listTable.add(el[0]);
			select += " " + el[0] + "." + el[1] + ",";
		}
		return select.substring(0,select.length()-1);		
	}

	private String getFrom (ArrayList<String> listTable){
		String from = "";
		for(String table : listTable )
			from += table +" ";
		return from;
	}

	//@TODO algo ni rapide ni meilleur solution 
	private String getJoin (ArrayList<String> listTable){
		for(String s : listTable)
			System.out.println(s);

		String join = "";

		/* partie creation agloTable */
		ArrayList<AgloTable> listAgloTable = new ArrayList<AgloTable>();
		ArrayList<AgloTable> listCibleAgloTable = new ArrayList<AgloTable>();

		Set<String> listNameTable = this.db.getListTable().keySet();
		Iterator<String> it = listNameTable.iterator();
		while(it.hasNext())
		{
			String nameTable = it.next();
			Table currentTable = this.db.getTable(nameTable);

			ArrayList<JoinTable> join4CurrentTable = new ArrayList<JoinTable>();

			for(JoinTable jt : this.db.getJoinTable())
			{
				if(jt.containTable(currentTable.getName()))
					join4CurrentTable.add(jt);
			}
			AgloTable newAgloTable= new AgloTableImpl(
					currentTable.getName(), join4CurrentTable);
			listAgloTable.add(newAgloTable);

			for(String cibleName : listTable)
			{
				if(cibleName.contentEquals(currentTable.getName()))
					listCibleAgloTable.add(newAgloTable);
			}
		}

		/* fin */

		/* debut jointure */
		ArrayList<JoinTable> listjoin = listCibleAgloTable.get(0).
				getJoin(listCibleAgloTable, listAgloTable);
		System.out.println(listjoin.size());
		for(JoinTable jt : listjoin)
		{
			join += " " + jt.getSqlJoin() + " AND";
			if(listTable.contains(jt.getTableN()))
				listTable.add(jt.getTableN());
			if(listTable.contains(jt.getTable1()))
				listTable.add(jt.getTable1());
		}
		return join.substring(0,join.length()-4);
	}

	private String makeRequest(){

		String newRequest = "";
		ArrayList<String> listTable = new ArrayList<String>();
		newRequest += this.getSelect(listTable);
		String sqljointure = "";
		if(listTable.size() > 1)
			sqljointure = this.getJoin(listTable);
		newRequest += " FROM " + this.getFrom(listTable);

		if(listTable.size() > 1)
			newRequest += " WHERE " + sqljointure;
		
		newRequest += ";";
		return newRequest;
	}

	public RequestMakerImpl (Base db){
		this.db = db;
		this.listeColumn = new LinkedList<String[]>();
		this.requestCache = "";
	}

	@Override
	public String getRequest(){

		if(this.requestCache.isEmpty()){
			if(!this.listeColumn.isEmpty())
				this.requestCache = makeRequest();
		}
		return this.requestCache;
	}

	@Override
	public void newRequest(){
		this.listeColumn.removeAll(listeColumn);
		this.requestCache = "";
	}

	//@TODO pas de protection sur la validite des informations donnees par l'utilisateur
	@Override
	public void addColumn(String table, String column){
		String el[] = {table , column};
		this.requestCache = "";
		this.listeColumn.add(el);
	}
}
