package linguistic.graph_concepts_gestion;

import java.util.List;

public interface GraphConceptsInterface {

	public abstract GraphNode getRoot();

	public abstract List<GraphNode> getListNodes();

	public abstract int getNumberOfNodes();

}