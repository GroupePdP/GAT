package linguistic.graph_concepts;

import linguistic.concepts.Concept;
import linguistic.concepts.ConceptSimple;

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
