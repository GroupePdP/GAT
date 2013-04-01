package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import linguistic.conceptsGestion.Concept;
import linguistic.graphConceptsGestion.GraphConcepts;
import linguistic.graphConceptsGestion.GraphNode;
import linguistic.graphConceptsGestion.GraphNodeFactory;
import linguistic.typesGestion.IncompatibleTypesException;
import linguistic.typesGestion.LinguisticFactory;
import linguistic.typesGestion.Type;

import org.junit.Before;
import org.junit.Test;

public class GraphConceptsTest {
	
	private GraphConcepts gc;
	private String result;
	
	@Before
	public void initialize() {
		
		
		final LinguisticFactory lf = LinguisticFactory.getInstance();
		GraphNodeFactory g = GraphNodeFactory.getInstance();
		Type t1 = lf.getTypeManager().makeType("personne");
		Type t2 = lf.getTypeManager().makeType("joueur", t1);
		Type t3 = lf.getTypeManager().makeType("gain_de_match");
		Type t4 = lf.getTypeManager().makeType("match");
		Type t5 = lf.getTypeManager().makeType("relation_event");
		Type t6 = lf.getTypeManager().makeType("etre_vainqueur");
		Type t7 = lf.getTypeManager().makeType("competition");
		
		Concept c8 = lf.makeConcept("Joueur2",t2);
		Concept c2 = lf.makeConcept("Match2",t4);
		Concept c6 = lf.makeConcept("Competition 1",t7);
		
		List<Type> l = new ArrayList<Type>();
		l.add(t2); l.add(t4);
		Concept c3 = lf.makeConcept("gagner",t3,l);
		
		List<Type> l2 = new ArrayList<Type>();
		l2.add(t2); l2.add(t7);
		Concept c4 = lf.makeConcept("etre_vainqueur",t6,l2);
		
		List<Type> l3 = new ArrayList<Type>();
		l3.add(t3); l3.add(t6);
		Concept c5 = lf.makeConcept("cause",t5,l3); 
		
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
		gc = new GraphConcepts(root);
		
		result = "Axiom[PRED:"+c5.getName()+"arg0[PRED:"+c3.getName()+"arg0[PRED:"+c8.getName()+"], arg1[PRED:"+c2.getName()+"]], arg1[PRED:"+c4.getName()+", arg0[PRED:"+
				c8.getName()+"], arg1[PRED:"+c6.getName()+"]]]";		
	}

	@Test
	public void testGenerateSyntox(){
		assertEquals(result, gc.generateSyntox());
	}
}
