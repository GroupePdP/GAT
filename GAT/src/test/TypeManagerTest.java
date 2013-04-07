package test;

import static org.junit.Assert.*;

import org.junit.Test;

import linguistic.typesGestion.Type;
import linguistic.typesGestion.TypeImpl;
import linguistic.typesGestion.TypeManager;

public class TypeManagerTest {
	
	Type type, rootType;
	TypeManager typeManager;
	
	@Test
	public void testMakeType1() {
		typeManager = new TypeManager();
		type = new TypeImpl("Reussir", typeManager.getTypeTree().getRoot().getType());
		
		assertEquals(type.getName(), typeManager.makeType("Reussir", typeManager.getTypeTree().getRoot().getType()).getName());
		assertEquals(type.getSurtype(), typeManager.makeType("Reussir").getSurtype());		
	}
	
	@Test
	public void testMakeType2() {
		typeManager = new TypeManager();
		type = new TypeImpl("Reussir",typeManager.getTypeTree().getRoot().getType());
		
		assertEquals(type.getName(), typeManager.makeType("Reussir").getName());
		assertEquals(type.getSurtype(), typeManager.makeType("Reussir").getSurtype());
	}
	
	@Test
	public void testIsCompatible() {
		typeManager = new TypeManager();
		type = new TypeImpl("Reussir", typeManager.getTypeTree().getRoot().getType());
		rootType = typeManager.getTypeTree().getRoot().getType();
		
		assertEquals(true, typeManager.isCompatible(type, rootType));
	}
	
	
	

}
