/* Interface Concept
 * 
 * Sera implémentée par une classe abstraite
 */

package linguistic.conceptsGestion;

import java.util.List;

import linguistic.typesGestion.Type;

public interface Concept {

	public String generateSyntox(); // a implementer !
	public Type getType();
	public String getName();
	public List<Type> getArguments();
	public int getNumberArguments();
	
}