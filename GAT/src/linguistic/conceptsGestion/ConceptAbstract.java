/* Classe abstraite ConceptAbstract, implemente Concept.
 * 
 */

package linguistic.conceptsGestion;

import linguistic.typesGestion.Type;

public abstract class ConceptAbstract implements Concept{
	
	private String name;
	private Type type;
	private String description = "";
	
	public ConceptAbstract(String name, Type type){
		this.name = name;
		this.type = type;
	}
	
	// Accesseurs

	public String getName(){
		return this.name;
	}
	
	public Type getType(){
		return this.type;
	}
	
	public String getDescription() {
		return description;
	}


	@Override
	public String toString(){
		return this.name;
	}
	
}
