package linguistic.graph_concepts_gestion;

import java.util.List;

public class GraphConcepts implements GraphConceptsInterface{
	
	private GraphNodeDefault root;
	
	public GraphConcepts(GraphNodeDefault root){
		this.root = root;
	}
	
	@Override
	public GraphNodeDefault getRoot(){
		return this.root;
	}

	@Override
	public List<GraphNodeDefault> getListNodes(){
		return root.getListNodes();
	}

	@Override
	public int getNumberOfNodes(){
		return root.getListNodes().size();
	}
}
