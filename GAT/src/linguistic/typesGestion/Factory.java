/* Interface Factory
 * fait partie du pattern du meme nom, pour deleguer la creation de Type
 */

package linguistic.typesGestion;

import java.util.List;

import linguistic.conceptsGestion.Concept;


public interface Factory {
	
	public Type makeType(String name, Type surtype);
	public Type makeType(String name);
	public Type makeType(String name, Type surtype, String description);
	public Type makeType(String name, String description); // Type "racine", qui n'a pas de surtype
	
	public Concept makeConcept(String name, Type type, List<Type> args);
	public Concept makeConcept(String name, Type type);
	public Concept makeConcept(String name, Type type, List<Type> args, String description);
	public Concept makeConcept(String name, Type type, String description);
}
