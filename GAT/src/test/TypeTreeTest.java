package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import junit.framework.TestCase;
import linguistic.conceptsGestion.Concept;
import linguistic.conceptsGestion.ConceptSimple;
import linguistic.typesGestion.Type;
import linguistic.typesGestion.TypeImpl;
import linguistic.typesGestion.TypeTree;
import linguistic.typesGestion.TypeTreeNode;

public class TypeTreeTest extends TestCase{
	
	Concept c1, c2, c3;
	Type childType;
	TypeTree tree;
	TypeTreeNode root, childRoot;
	
	@Test
	public void testAddType(){	
		tree = new TypeTree();
		childType = new TypeImpl("Reussir", tree.getRoot().getType());
		childRoot = new TypeTreeNode(childType);
		TypeTreeNode node = tree.addType(childType);
		assertEquals(tree.getRoot().getChildrenList().get(0), node);
	}
	
	
	@Test
	public void testAddConcept() {
		tree = new TypeTree();
		c1 = new ConceptSimple("Reussir",tree.getRoot().getType());
		tree.addConcept(c1);
		ArrayList<Concept> conceptList = new ArrayList<Concept>();
		conceptList.add(c1);
		
		assertEquals(conceptList,tree.getRoot().getConceptList());
	}
	
	@Test
	public void testgetConceptsForType() {
		List<Concept> list = new ArrayList<Concept>();
		tree = new TypeTree();
		
		c1 = new ConceptSimple("Reussir",tree.getRoot().getType());
		c2 = new ConceptSimple("ReussirMatch", c1.getType());
		c3 = new ConceptSimple("ReussirQuart", c1.getType());
		
		list.add(c1);
		list.add(c2);
		list.add(c3);	
		
		tree.addConcept(c1);
		tree.addConcept(c2);
		tree.addConcept(c3);		
		
		assertEquals(list, tree.getConceptsForType(tree.getRoot().getType()));		
	}
	

}
