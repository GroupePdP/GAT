package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.*;

import junit.framework.TestCase;
import linguistic.conceptsGestion.Concept;
import linguistic.conceptsGestion.ConceptSimple;
import linguistic.typesGestion.Type;
import linguistic.typesGestion.TypeImpl;
import linguistic.typesGestion.TypeTree;
import linguistic.typesGestion.TypeTreeNode;

public class TypeTreeTest extends TestCase{
	
	Concept c1, c2, c3, c4;
	Map<Type, TypeTreeNode> nodeMap;
	Type rootType, childType1, childType2, childType3, childType4;
	TypeTree tree;
	TypeTreeNode root, childRoot;
	
	@Before 
	public void initialize() {
		tree = new TypeTree();
		
		//rootType = new TypeImpl("object"); déjà présent dans le constructeur de TypeTree
		//root = new TypeTreeNode(rootType);
				
		childType1 = new TypeImpl("Réussir", tree.getRoot().getType());
		childRoot = new TypeTreeNode(childType1);
		
		tree.getRoot().addChild(childRoot);	
		
		//nodeMap = new HashMap<Type, TypeTreeNode>(); déjà présent dans le constructeur de TypeTree
		//nodeMap.put(rootType, root);
		
		c1 = new ConceptSimple("Réussir",tree.getRoot().getType());
	}
	
	
	@Test
	public void testAddType(){	
		tree = new TypeTree();
		childType1 = new TypeImpl("Réussir", tree.getRoot().getType());
		childRoot = new TypeTreeNode(childType1);
		TypeTreeNode node = tree.addType(childType1);
		assertEquals(tree.getRoot().getChildrenList().get(0), node);
	}
	
	
	@Test
	public void testAddConcept() {
		tree.addConcept(c1);
		root.addConcept(c1);
		
		assertEquals(root.getConceptList(),tree.getRoot().getConceptList()); // root et tree.getRoot() c'est pareil non ?
	}
	
	@Test
	public void testgetConceptsForType() {
		List<Concept> list = new ArrayList<Concept>();
		
		childType2 = new TypeImpl("RéussirMatch", childType1);
		childType3 = new TypeImpl("RéussirQuart", childType1);
		childType4 = new TypeImpl("RéussirCoupe", childType1);
		
		c2 = new ConceptSimple("RéussirMatch", childType1);
		c3 = new ConceptSimple("RéussirQuart", childType1);
		c4 = new ConceptSimple("RéussirCoupe", childType1);
		
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
