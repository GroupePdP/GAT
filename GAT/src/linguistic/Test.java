package linguistic;

import java.util.ArrayList;
import java.util.List;

import linguistic.concepts_gestion.*;
import linguistic.types_gestion.*;
import linguistic.graph_concepts_gestion.*;

public class Test {
	
	public static void main(String[] args) {
		
		LinguisticFactory lf = LinguisticFactory.getInstance();
		GraphNodeFactory g = new GraphNodeFactory();
		Type t1 = lf.getTypeManager().makeType("personne");
		Type t2 = lf.getTypeManager().makeType("joueur", t1);
		Type t3 = lf.getTypeManager().makeType("gain_de_match");
		Type t4 = lf.getTypeManager().makeType("match");
		
		ConceptSimple c1 = new ConceptSimple("table1","line3","Joueur1",t2);
		ConceptSimple c2 = new ConceptSimple("table2", "line5","Match 2",t4);
		List<Type> l = new ArrayList<Type>();
		l.add(t2); l.add(t4);
		ConceptComplex c3 = new ConceptComplex("gagner",t3,l); // concept (gagner(joueur, match))
		
		GraphNodeParent root = new GraphNodeParent(c3);
		try{
			root.addChild(g.makeNode(c1),0);
			root.addChild(g.makeNode(c2),1);
		}
		catch(IncompatibleTypesException e){
			System.out.println(e.getMessage());
		}
		GraphConcepts gc = new GraphConcepts(root);
		
		Scenario s = new Scenario("test");
		s.addGraphConcepts(gc);
	}
}