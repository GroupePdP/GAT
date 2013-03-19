/* Classe abstraite ConceptAbstract, implemente Concept.
 * 
 */

package linguistic.concepts_gestion;

import linguistic.types_gestion.Type;

public abstract class ConceptAbstract implements Concept
{
	
	private String name;
	private Type type;
	
	public ConceptAbstract(String name, Type type)
	{
		this.name = name;
		this.type = type;
	}
	
	// Accesseurs

	public String getName()
	{
		return this.name;
	}
	
	public Type getType()
	{
		return this.type;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
}
