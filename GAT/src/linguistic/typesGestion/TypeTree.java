/** Classe TypeTree
 * contient une HashMap des Type et des noeuds de l'arbre de types
 * gere l'ajout d'un type ou d'un concept dans l'arbre
 */

package linguistic.typesGestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import linguistic.conceptsGestion.Concept;

public class TypeTree {

	private TypeTreeNode root;
	private Map<Type, TypeTreeNode> nodeMap;
	
	public TypeTree(){
		Type rootType = new TypeImpl("object"); // Type "racine"
		this.root = new TypeTreeNode(rootType);
		this.nodeMap = new HashMap<Type, TypeTreeNode>();
		nodeMap.put(rootType, root);
	}
	
	// Accesseurs
	
	public TypeTreeNode getRoot(){
		return this.root;
	}
	
	public Map<Type,TypeTreeNode> getMap(){
		return nodeMap;
	}
	
	// Autres methodes
	/** Adds a TypeTreeNode with the specified Type to the TypeTree 
	 * and returns it.
	 * If the TypeTreeNode with its surtype isn't present in the
	 * TypeTree, the recursive call to the method will create it.
	 * The TypeTreeNode created is also added to the nodeMap.
	 * 
	 * @param t the type wanted to be added to the TypeTree
	 * @return the TypeTreeNode with the specified Type
	 * **/
	public TypeTreeNode addType(Type t){
		TypeTreeNode parent = nodeMap.get(t.getSurtype());
		if(parent==null)
		{
			parent = addType(t.getSurtype());
		}
		TypeTreeNode node = new TypeTreeNode(t);
		nodeMap.put(t,node);
		parent.addChild(node);
		return node;
	}
	
	public void addConcept(Concept c){ // utilisée ?
		TypeTreeNode node = nodeMap.get(c.getType());
		node.addConcept(c);
	}
	
	/** Returns the list of Concepts having the specified Type
	 *  or one of his "children".
	 *  The method runs through the Concepts having exactly
	 *  the given Type, then through the Concepts having the
	 *  "children" Types.
	 *  @param t the Type of the Concepts searched
	 *  @return the list of Concepts with the given Type
	 * **/
	public List<Concept> getConceptsForType(Type t){ 
		TypeTreeNode node = nodeMap.get(t);
		if (node == null)
		{
			return new ArrayList<Concept>();
		}
		List<Concept> list = new ArrayList<Concept>();
		for (Concept c : node.getConceptList())
		{
			list.add(c);
		}
		for (TypeTreeNode child : node.getChildrenList())
		{
			for(Concept c : getConceptsForType(child.getType()))
			{
				list.add(c);
			}
		}
		return list;
	}
	
	public boolean equals(TypeTree t) {
		return (this.root.equals(t.getRoot()));
	}
}
