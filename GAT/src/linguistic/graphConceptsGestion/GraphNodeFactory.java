package linguistic.graphConceptsGestion;

import linguistic.conceptsGestion.Concept;

public final class GraphNodeFactory{
		
	private static volatile GraphNodeFactory instance = null;

	private GraphNodeFactory(){
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
