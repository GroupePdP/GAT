package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import linguistic.Scenario;
import core.*;


public class ProjetTest {
	
	Core core, core2, core3;
	String emplacement, random;
	Project P, P2, P3, P4;
	Scenario test1, test2;
	InfoDb db;
	
	@Before
	public void initialize() {
		
		emplacement = System.getProperty("user.dir").substring(0, System.getProperty("user.dir").length() -4) + "\\Projets";
		
		//Nom de fichier aleatoire
		random = "test" + Math.random();
		
		db = new InfoDb("link","type","user","password");
		
		
		//Creation de 3 projets normalement identiques
		test1 = new Scenario ("test1");
		test2 = new Scenario ("test3");
		P = new Project(test1);
		P.ajouterScenario(test2);
		P.setName("projet");
		P.setInfoDb(db);
		
		P2 = new Project("projet");
		P2.ajouterScenario(test1);
		P2.ajouterScenario(test2);
		P2.setInfoDb(db);

		P3 = new Project();
		P3.setName("projet");
		P3.ajouterScenario(test1);
		P3.ajouterScenario(test2);
		P3.setInfoDb(db);
		
		//rajout d'un projet volontairement diff�rent des 3 autres
		P4 = new Project("test_icule");
		P4.ajouterScenario(test1);

		
		core = new Core(emplacement, P);
		core.backupProject(random);
		
		core2 = new Core(emplacement, null);
		core2.loadProject(random);		
		
		core3 = new Core (emplacement, P4);
		core3.loadProject(random);
	}
	
	//on teste les 3 core pour v�rifier leur correspondance
	@Test
	public void testProjet1() {
		assertEquals(core.toString(),(core2.toString()));
		assertEquals(core.toString(),(core3.toString()));
		assertEquals(core2.toString(),(core3.toString()));
	}
		
	//on compare les 3 core aux projets de test
	@Test
	public void testProjet2() {		
		assertEquals(core.toString(),(P.toString()));
		assertEquals(core.toString(),(P2.toString()));
		assertEquals(core.toString(),(P3.toString()));
		
		
		assertEquals(core2.toString(),(P.toString()));
		assertEquals(core2.toString(),(P2.toString()));
		assertEquals(core2.toString(),(P3.toString()));

		
		assertEquals(core3.toString(),(P.toString()));
		assertEquals(core3.toString(),(P2.toString()));
		assertEquals(core3.toString(),(P3.toString()));
	}
	
	
	//on compare un des projets au projet diff�rent
	@Test
	public void testProjet_mustfail(){	
		assertEquals(core.toString(),(P4.toString()));

	}
}
