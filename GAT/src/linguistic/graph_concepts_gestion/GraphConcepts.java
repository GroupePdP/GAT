package linguistic.graph_concepts_gestion;

import java.util.ArrayList;
import java.util.List;

public class GraphConcepts {
	
	private GraphNode root;
	private List<GraphNode> nodes;
	
	public GraphConcepts(GraphNode root){
		this.root = root;
		this.nodes = new ArrayList<GraphNode>();
	}
	
	public GraphNode getRoot(){
		return this.root;
	}
	
	public List<GraphNode> getNodes(){
		return this.nodes;
	}
	
	public int getNumberOfNodes(){
		return this.nodes.size();
	}
	
	// coder une fonction qui ajoute un noeud en verifiant la compatibilite des types

}
