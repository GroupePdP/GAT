package linguistic.graph_concepts_gestion;

import java.util.List;

public interface GraphConceptsInterface {

	public GraphNodeDefault getRoot();
	public List<GraphNodeDefault> getListNodes();
	public int getNumberOfNodes();

}