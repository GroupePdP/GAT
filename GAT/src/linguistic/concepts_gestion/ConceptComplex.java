/* Classe ConceptComplex (herite de ConceptAbstract)
 * 
 * Un ConceptComplex a des arguments, qui sont des Types.
 */

package linguistic.concepts_gestion;

import java.util.List;

import linguistic.types_gestion.Type;

public class ConceptComplex extends ConceptAbstract {
	
	private List<Type> arguments;
	
	public ConceptComplex(String name, Type type, List<Type> args) {
		super(name, type);
		this.arguments = args;
	}
	
	// Accesseurs
	
	public int getNumberArguments(){
		return arguments.size();
	}

	public List<Type> getArguments(){
		return this.arguments;
	}
	
	// Autres methodes

	@Override
	public String generateSyntox() {
		// TODO Auto-generated method stub
		return null;
	}

}
