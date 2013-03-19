package linguistic.graph_concepts_gestion;

import linguistic.types_gestion.Type;

public class IncompatibleTypesException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Type t1;
	private Type t2;

	public IncompatibleTypesException(Type t1, Type t2) {
		super("The "+ t1.getName() + " type is not compatible with "+ t2.getName());
		this.t1 = t1;
		this.t2 = t2;
	}
	
	public Type getType1(){
		return this.t1;
	}
	
	public Type getType2(){
		return this.t2;
	}

}
