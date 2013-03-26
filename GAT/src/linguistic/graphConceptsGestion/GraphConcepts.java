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

	@Override
	public String generateSyntox() {
		String requestSyntox = "Axiom[PRED:"+this.getRoot().getConcept().getName();	
		for(int i=0; i<this.getRoot().getChildrenList().size(); i++){
			requestSyntox += ", arg"+i+getRoot().getChildrenList().get(i).generateSyntox();
		}
		requestSyntox += "]";
		return requestSyntox;
	}
	
}
