

package linguistic.typesGestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import linguistic.conceptsGestion.Concept;

/** Represents a tree structure of nodes of type TypeTreeNode.
 * This structure allows to represent Type organization and
 * arrangement, including surtypes relations.
 * The TypeTree class can add a Type, a Concept (which has a 
 * specific Type) and is used to return a list of Concepts having
 * a specified Type.
 * **/
public class TypeTree {

	private TypeTreeNode root;
	private Map<Type, TypeTreeNode> nodeMap;
	
	public TypeTree(){
		Type rootType = new TypeImpl("object"); 
		this.root = new TypeTreeNode(rootType);
		this.nodeMap = new HashMap<Type, TypeTreeNode>();
		nodeMap.put(rootType, root);
	}
	
	// Accesseurs
	/** Returns the root of the TypeTree, with type
	 * TypeTreeNode. **/
	public TypeTreeNode getRoot(){
		return this.root;
	}
	
	/** Contains a Map, giving the relations between Types
	 * and TypeTreeNodes. **/
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
	
	public void addConcept(Concept c){
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
}
