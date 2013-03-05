package linguistic.graph_concepts;

import linguistic.Concept;

public interface GraphNode {

	public Concept getConcept();
	public String toString();
	public GraphNode arboriser(); // a voir, preciser le type de retour 
	
}