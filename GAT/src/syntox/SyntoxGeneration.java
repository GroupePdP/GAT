package syntox;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import linguistic.conceptsGestion.Concept;
import linguistic.graphConceptsGestion.*;


public class SyntoxGeneration {

	
	public String toSyntox (Concept concept){
		return concept.generateSyntox();
	}

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
	}

}
