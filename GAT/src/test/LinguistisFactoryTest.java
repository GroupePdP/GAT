package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import linguistic.concepts_gestion.Concept;
import linguistic.concepts_gestion.ConceptComplex;
import linguistic.concepts_gestion.ConceptSimple;
import linguistic.types_gestion.LinguisticFactory;
import linguistic.types_gestion.Type;
import linguistic.types_gestion.TypeImpl;
import linguistic.types_gestion.TypeManager;

import org.junit.Before;
import org.junit.Test;

public class LinguistisFactoryTest {
	
	Concept c1, c2;
	LinguisticFactory lf;
	List<Type> args;
	Type type1, type2,rootType;
	TypeManager typeManager;	
	
	@Before
	public void initialize() {
		typeManager = new TypeManager();
		rootType = new TypeImpl("object");
		type1 = new TypeImpl("Réussir");
		type2 = new TypeImpl("Réussir", rootType);
		
		args = new ArrayList<Type> ();
		
		c1 = new ConceptComplex("RéussirMatch", type1, args);
		c2 = new ConceptSimple(null, null, "RéussirQuart", type1);
	}
	
	@Test
	public void testMakeType1() {
		assertEquals(type1, lf.makeType("Réussir"));
	}

	@Test
	public void testMakeType2() {
		assertEquals(type2, lf.makeType("Réussir", rootType));
	}
	
	@Test
	public void testMakeConcept1() {
		assertEquals(c1, lf.makeConcept("Réussir", type1, args));
	}
	
	@Test
	public void testMakeConcept2() {
		assertEquals(c2, lf.makeConcept(null, null, "RéussirQuart", type1));
	}
	
}
