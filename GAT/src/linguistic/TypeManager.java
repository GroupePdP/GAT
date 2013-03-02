package linguistic;

public class TypeManager {
	
	private TypeTree tree;
	
	public TypeManager(){
		this.tree = new TypeTree();
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

	public TypeTree getTypeTree(){
		return this.tree;
	} 
	
}
