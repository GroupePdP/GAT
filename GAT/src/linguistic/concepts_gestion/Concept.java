/* Interface Concept
 * 
 * Sera implémentée par une classe abstraite
 */

package linguistic.concepts_gestion;

import linguistic.types_gestion.Type;

public interface Concept {

	public String generateSyntox(); // a implementer !
	public Type getType();
	public String getName();
	
}
