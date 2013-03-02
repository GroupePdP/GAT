/* Classe TypeImpl, implemente Type.
 * 
 */

package linguistic;

public class TypeImpl implements Type {
	
	private String name;
	private Type surtype;
	
	public TypeImpl(String name, Type surtype){
		this.name = name;
		this.surtype = surtype;
	}

	public TypeImpl(String name){
		this(name, null);
	}
	
	public Type getSurtype() {
		return this.surtype;
	}
	
	public String getName(){
		return this.name;
	}

}
