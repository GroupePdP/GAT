/* Classe ConceptComplex (herite de ConceptAbstract)
 * 
 * Un ConceptComplex a des arguments, qui sont des Types.
 */

package linguistic.conceptsGestion;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import linguistic.typesGestion.Type;

public class ConceptComplex extends ConceptAbstract {
	
	private List<Type> arguments;
	private Map<String, Type> syntox;
	
	public ConceptComplex(String name, Type type, List<Type> args) {
		super(name, type);
		this.arguments = args;
	}
	
	public ConceptComplex(String name, Type type, List<Type> args, String description) {
		super(name, type, description);
		this.arguments = args;
	}
	
	// Accesseurs
	
	public int getNumberArguments(){
		return arguments.size();
	}

	public List<Type> getArguments(){
		return this.arguments;
	}

	public void setSyntoxInput(Map<String, Type> map){
		this.syntox = map;
	}
	
	// Autres methodes

	@Override
	public String generateSyntox() {
		String res = new String("");
		Iterator<String> it =this.syntox.keySet().iterator();
		for (;it.hasNext();)
			res = res + it.next().toString();
		return res;
	}

	
}
