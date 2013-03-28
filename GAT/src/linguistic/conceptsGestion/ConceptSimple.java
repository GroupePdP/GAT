/* Classe ConceptSimple (herite de ConceptAbstract)
 * 
 * Un concept atomique ne contient pas d'arguments
 * ne contient qu'une reference a une ligne / colonne de la bdd.
 */

package linguistic.conceptsGestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import linguistic.typesGestion.Type;

public class ConceptSimple extends ConceptAbstract 
{
	public ConceptSimple(String name, Type type)
	{
		super(name, type);
	}
	
	/**Autres methodes**/
	
	@Override
	public String generateSyntox()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void setSyntoxInput(Map<String, Type> map){
	}
	
	@Override
	public List<Type> getArguments(){
		return new ArrayList<Type>();
	}

	@Override
	public int getNumberArguments() {
		return 0;
	}
	
}
