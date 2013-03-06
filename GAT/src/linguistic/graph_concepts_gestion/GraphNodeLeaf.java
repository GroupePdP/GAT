package linguistic.graph_concepts_gestion;

import linguistic.concepts_gestion.Concept;
import linguistic.concepts_gestion.ConceptSimple;

public class GraphNodeLeaf implements GraphNode {
	
	private Concept concept;
	
	public GraphNodeLeaf(ConceptSimple c){
		this.concept = c;
	}

	@Override
	public Concept getConcept() {
		return this.concept;
	}

}
