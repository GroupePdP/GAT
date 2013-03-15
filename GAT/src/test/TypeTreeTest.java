package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.*;

import junit.framework.TestCase;
import linguistic.concepts_gestion.Concept;
import linguistic.concepts_gestion.ConceptSimple;
import linguistic.types_gestion.Type;
import linguistic.types_gestion.TypeImpl;
import linguistic.types_gestion.TypeTree;
import linguistic.types_gestion.TypeTreeNode;

public class TypeTreeTest extends TestCase{
  
	Concept c1, c2, c3, c4;
	Map<Type, TypeTreeNode> nodeMap;
	Type rootType, childType1, childType2, childType3, childType4;
	TypeTree tree;
	TypeTreeNode root, childRoot;
	
	@Before 
	public void initialize() {
		tree = new TypeTree();
		
		rootType = new TypeImpl("object");
		root = new TypeTreeNode(rootType);
				
		childType1 = new TypeImpl("Réussir", rootType);
		childRoot = new TypeTreeNode(childType1);
		
		root.addChild(childRoot);	
		
		nodeMap = new HashMap<Type, TypeTreeNode>();
		nodeMap.put(rootType, root);
		
		c1 = new ConceptSimple(null, null, "Réussir", rootType);
	}
	
	
	@Test
	public void testAddType(){	
		assertEquals(childRoot,tree.addType(childType1));	
	}
	
	
	@Test
	public void testAddConcept() {
		tree.addConcept(c1);
		root.addConcept(c1);
		
		assertEquals(root.getConceptList(),tree.getRoot().getConceptList());
	}
	
	@Test
	public void testgetConceptsForType() {
		List<Concept> list = new ArrayList<Concept>();
		
		childType2 = new TypeImpl("RéussirMatch", childType1);
		childType3 = new TypeImpl("RéussirQuart", childType1);
		childType4 = new TypeImpl("RéussirCoupe", childType1);
		
		c2 = new ConceptSimple(null, null, "RéussirMatch", childType1);
		c3 = new ConceptSimple(null, null, "RéussirQuart", childType1);
		c4 = new ConceptSimple(null, null, "RéussirCoupe", childType1);
		
		tree.addType(childType2);
		tree.addType(childType3);
		tree.addType(childType4);
		
		tree.addConcept(c2);
		tree.addConcept(c3);
		tree.addConcept(c4);
		
		list.add(c2);
		list.add(c3);
		list.add(c4);
		
		assertEquals(list, tree.getConceptsForType(childType1));
		
	}
	

}
