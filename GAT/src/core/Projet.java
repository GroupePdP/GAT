package core;

import java.util.ArrayList;
import linguistic.types_gestion.LinguisticFactory;
import linguistic.*;

public class Projet {
	
	private LinguisticFactory linguisticFactory;
	private ArrayList<Scenario> listScenario;
	private InfoDb infoDB;
	private String name;
	
	public Projet (Scenario scenario){
		this.listScenario = new ArrayList<Scenario>();
		this.listScenario.add(scenario);
	}
	
	public Projet(String nom){
		this.listScenario = new ArrayList<Scenario>();
		this.name = nom;
	}
	
	public Projet(InfoDb db, String nom){
		this.listScenario = new ArrayList<Scenario>();
		this.infoDB = db;
		this.name = nom;
	}
	
	public Projet(){
		this.listScenario = new ArrayList<Scenario>();		
	}
	
	public String toString(){
		String s = "Projet " + this.name + "\n" + "Scenarios:";
		for (Scenario i: listScenario)
			s = s + i.toString() + "\n";
		
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

	public void setListScenario(ArrayList<Scenario> listScenario) {
		this.listScenario = listScenario;
	}

	public InfoDb getInfoDb() {
		return infoDB;
	}

	public void setInfoDb(InfoDb dbConnection) {
		this.infoDB = dbConnection;
	}
	
	
}
