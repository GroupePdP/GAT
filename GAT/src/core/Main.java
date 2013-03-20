package core;

import linguistic.Scenario;
import ihm.MainFrame;

public class Main {


	public static void main(String[] args){

		String emplacement = System.getProperty("user.dir").substring(0, System.getProperty("user.dir").length() -4) + "\\Projets";
		


		//test

		
		Scenario test1 = new Scenario ("test1");
		Scenario test2 = new Scenario ("test3");
		Projet P = new Projet(test1);
		P.ajouterScenario(test2);
	
		Core core = new Core(emplacement, P);
		
		core.sauvegarderProjet("CreationNouveauProjet");

		String[] fichiersXml = core.getStockageLocal();
		for (String i : fichiersXml){
			System.out.println(i);
			
			
		MainFrame mf = new MainFrame();
		}
	}
}
