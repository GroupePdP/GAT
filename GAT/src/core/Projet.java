package core;

import java.util.ArrayList;

import database_connection.DBConnection;

import linguistic.types_gestion.LinguisticFactory;
import linguistic.types_gestion.TypeTree;
import linguistic.*;

public class Projet {
	
	private LinguisticFactory linguisticFactory;
	private ArrayList<Scenario> listScenario;
	private DBConnection dbConnection;
	private String name = "default_name";
	
	public Projet (Scenario scenario){
		this.listScenario = new ArrayList<Scenario>();
		this.listScenario.add(scenario);
	}
	
	public Projet(String nom){
		this.listScenario = new ArrayList<Scenario>();
		this.name = nom;
	}
	
	public Projet(DBConnection db, String nom){
		this.listScenario = new ArrayList<Scenario>();
		this.dbConnection = db;
		this.name = nom;
	}
	
	public Projet(){
		this.listScenario = new ArrayList<Scenario>();		
	}
	
	public String toString(){
		String s = "Projet " + this.name + "\n" + "Scenarios:";
		for (Scenario i: listScenario)
			s = s + i.getName() + "\n";
		
		return s;
	}
	
	
	public String getName(){
		return this.name;
	}

	public void setName(String nom){
		this.name = nom;
	}

	public void ajouterScenario (Scenario scenario){
		this.listScenario.add(scenario);
	}
	
	public void supprimerScenario (Scenario scenario){
		this.listScenario.remove(scenario);
	}

	public ArrayList<Scenario> getListScenario() {
		return listScenario;
	}

	public void setList_scenario(ArrayList<Scenario> listScenario) {
		this.listScenario = listScenario;
	}

	public DBConnection getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	
}
