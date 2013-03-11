package linguistic.graph_concepts_gestion;

import linguistic.concepts_gestion.ConceptComplex;
import linguistic.concepts_gestion.ConceptSimple;

public final class GraphNodeFactory{
		
	private static volatile GraphNodeFactory instance = null;

	public GraphNodeFactory(){
	}

	public static GraphNodeFactory getInstance(){
		if (GraphNodeFactory.instance == null)
		{
			synchronized(GraphNodeFactory.class){
				if (GraphNodeFactory.instance == null)
				{
					GraphNodeFactory.instance = new GraphNodeFactory();
				}
			}
		}
		return GraphNodeFactory.instance;
	}

	public GraphNode makeNode(ConceptSimple c){
		return new GraphNodeLeaf(c);
	}

	public GraphNode makeNode(ConceptComplex c){
		return new GraphNodeParent(c);
	}

}
