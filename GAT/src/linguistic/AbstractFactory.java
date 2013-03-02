/* Interface AbstractFactory
 * fait partie du pattern du meme nom, pour deleguer la creation de Type
 */

package linguistic;

public interface AbstractFactory {
	
	public Type makeType(String name, Type surtype);
	public Type makeType(String name); // Type "racine", qui n'a pas de surtype
	
}
