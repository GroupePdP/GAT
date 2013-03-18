/** Classe TypeManager (implemente le pattern Singleton)
 * gere la creation des types, leur ajout dans l'arbre de types
 */

package src.linguistic.types_gestion;


public class TypeManager {

	private TypeTree tree;
	
	public TypeManager(){
		this.tree = new TypeTree();
	}
	
	// Creation des types
	
	public Type makeType(String name, Type surtype){
		Type t = new TypeImpl(name, surtype);
		tree.addType(t);
		return t;
	}
	
	public Type makeType(String name){
		Type t = new TypeImpl(name, tree.getRoot().getType());
		tree.addType(t);
		return t;
	}

	public TypeTree getTypeTree(){
		return this.tree;
	}
	
	public boolean isCompatible(Type t1, Type t2){ // retourne true si t1 est compatible avec t2
		while(t1!=null && t1!=t2){
			t1 = t1.getSurtype();
		}
		return (t1 == t2);
	}
	
}
