package core;

import java.util.ArrayList;

import linguistic.Scenario;
import linguistic.typesGestion.LinguisticFactory;

public class Project{
	
	private LinguisticFactory linguisticFactory;
	private ArrayList<Scenario> listScenario;
	private InfoDb infoDB;
	private String name;
	
	/* Constructeurs */
	
	public Project (Scenario scenario){
		this.listScenario = new ArrayList<Scenario>();
		this.listScenario.add(scenario);
		this.linguisticFactory = LinguisticFactory.getInstance();
	}
	
	public Project(String name){
		this.listScenario = new ArrayList<Scenario>();
		this.name = name;
		this.linguisticFactory = LinguisticFactory.getInstance();
	}
	
	public Project(InfoDb db, String name){
		this.listScenario = new ArrayList<Scenario>();
		this.infoDB = db;
		this.name = name;
		this.linguisticFactory = LinguisticFactory.getInstance();
	}
	
	public Project(){
		this.listScenario = new ArrayList<Scenario>();
		this.linguisticFactory = LinguisticFactory.getInstance();
	}
	
	/* Acesseurs et modificateurs */
	
	public LinguisticFactory getLinguisticFactory(){
		return this.linguisticFactory;
	}
	
	public String getName(){
		return this.name;
	}

	public void setName(String nom){
		this.name = nom;
	}

	public ArrayList<Scenario> getListScenario(){
		return listScenario;
	}

	public void setListScenario(ArrayList<Scenario> listScenario){
		this.listScenario = listScenario;
	}

	public InfoDb getInfoDb(){
		return infoDB;
	}

	public void setInfoDb(InfoDb dbConnection){
		this.infoDB = dbConnection;
	}
	
	/* Autres methodes */ 
	
	public String toStringDescr(){
		String s = "Projet " + this.name + "\n" + "Scenarios:";
		for (Scenario i: listScenario)
			s = s + i.toString() + "\n";
		return s;
	}
	
	public String toString(){
		return this.name;
	}
	
	public void ajouterScenario (Scenario scenario){
		this.listScenario.add(scenario);
	}
	
	public void supprimerScenario (Scenario scenario){
		this.listScenario.remove(scenario);
	}
}
