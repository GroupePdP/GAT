package src.linguistic.graph_concepts_gestion;

import java.util.List;

import src.linguistic.concepts_gestion.Concept;

public interface GraphNode extends GraphConceptsInterface{

	public boolean isTagged();
	public GraphNode getReference();
	public Concept getConcept();
	public List<GraphNode> getChildrenList();
	public List<GraphNode> getListNodes();
	public GraphNode getRoot();
	public int getNumberOfNodes();
	
	public void addChild(GraphNode child, int index) throws IncompatibleTypesException;
	public GraphNode toTree();
	
}
