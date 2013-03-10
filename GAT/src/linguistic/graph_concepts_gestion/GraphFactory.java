package linguistic.graph_concepts_gestion;

import linguistic.concepts_gestion.ConceptComplex;
import linguistic.concepts_gestion.ConceptSimple;

public final class GraphFactory{
		
	private static volatile GraphFactory instance = null;

	public GraphFactory(){
	}

	public static GraphFactory getInstance(){
		if (GraphFactory.instance == null)
		{
			synchronized(GraphFactory.class){
				if (GraphFactory.instance == null)
				{
					GraphFactory.instance = new GraphFactory();
				}
			}
		}
		return GraphFactory.instance;
	}

	public GraphNode makeNode(ConceptSimple c){
		return new GraphNodeLeaf(c);
	}

	public GraphNode makeNode(ConceptComplex c){
		return new GraphNodeParent(c);
	}

}
