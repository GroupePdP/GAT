/** Classe LinguisticFactory (c'est un Singleton)
 * fait partie du pattern AbstractFactory
 * delegue la creation a TypeManager
 */

package linguistic.typesGestion;

import java.util.List;

import linguistic.conceptsGestion.Concept;
import linguistic.conceptsGestion.ConceptComplex;
import linguistic.conceptsGestion.ConceptSimple;


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

	@Override
	public ConceptComplex makeConcept(String name, Type type, List<Type> args) {
		Concept c = new ConceptComplex(name, type, args);
		tm.getTypeTree().addConcept(c);
		return (ConceptComplex) c;
	}

	@Override
	public ConceptSimple makeConcept(String name, Type type) {
		Concept c = new ConceptSimple(name, type);
		tm.getTypeTree().addConcept(c);
		return (ConceptSimple) c;
	}

}
