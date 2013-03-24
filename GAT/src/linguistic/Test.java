package linguistic;

import java.util.ArrayList;
import java.util.List;

import linguistic.conceptsGestion.*;
import linguistic.typesGestion.*;
import linguistic.graphConceptsGestion.*;

public class Test {
	
	public static void main(String[] args) {
		
/*		LinguisticFactory lf = LinguisticFactory.getInstance();
		GraphNodeFactory g = new GraphNodeFactory();
		Type t1 = lf.getTypeManager().makeType("personne");
		Type t2 = lf.getTypeManager().makeType("joueur", t1);
		Type t3 = lf.getTypeManager().makeType("gain_de_match");
		Type t4 = lf.getTypeManager().makeType("match");
		
		Concept c1 = lf.makeConcept("table1","line3","Joueur1",t2);
		Concept c2 = lf.makeConcept("table2", "line5","Match 2",t4);
		List<Type> l = new ArrayList<Type>();
		l.add(t2); l.add(t4);
		Concept c3 = lf.makeConcept("gagner",t3,l); // concept (gagner(joueur, match))
		
		List<Concept> list = lf.getTypeManager().getTypeTree().getConceptsForType(t1);

		for (Concept c : list){
			System.out.println(c.getName());
		}
		
		GraphNode root = g.makeNode(c3);
		try{
			root.addChild(g.makeNode(c1),0);
			root.addChild(g.makeNode(c2),1);
		}
		catch(IncompatibleTypesException e){
			System.out.println(e.getMessage());
		}
		GraphConcepts gc = new GraphConcepts(root);
		GraphConcepts gcTree = gc.toTree();
		
		Scenario s = new Scenario("test");
		s.addGraphConcepts(gc);
		*/
		
		final LinguisticFactory lf = LinguisticFactory.getInstance();
		GraphNodeFactory g = new GraphNodeFactory();
		Type t1 = lf.getTypeManager().makeType("personne");
		Type t2 = lf.getTypeManager().makeType("joueur", t1);
		Type t3 = lf.getTypeManager().makeType("gain_de_match");
		Type t4 = lf.getTypeManager().makeType("match");
		Type t5 = lf.getTypeManager().makeType("relation_event");
		Type t6 = lf.getTypeManager().makeType("etre_vainqueur");
		Type t7 = lf.getTypeManager().makeType("competition");
		Type t8 = lf.getTypeManager().makeType("_test_");
		
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
		
		//List<Type> l4 = new ArrayList<Type>();
		//l4.add(t5); l4.add(t1);
		//Concept c7 = lf.makeConcept("test",t8,l4); // concept (cause(gagner, etre_vainqueur))
		
		GraphNode root = g.makeNode(c5);
		GraphNode gc3 = g.makeNode(c3);
		GraphNode gc4 = g.makeNode(c4);
		GraphNode joueur2 = g.makeNode(c8);
		try {
			root.addChild(gc3,0);
			root.addChild(gc4,1);
			gc3.addChild(joueur2, 0);
			gc3.addChild(g.makeNode(c2), 1);
			gc4.addChild(joueur2, 0);
			gc4.addChild(g.makeNode(c6), 1);
			
		} catch (IncompatibleTypesException e) {
			System.out.println(e.getMessage());
		}
		GraphConcepts gc = new GraphConcepts(root);
		
		Scenario s = new Scenario("test");
		s.addGraphConcepts(gc);
	}
}