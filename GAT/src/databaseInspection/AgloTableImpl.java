package databaseInspection;

import java.util.ArrayList;

public class AgloTableImpl implements AgloTable {
	
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
	
	@Override
	public ArrayList<JoinTable> getJoinIntra(){
		return this.joinIntra;
	}
	
	@Override
	public ArrayList<JoinTable> getJoinExtra(){
		return this.joinExtra;
	}
	
	@Override
	public ArrayList<String> getListTable() {
		return this.listTable;
	}
	
	@Override
	public void fusion(AgloTable at, JoinTable contact)
	{
		for (String t : at.getListTable())
		{
			//@TODO faire traitement d'erreur si besoin
			if(!this.listTable.contains(t))
			{
				this.listTable.add(t);
			}
		}
		for (JoinTable jt : at.getJoinIntra())
		{
			//@TODO faire traitement d'erreur si besoin
			if(!this.joinIntra.contains(jt))
			{
				this.joinIntra.add(jt);
			}
		}
		for (JoinTable jt : at.getJoinExtra())
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
	
	@Override
	public JoinTable contact (AgloTable cible)
	{
		for (String t : cible.getListTable())
		{
			for (JoinTable jt :this.joinExtra)
			{
				if(jt.containTable(t))
					return jt;
			}
		}
		
		return null;
		
	}
	
	@Override
	public AgloTable contactRecursion(AgloTable cible, ArrayList<AgloTable> listAglo, int distance)
	{
		if(distance > 0)
		{
			for(AgloTable aglo :listAglo )
			{
				JoinTable jt = this.contact(aglo);
				if(jt != null)
				{
					AgloTable newAglo = null;
					System.out.println("grjhgerklmhgrhg");
					if(aglo.equals(cible))
					{
						System.out.println("grjhgerklmhgrhg");
						newAglo = cible;
					}
					else
					{
						newAglo = aglo.contactRecursion(cible, listAglo, distance-1);
					}
					
					if(newAglo != null)
					{
						if(!listAglo.remove(newAglo))
							System.out.println("coucoc");
						this.fusion(newAglo, jt);
						return this;
					}
				}
			}
		}
		return null;
	}
	@Override
	public ArrayList<JoinTable> getJoin (ArrayList<AgloTable> listCible, ArrayList<AgloTable> listAglo)
	{
		
		AgloTable agloJointure = null;
		
		for (AgloTable currentCible : listCible )
		{
			//System.out.println("coucoc");
			agloJointure = currentCible;
			for (AgloTable nextCible : listCible)
			{
				if(currentCible.equals(nextCible))
				{
					continue;
				}
				for (int  i = 1 ; i < listAglo.size(); i++ )
				{
					AgloTable newAglo = this.contactRecursion(nextCible, listAglo, i);
					if(newAglo != null)
					{
						listCible.remove(nextCible);
						break;
					}
				}
			}
		}
		
		System.out.println(listCible.size());
		System.out.println(listAglo.size());
		
		return  agloJointure.getJoinIntra();
	}

	@Override
	public boolean equals(AgloTable at) {
		boolean res = true;
		if(! this.joinExtra.equals(at.getJoinExtra()));
			res =false;
		if(! this.joinIntra.equals(at.getJoinIntra()));
			res= false;
		
		return res;
	}
	
	
	
}
