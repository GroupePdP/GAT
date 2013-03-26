package linguistic.graphConceptsGestion;

import java.util.List;

public interface GraphConceptsInterface {

	public GraphNode getRoot();
	public List<GraphNode> getListNodes();
	public int getNumberOfNodes();
	public String generateSyntox();

}