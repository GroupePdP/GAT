package test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import linguistic.conceptsGestion.Concept;
import linguistic.conceptsGestion.ConceptSimple;
import linguistic.typesGestion.Type;
import linguistic.typesGestion.TypeImpl;
import linguistic.typesGestion.TypeTreeNode;


public class TypeTreeNodeTest extends TestCase{

	public void testAddChild() { 		
		Type type1 = new TypeImpl("Reussir");
		TypeTreeNode treeNode1 = new TypeTreeNode(type1);
		TypeTreeNode treeNode2 = new TypeTreeNode(new TypeImpl("ReussirMatch", type1));
		
		List<TypeTreeNode> list = new ArrayList<TypeTreeNode>();
		list.add(treeNode2);
		
		treeNode1.addChild(treeNode2);
		
		assertEquals(list, treeNode1.getChildrenList());	
	}
	

	public void testAddConcept() {
		Concept concept = new ConceptSimple("Reussir", new TypeImpl("Reussite"));
		TypeTreeNode treeNode = new TypeTreeNode(new TypeImpl("Reussite"));
		
		List<Concept> childList = new ArrayList<Concept>();
		childList.add(concept);
		
		treeNode.addConcept(concept);
		
		assertEquals(childList, treeNode.getConceptList());		
	}

}
