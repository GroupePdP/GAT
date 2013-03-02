/* Classe LinguisticFactory
 * fait partie du pattern AbstractFactory
 * delegue la creation a TypeManager
 */

package linguistic;

public class LinguisticFactory implements AbstractFactory {
	
	private TypeManager tm;

	@Override
	public Type makeType(String name, Type surtype) {
		return tm.makeType(name, surtype);
	}

	@Override
	public Type makeType(String name) {
		return tm.makeType(name);
	}

}
