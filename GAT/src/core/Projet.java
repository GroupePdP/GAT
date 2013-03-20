package core;

import java.util.ArrayList;

import database_connection.DBConnection;

import linguistic.types_gestion.TypeTree;
import linguistic.*;

public class Projet {
	
	private TypeTree typeTree;
	private ArrayList<Scenario> listScenario;
	private DBConnection dbConnection;
	
	public Projet(Scenario scenario){
		this.listScenario = new ArrayList<Scenario>();
		this.listScenario.add(scenario);
	}
	
	

	public TypeTree getTypeTree() {
		return typeTree;
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
