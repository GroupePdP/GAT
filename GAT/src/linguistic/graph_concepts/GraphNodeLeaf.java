package linguistic.graph_concepts;

import linguistic.Concept;
import linguistic.ConceptSimple;

public class GraphNodeLeaf implements GraphNode {
	
	private Concept concept;
	
	public GraphNodeLeaf(ConceptSimple c){
		this.concept = c;
	}

	@Override
	public Concept getConcept() {
		return this.concept;
	}

	@Override
	public GraphNode arboriser() {
		return this;
	}

}
