package linguistic.graph_concepts_gestion;

import java.util.LinkedList;
import java.util.List;

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
	
	@Override
	public List<GraphNode> getListNodes(){
		List<GraphNode> list = new LinkedList<GraphNode>();
		list.add(this);
		return list;
	}

	@Override
	public GraphNode getRoot() {
		return this;
	}

	@Override
	public int getNumberOfNodes() {
		return 1;
	}

}
