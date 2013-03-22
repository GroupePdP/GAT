package linguistic.graphConceptsGestion;

import java.util.List;

public class GraphConcepts implements GraphConceptsInterface{
	
	private GraphNode root;
	
	public GraphConcepts(GraphNode root){
		this.root = root;
	}
	
	@Override
	public GraphNode getRoot(){
		return this.root;
	}

	@Override
	public List<GraphNode> getListNodes(){
		return root.getListNodes();
	}

	@Override
	public int getNumberOfNodes(){
		return root.getListNodes().size();
	}
	
	public GraphConcepts toTree(){
		return new GraphConcepts(root.toTree());
	}
}
