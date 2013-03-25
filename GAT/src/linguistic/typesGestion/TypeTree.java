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
	
	public void addConcept(Concept c){
		TypeTreeNode node = nodeMap.get(c.getType());
		node.addConcept(c);
	}
	
	public List<Concept> getConceptsForType(Type t){ // On recupere les concepts du type t 
													// et de ses sous-types
		TypeTreeNode node = nodeMap.get(t);
		if (node == null)
		{
			return new ArrayList<Concept>();
		}
		List<Concept> list = new ArrayList<Concept>();
		List<Concept> list2 = node.getConceptList(); //*****
		for (Concept c : list2)
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