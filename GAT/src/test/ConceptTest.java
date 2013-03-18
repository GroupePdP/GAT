package src.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import src.linguistic.concepts_gestion.*;
import src.linguistic.types_gestion.Type;
import src.linguistic.types_gestion.TypeImpl;

import org.junit.Before;
import org.junit.Test;

public class ConceptTest {
	
	Concept c1, c2;
	int num;
	List<Type> args;
	String name1, name2;
	Type type1;	
	
	@Before
	public void initialize() {
		args = new ArrayList<Type> ();
		num = args.size();
		
		name1 = "RéussirMatch";
		type1 = new TypeImpl("Réussir");
		
		name2 = "RéussirQuart";
		
		c1 = new ConceptComplex(name1, type1, args);
		c2 = new ConceptSimple(null, null, name2 , type1);	
	}
	
	@Test
	public void testConcept() {
		assertEquals(name1, c1.getName());
		assertEquals(name2, c2.getName());
		assertEquals(type1, c1.getType());
		assertEquals(type1, c2.getType());
		
		assertEquals(num, c1.getNumberArguments());
		assertEquals(args, c1.getArguments());
		
		assertEquals(0, c2.getNumberArguments());
		assertEquals(new ArrayList<Type> (), c2.getArguments());
	}
	
}
