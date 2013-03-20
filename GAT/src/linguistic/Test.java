package linguistic;

import java.util.ArrayList;
import java.util.List;

import linguistic.concepts_gestion.*;
import linguistic.types_gestion.*;
import linguistic.graph_concepts_gestion.*;

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
		
		Scenario s = new Scenario("test");
		s.addGraphConcepts(gc);*/
		
		TypeTree tree = new TypeTree();

		Type childType1 = new TypeImpl("Réussir", tree.getRoot().getType());
		TypeTreeNode childRoot = new TypeTreeNode(childType1);
		
		tree.getRoot().addChild(childRoot);
		
		
	}
}