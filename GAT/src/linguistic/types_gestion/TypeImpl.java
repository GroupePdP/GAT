/* Classe TypeImpl, implemente Type.
 */

package linguistic.types_gestion;


public class TypeImpl implements Type {
	
	private String name;
	private Type surtype;
	
	// Constructeurs
	
	public TypeImpl(String name, Type surtype){
		this.name = name;
		this.surtype = surtype;
	}

	public TypeImpl(String name){
		this.name = name;
		this.surtype = null;
	}
	
	// Accesseurs
	
	public Type getSurtype() {
		return this.surtype;
	}
	
	public String getName(){
		return this.name;
	}

}
