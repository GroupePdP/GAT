/** Classe LinguisticFactory (c'est un Singleton)
 * fait partie du pattern AbstractFactory
 * delegue la creation a TypeManager
 */

package linguistic.types_gestion;


public final class LinguisticFactory implements Factory{
	
	private static volatile LinguisticFactory instance = null;
	private TypeManager tm;
	
	private LinguisticFactory(){
		this.tm = new TypeManager();
	}
	
	public static LinguisticFactory getInstance(){
		if (LinguisticFactory.instance == null)
		{
			synchronized(LinguisticFactory.class){
				if (LinguisticFactory.instance == null)
				{
					LinguisticFactory.instance = new LinguisticFactory();
				}
			}
		}
		return LinguisticFactory.instance;
	}

	public TypeManager getTypeManager(){
		return this.tm;
	}
	
	@Override
	public Type makeType(String name, Type surtype){
		return tm.makeType(name, surtype);
	}

	@Override
	public Type makeType(String name){
		return tm.makeType(name);
	}

}
