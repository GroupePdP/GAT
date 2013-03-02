package linguistic;

import java.util.HashMap;
import java.util.Map;

public class TypeTree {

	private TypeTreeNode root;
	private Map<Type, TypeTreeNode> nodeMap;
	
	public TypeTree(){
		this.root = new TypeTreeNode(new TypeImpl("object"));
		this.nodeMap = new HashMap<Type, TypeTreeNode>();
	}
		
	public TypeTreeNode addType(Type t){
		TypeTreeNode parent = nodeMap.get(t.getSurtype());
		if(parent==null)
		{
			parent = addType(t.getSurtype());
		}
		TypeTreeNode node = new TypeTreeNode(t); 
		parent.addChild(node);
		return node;
	}
	
	public void addConcept(Concept c){
		TypeTreeNode node = nodeMap.get(c.getType());
		node.addConcept(c);
	}	
}
