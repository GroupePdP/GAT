/* Classe ConceptComplex (herite de ConceptAbstract)
 * 
 * Un ConceptComplex a des arguments, qui sont des Types.
 */

package linguistic;

import java.util.List;

public class ConceptComplex extends ConceptAbstract {
	
	private List<Type> arguments;
	
	protected ConceptComplex(String name, Type type, List<Type> args) {
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
	public String syntoxGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

}
