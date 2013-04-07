package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import linguistic.conceptsGestion.Concept;
import linguistic.conceptsGestion.ConceptSimple;
import linguistic.typesGestion.LinguisticFactory;
import linguistic.typesGestion.Type;
import linguistic.typesGestion.TypeImpl;
import linguistic.typesGestion.TypeManager;

import org.junit.Test;

public class LinguisticFactoryTest {
	
	Concept concept;
	LinguisticFactory lf;
	List<Type> args;
	Type type;
	TypeManager typeManager;	
	
	@Test
	public void testMakeType1(){
		typeManager = new TypeManager();
		type = new TypeImpl("Reussir", typeManager.getTypeTree().getRoot().getType());
		
		assertEquals(type.getName(), LinguisticFactory.getInstance().makeType("Reussir", 
				LinguisticFactory.getInstance().getTypeManager().getTypeTree().getRoot().getType()).getName());
		assertEquals(type.getSurtype().toString(), LinguisticFactory.getInstance().makeType("Reussir", 
				LinguisticFactory.getInstance().getTypeManager().getTypeTree().getRoot().getType()).getSurtype().toString());
		
	}

	@Test
	public void testMakeType2(){
		typeManager = new TypeManager();
		type = new TypeImpl("Reussir", typeManager.getTypeTree().getRoot().getType());

		assertEquals(type.getName(), LinguisticFactory.getInstance().makeType("Reussir").getName());
	}
	
	@Test
	public void testMakeConcept1(){
		typeManager = new TypeManager();
		type = new TypeImpl("Reussir", typeManager.getTypeTree().getRoot().getType());
		concept = new ConceptSimple("Reussir", typeManager.getTypeTree().getRoot().getType());

		assertEquals(concept.getName(), LinguisticFactory.getInstance().makeConcept("Reussir", 
				LinguisticFactory.getInstance().getTypeManager().getTypeTree().getRoot().getType()).getName());
	}
	
}
