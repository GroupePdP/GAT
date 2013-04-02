package linguistic.graphConceptsGestion;

import java.util.List;

import linguistic.conceptsGestion.Concept;
import linguistic.typesGestion.IncompatibleTypesException;

public interface GraphNode extends GraphConceptsInterface{

	public boolean isTagged();
	public void setTag(boolean b);
	public GraphNode getReference();
	public void setReference(GraphNode ref);
	public boolean isReference();
	public void setIsReference(boolean b);
	public Concept getConcept();
	public List<GraphNode> getChildrenList();
	public List<GraphNode> getListNodes();
	public GraphNode getRoot();
	public int getNumberOfNodes();
	
	public String generateSyntox();
	public void addChild(GraphNode child, int index) throws IncompatibleTypesException;
}
