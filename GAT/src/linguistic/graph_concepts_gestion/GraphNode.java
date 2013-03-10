package linguistic.graph_concepts_gestion;

import java.util.List;

import linguistic.concepts_gestion.Concept;

public interface GraphNode extends GraphConceptsInterface{

	public Concept getConcept();
	public List<GraphNode> getListNodes();
	
}
