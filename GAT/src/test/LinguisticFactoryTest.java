package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import linguistic.conceptsGestion.Concept;
import linguistic.conceptsGestion.ConceptComplex;
import linguistic.conceptsGestion.ConceptSimple;
import linguistic.typesGestion.LinguisticFactory;
import linguistic.typesGestion.Type;
import linguistic.typesGestion.TypeImpl;
import linguistic.typesGestion.TypeManager;

import org.junit.Before;
import org.junit.Test;

public class LinguisticFactoryTest {
	
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
		c2 = new ConceptSimple("RéussirQuart", type1);
	}
	
	@Test
	public void testMakeType1(){
		assertEquals(type1, lf.makeType("Réussir"));
	}

	@Test
	public void testMakeType2(){
		assertEquals(type2, lf.makeType("Réussir", rootType));
	}
	
	@Test
	public void testMakeConcept1(){
		assertEquals(c1, lf.makeConcept("Réussir", type1, args));
	}
	
	@Test
	public void testMakeConcept2(){
		assertEquals(c2, lf.makeConcept("RéussirQuart", type1));
	}
	
}
