package core;

import java.util.ArrayList;

import database_connection.DBConnection;

import linguistic.types_gestion.TypeTree;
import linguistic.*;

public class Projet {
	
	private TypeTree typeTree;
	private ArrayList<Scenario> listScenario;
	private DBConnection dbConnection;
	


	public TypeTree getTypeTree() {
		return typeTree;
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
