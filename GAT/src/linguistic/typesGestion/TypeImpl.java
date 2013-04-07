/* Classe TypeImpl, implemente Type.
 */

package linguistic.typesGestion;


public class TypeImpl implements Type {
	
	private String name;
	private Type surtype;
	private String description;
	
	// Constructeurs
	
	public TypeImpl(String name, Type surtype, String description){
		this.name = name;
		this.surtype = surtype;
		this.description = description;
	}
	
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
	
	public void setSurType(Type surType) {
		this.surtype = surType;
	}

	public String getName(){
		return this.name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
