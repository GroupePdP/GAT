package linguistic.graph_concepts_gestion;

import java.util.List;

import linguistic.concepts_gestion.Concept;

public interface GraphNodeDefault extends GraphConceptsInterface{

	public Concept getConcept();
	public List<GraphNodeDefault> getChildrenList();
	public List<GraphNodeDefault> getListNodes();
	public GraphNodeDefault getRoot();
	public int getNumberOfNodes();
	
	public void addChild(GraphNodeDefault child, int index) throws IncompatibleTypesException;
	
}
