package src.core;

import java.util.ArrayList;

import src.database_connection.DBConnection;

import src.linguistic.types_gestion.TypeTree;
import src.linguistic.*;

public class Projet {
	
	private TypeTree typeTree;
	private ArrayList<Scenario> listScenario;
	private DBConnection dbConnection;
	


	public TypeTree getType_tree() {
		return typeTree;
	}



	public ArrayList<Scenario> getList_scenario() {
		return listScenario;
	}

	public void setList_scenario(ArrayList<Scenario> list_scenario) {
		this.listScenario = list_scenario;
	}

	public DBConnection getDb_connection() {
		return dbConnection;
	}

	public void setDb_connection(DBConnection db_connection) {
		this.dbConnection = db_connection;
	}
	
	
}
