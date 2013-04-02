package databaseInspection;

import java.util.ArrayList;

public class AgloTableImpl {
	
	ArrayList<String> listTable;
	ArrayList<JoinTable> joinIntra;
	ArrayList<JoinTable> joinExtra;
	
	
	public AgloTableImpl (String table, ArrayList<JoinTable> listJoin)
	{
		this.listTable = new ArrayList<String>();
		this.listTable.add(table);
		
		this.joinExtra = new ArrayList<JoinTable>();
		for (JoinTable jointable : listJoin)
		{
			if(jointable.containTable(table))
				this.joinExtra.add(jointable);
		}
		
		this.joinIntra = new ArrayList<JoinTable>();
		
	}
	
	public void fusion(AgloTableImpl at, JoinTable contact)
	{
		for (String t : at.listTable)
		{
			//@TODO faire traitement d'erreur si besoin
			if(!this.listTable.contains(t))
			{
				this.listTable.add(t);
			}
		}
		for (JoinTable jt : at.joinIntra)
		{
			//@TODO faire traitement d'erreur si besoin
			if(!this.joinIntra.contains(jt))
			{
				this.joinIntra.add(jt);
			}
		}
		for (JoinTable jt : at.joinExtra)
		{
			//@TODO faire traitement d'erreur si besoin
			if(!this.joinExtra.contains(jt) )
			{
				this.joinExtra.add(jt);
			}
		}
		
		this.joinIntra.add(contact);
		this.joinExtra.remove(contact);
		
	}
	
	public JoinTable contact (AgloTableImpl at)
	{
		for (String t : at.listTable)
		{
			for (JoinTable jt :this.joinExtra)
			{
				if(jt.containTable(t))
					return jt;
			}
		}
		
		return null;
		
	}
	public JoinTable contact(AgloTableImpl cible, ArrayList<AgloTableImpl> listAt, int distance)
	{
		if(distance == 1)
			return this.contact(cible);
		
		if(distance > 1)
		{
	//		ArrayList<AgloTableImpl> chemin = new ArrayList<AgloTableImpl>();
			
			//for ()
			
		}
		
		return null;
		
	}

}
