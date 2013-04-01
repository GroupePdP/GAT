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
	
	// Accesseurs
	
	public int getNumberArguments(){
		return arguments.size();
	}

	public List<Type> getArguments(){
		return this.arguments;
	}

	// qq peut expliquer comment fonctionne cette methode ?
	public void setSyntoxInput(Map<String, Type> map){
		this.syntox = map;
	}
	
	
	// Autres methodes

	@Override
	public String generateSyntox() {
		String res = new String("");
		Iterator it =this.syntox.keySet().iterator();
		for (;it.hasNext();)
			res = res + it.next().toString();
		return res;
	}

	
}
