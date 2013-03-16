package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import linguistic.concepts_gestion.Concept;
import linguistic.concepts_gestion.ConceptComplex;
import linguistic.graph_concepts_gestion.GraphNodeDefault;
import linguistic.types_gestion.Type;
import linguistic.types_gestion.TypeImpl;

import org.junit.Before;
import org.junit.Test;

public class GraphNodeDefaultTest {
	
	Concept c1, c2;
	List<Type> args;
	String name1, name2;
	Type type;
	GraphNodeDefault graphND;
	
	@Before
	public void initialize() {
		args = new ArrayList<Type> ();		
		type = new TypeImpl("Réussir");				
		c1 = new ConceptComplex("RéussirMatch", type, args);
		
		graphND = new GraphNodeDefault(c1);
	}
	
	@Test
	public void testGetConcept() {
		assertEquals(c1, graphND.getConcept());
	}
	
	@Test
	public void testGetReference() {
			assertEquals(false, graphND.getReference());
	}
	
	@Test
	public void testGetIsTagged() {
		assertEquals(false, graphND.isTagged());
	}
	
	@Test
	public void testGetChildrenList() {
		assertEquals(args, graphND.getChildrenList());
	}
	
	@Test
	public void testGetRoot() {
		assertEquals(graphND, graphND.getRoot());
	}
	
}
