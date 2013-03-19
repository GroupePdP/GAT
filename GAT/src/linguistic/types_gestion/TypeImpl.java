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

	@Override
	public String toString() {
		return this.name;
	}
	
	public boolean equals(TypeImpl t) {
		return (this.name.equals(t.getName()) && this.surtype.equals(t.getSurtype()));
	}

}
