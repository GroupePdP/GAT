package core;

import java.util.ArrayList;

import database_connection.DBConnection;

import linguistic.types_gestion.TypeTree;
import linguistic.*;

public class Projet {
	
	private TypeTree type_tree;
	private ArrayList<Scenario> list_scenario;
	private DBConnection db_connection;
	


	public TypeTree getType_tree() {
		return type_tree;
	}

	public void setType_tree(TypeTree type_tree) {
		this.type_tree = type_tree;
	}

	public ArrayList<Scenario> getList_scenario() {
		return list_scenario;
	}

	public void setList_scenario(ArrayList<Scenario> list_scenario) {
		this.list_scenario = list_scenario;
	}

	public DBConnection getDb_connection() {
		return db_connection;
	}

	public void setDb_connection(DBConnection db_connection) {
		this.db_connection = db_connection;
	}
	
	
}
