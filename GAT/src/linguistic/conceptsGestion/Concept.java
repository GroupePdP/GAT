/* Interface Concept
 * 
 * Sera implémentée par une classe abstraite
 */

package linguistic.conceptsGestion;

import java.util.List;
import java.util.Map;

import linguistic.typesGestion.Type;

public interface Concept {

	public String generateSyntox();
	public Type getType();
	public String getName();
	public List<Type> getArguments();
	public int getNumberArguments();
	public void setSyntoxInput(Map<String, Type> map);
}
