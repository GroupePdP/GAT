package src.linguistic.graph_concepts_gestion;

import src.linguistic.concepts_gestion.Concept;
import src.linguistic.concepts_gestion.ConceptComplex;

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
		return new GraphNodeDefault((ConceptComplex)c);
	}

}
