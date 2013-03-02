/* Classe TypeTree
 * contient une HashMap des Type et des noeuds de l'arbre de types
 * gere l'ajout d'un type ou d'un concept dans l'arbre
 */

package linguistic;

import java.util.HashMap;
import java.util.Map;

public class TypeTree {

	private TypeTreeNode root;
	private Map<Type, TypeTreeNode> nodeMap;
	
	public TypeTree(){
		Type rootType = new TypeImpl("object"); // Type "racine"
		this.root = new TypeTreeNode(rootType);
		this.nodeMap = new HashMap<Type, TypeTreeNode>();
	}
	
	// Accesseurs
	
	public TypeTreeNode getRoot(){
		return this.root;
	}
	
	// Autres methodes
		
	public TypeTreeNode addType(Type t){
		TypeTreeNode parent = nodeMap.get(t.getSurtype());
		if(parent==null)
		{
			parent = addType(t.getSurtype());
		}
		TypeTreeNode node = new TypeTreeNode(t); 
		parent.addChild(node);
		return node;
	}
	
	public void addConcept(Concept c){
		TypeTreeNode node = nodeMap.get(c.getType());
		node.addConcept(c);
	}	
}
