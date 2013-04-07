/** Classe TypeManager (implemente le pattern Singleton)
 * gere la creation des types, leur ajout dans l'arbre de types
 */

package linguistic.typesGestion;


public class TypeManager {

	private TypeTree tree;
	
	public TypeManager(){
		this.tree = new TypeTree();
	}
	
	public TypeTree getTypeTree(){
		return this.tree;
	}
	
	// Creation des types
	
	public Type makeType(String name, Type surtype, String description){
		Type t = new TypeImpl(name, surtype, description);
		tree.addType(t);
		return t;
	}
	
	public Type makeType(String name, String description){
		Type t = new TypeImpl(name, tree.getRoot().getType(), description);
		tree.addType(t);
		return t;
	}

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
	/** Returns the compatibility of a first Type with a second one.
	 * The method returns True if the first Type is compatible with
	 * (i.e. is a "children"-Type of) the second Type. Else, the
	 * method returns False.
	 * @param t1 the first Type
	 * @param t2 the second Type 
	 * @return a boolean
	 * **/
	public boolean isCompatible(Type t1, Type t2){
		while(t1!=null && t1!=t2){
			t1 = t1.getSurtype();
		}
		return (t1 == t2);
	}
	
}
