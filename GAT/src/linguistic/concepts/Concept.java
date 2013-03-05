/* Interface Concept
 * 
 * Sera implémentée par une classe abstraite
 */

package linguistic.concepts;

import linguistic.Type;

public interface Concept {

	public String generateSyntox(); // a implementer !
	public Type getType();
	public String getName();
	
}
