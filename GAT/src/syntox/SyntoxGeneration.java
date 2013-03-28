package syntox;

import linguistic.graphConceptsGestion.GraphConcepts;
import linguistic.graphConceptsGestion.GraphNode;


/**	
  * ATTENTION : Modifier par l'insertion de la methode generateSyntox dans les classes GraphConcepts et GraphNode.
**/

public class SyntoxGeneration
{

	
	public SyntoxGeneration()
	{
	}

	
	private String ChildrenRecursive (GraphNode gn)
	{
		int nbArgs = 0;
		String requestSyntox = "[PRED="+gn.getConcept().getName();
		
		for (GraphNode g :gn.getChildrenList())
		{
			
			requestSyntox.concat(",arg"+nbArgs+"=");
			
			requestSyntox.concat(ChildrenRecursive(g));
			
			nbArgs++;

		}
		
		requestSyntox.concat("]");
		return requestSyntox;
	}
	
	public String generationSyntox(GraphConcepts gc) 
	{
		GraphNode root = gc.getRoot();
		
		String requestSyntox = "Axiom";
		
		requestSyntox.concat(ChildrenRecursive(root)); 

		
		return requestSyntox;
	}

}

