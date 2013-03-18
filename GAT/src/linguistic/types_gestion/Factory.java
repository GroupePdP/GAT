/* Interface Factory
 * fait partie du pattern du meme nom, pour deleguer la creation de Type
 */

package src.linguistic.types_gestion;

import java.util.List;

import src.linguistic.concepts_gestion.Concept;


public interface Factory {
	
	public Type makeType(String name, Type surtype);
	public Type makeType(String name); // Type "racine", qui n'a pas de surtype
	
	public Concept makeConcept(String name, Type type, List<Type> args);
	public Concept makeConcept(String sqlColumn, String sqlTable, String name, Type type);
	
}
