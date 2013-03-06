package linguistic.graph_concepts_gestion;

import java.util.ArrayList;
import java.util.List;

import linguistic.concepts_gestion.Concept;
import linguistic.concepts_gestion.ConceptComplex;

public class GraphNodeParent implements GraphNode {
	
	private Concept concept;
	private List<GraphNode> childrenList;

	public GraphNodeParent(ConceptComplex c){ // verifier que c est un ConceptComplex dans le parametre 
		// ou dans la fonction ??
		this.concept = c;
		this.childrenList = new ArrayList<GraphNode>(c.getNumberArguments());
	}
	
	@Override
	public Concept getConcept() {
		return this.concept;
	}
	
	public List<GraphNode> getChildrenList(){
		return this.childrenList;
	}
	
	// fonction pour ajouter un child, en verifiant la compatibilité des types

}
