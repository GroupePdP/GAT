package databaseInspection;

import java.util.ArrayList;

public interface AgloTable {

	public void fusion(AgloTable at, JoinTable contact);
	public ArrayList<JoinTable> getJoinIntra();
	public ArrayList<JoinTable> getJoinExtra();
	public JoinTable contact(AgloTable cible);
	public ArrayList<String> getListTable();
	public ArrayList<JoinTable> getJoin(ArrayList<AgloTable> listCible,ArrayList<AgloTable> listAglo);
	public AgloTable contactRecursion(AgloTable cible, ArrayList<AgloTable> listAglo, int distance);
	public boolean equals (AgloTable at);
	

}
