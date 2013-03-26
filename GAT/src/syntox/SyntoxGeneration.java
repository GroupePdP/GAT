package syntox;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import linguistic.conceptsGestion.Concept;
import linguistic.graphConceptsGestion.*;


/**	
  * ATTENTION : EN COURS.
**/

public class SyntoxGeneration {


	private String requestSyntox;
	private String contained;
	private int numberNodes;
	

	public SyntoxGeneration(GraphConcepts gc){
		this.requestSyntox = "Axiom[PRED:"+gc.getRoot().getConcept().getName()+contained+"]";
		this.numberNodes = gc.getNumberOfNodes();
	}

	/**
	 * SyntoxGeneration syntoxRequet = new SyntoxGeneration();
	 * Lancer "syntoxRequet.generationSyntox(gc.getRoot());"
	 */
	public String generationSyntox(GraphNode gn) 
	{
		int nbArgs = 0;
		for (GraphNode g :gn.getListNodes()){
			contained.concat("arg"+nbArgs+"[PRED:"+g.getConcept().getName()+"]");
			nbArgs++;
			generationSyntox(g);
			contained.concat("]");
		}		
		return requestSyntox;
	}
	
	public String toSyntox (Concept concept){
		return concept.generateSyntox();
	}

	
	/*
	public void generationSyntox (GraphConcepts graphe){
		try{
			
			FileWriter fw = new FileWriter (System.getProperty("user.dir").substring(0, System.getProperty("user.dir").length() -4) + File.separator + "syntox.txt");
			
			for (GraphNode g :graphe.getListNodes()){
				Concept c = g.getConcept();
				fw.write(toSyntox(c));
			}
			
			fw.close();
		}
		catch(IOException ex) { 
			ex.printStackTrace(); 
		}
	}*/

}

