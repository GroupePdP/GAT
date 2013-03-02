package linguistic;

public class TypeManager {
	
	private TypeTree tree;
	
	public TypeManager(){
		this.tree = new TypeTree();
	}
	
	public Type makeType(String name, Type surtype){
		Type t = new TypeImpl(name, surtype);
		
		return t;
	}
	
	public Type makeType(String name){
		return new TypeImpl(name);
	}

	public TypeTree getTypeTree(){
		return this.tree;
	} 
	
}
