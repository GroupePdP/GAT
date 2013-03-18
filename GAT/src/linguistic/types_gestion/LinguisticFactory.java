/** Classe LinguisticFactory (c'est un Singleton)
 * fait partie du pattern AbstractFactory
 * delegue la creation a TypeManager
 */

package src.linguistic.types_gestion;

import java.util.List;

import src.linguistic.concepts_gestion.Concept;
import src.linguistic.concepts_gestion.ConceptComplex;
import src.linguistic.concepts_gestion.ConceptSimple;


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
	public ConceptSimple makeConcept(String sqlColumn, String sqlTable, String name,
			Type type) {
		Concept c = new ConceptSimple(sqlColumn, sqlTable, name, type);
		tm.getTypeTree().addConcept(c);
		return (ConceptSimple) c;
	}

}
