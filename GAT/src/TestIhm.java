import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import core.Core;
import core.Project;

import linguistic.conceptsGestion.Concept;
import linguistic.conceptsGestion.ConceptSimple;
import linguistic.typesGestion.LinguisticFactory;
import linguistic.typesGestion.Type;


import ihm.*;

public class TestIhm {
	public static void main(String[] args){
		/*
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	MainFrame mf = new MainFrame();
            }
        });
        
        */
		Project tmp = new Project("Projet test");
		LinguisticFactory lf = tmp.getLinguisticFactory();
		
		
		
		Type t1 = lf.makeType("personne");
		Type t2 = lf.makeType("joueur", t1);
		Type t3 = lf.makeType("gain_de_match");
		Type t4 = lf.makeType("match");
		Type t5 = lf.makeType("relation_event");
		Type t6 = lf.makeType("etre_vainqueur");
		Type t7 = lf.makeType("competition");
		Type t8 = lf.makeType("_test_");
		
		Concept c1 = lf.makeConcept("Joueur1",t2);
		Concept c8 = lf.makeConcept("Joueur2",t2);
		Concept c2 = lf.makeConcept("Match 2",t4);
		Concept c6 = lf.makeConcept("Competition 1",t7);
		
		List<Type> l = new ArrayList<Type>();
		l.add(t2); l.add(t4);
		Concept c3 = lf.makeConcept("gagner",t3,l); // concept (gagner(joueur, match))
		
		List<Type> l2 = new ArrayList<Type>();
		l2.add(t2); l2.add(t7);
		Concept c4 = lf.makeConcept("etre_vainqueur",t6,l2); // concept (etre_vainqueur(joueur, competition))
		
		List<Type> l3 = new ArrayList<Type>();
		l3.add(t3); l3.add(t6);
		Concept c5 = lf.makeConcept("cause",t5,l3); // concept (cause(gagner, etre_vainqueur))
		
		List<Type> l4 = new ArrayList<Type>();
		l4.add(t5); l4.add(t1);
		Concept c7 = lf.makeConcept("test",t8,l4); // concept (cause(gagner, etre_vainqueur))

		
		
		String emplacement = System.getProperty("user.dir").substring(0, System.getProperty("user.dir").length() -4) + "\\Projets";
		Core core = new Core(emplacement, tmp);
		MainFrame mf = new MainFrame(core);
      }
}