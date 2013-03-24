package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import linguistic.typesGestion.Type;
import linguistic.typesGestion.TypeImpl;
import linguistic.typesGestion.TypeManager;

public class TypeManagerTest {
	
	Type type1, rootType;
	TypeManager typeManager;
	
	@Before
	public void initialize() {
		typeManager = new TypeManager();
		rootType = new TypeImpl("object");
		type1 = new TypeImpl("Réussir", rootType);
	}
	
	@Test
	public void testMakeType1() {
		assertEquals(type1, typeManager.makeType("Réussir", rootType));
	}
	
	@Test
	public void testMakeType2() {
		assertEquals(type1, typeManager.makeType("Réussir"));
	}
	
	@Test
	public void testIsCompatible() {
		assertEquals(type1, rootType);
	}
	
	
	

}
