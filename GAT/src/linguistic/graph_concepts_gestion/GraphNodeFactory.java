package linguistic.graph_concepts_gestion;

import linguistic.concepts_gestion.Concept;

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

	public GraphNode makeNode(Concept c){
		return new GraphNodeDefault(c);
	}

}
