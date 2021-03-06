/* Classe TypeTreeNode
 * implemente les noeuds de l'arbre de types
 */

package linguistic.typesGestion;

import java.util.ArrayList;
import java.util.List;


import linguistic.conceptsGestion.Concept;

public class TypeTreeNode {

	private Type type;
	private List<TypeTreeNode> childrenList;
	private List<Concept> conceptList;
	
	public TypeTreeNode(Type t){
		this.type = t;
		this.childrenList = new ArrayList<TypeTreeNode>();
		this.conceptList = new ArrayList<Concept>();
	}
	
	// Accesseurs
	
	public Type getType(){
		return this.type;
	}
	
	public List<TypeTreeNode> getChildrenList(){
		return this.childrenList;
	}
	
	public List<Concept> getConceptList(){
		return this.conceptList;
	}
	
	// Autres methodes
	
	public void addConcept(Concept c){
		conceptList.add(c);
	}
	
	public void addChild(TypeTreeNode child){
		childrenList.add(child);
	}	
}
