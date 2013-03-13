package test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.*;

import linguistic.Concept;
import linguistic.ConceptSimple;
import linguistic.Type;
import linguistic.TypeImpl;
import linguistic.TypeTreeNode;


public class TypeTreeNodeTest {

	public void testAddChild() { 		
		Type type1 = new TypeImpl("Réussir");
		TypeTreeNode treeNode1 = new TypeTreeNode(type1);
		TypeTreeNode treeNode2 = new TypeTreeNode(new TypeImpl("RéussirMatch", type1));
		
		List<TypeTreeNode> list = new ArrayList<TypeTreeNode>();
		list.add(treeNode2);
		
		treeNode1.addChild(treeNode2);
		
		/* Une première façon de faire que j'ai trouvée
		assertEquals(list, treeNode1.getChildrenList());
		*/
		
		/* Une seconde façon de faire que j'ai trouvée
		Object[] array1 = treeNode1.getChildrenList().toArray();
		Object[] array2 = list.toArray();
		for(int i=0; i < array1.length; i++)
			assertEquals((String) array1[i],(String) array2[i]);
		*/		
	}
	
	public void testAddConcept() {
		Concept concept = new ConceptSimple(null, null, "Réussir", new TypeImpl("Réussite"));
		TypeTreeNode treeNode = new TypeTreeNode(new TypeImpl("Réussite"));
		
		List<Concept> childList = new ArrayList<Concept>();
		childList.add(concept);
		
		treeNode.addConcept(concept);
		
		//assertEquals(childList, treeNode.getConceptList());		
	}

}
