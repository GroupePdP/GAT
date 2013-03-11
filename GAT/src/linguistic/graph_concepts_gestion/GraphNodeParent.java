package linguistic.graph_concepts_gestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import linguistic.concepts_gestion.Concept;
import linguistic.concepts_gestion.ConceptComplex;
import linguistic.types_gestion.LinguisticFactory;
import linguistic.types_gestion.Type;

public class GraphNodeParent implements GraphNode {
	
	private ConceptComplex concept;
	private List<GraphNode> childrenList;

	public GraphNodeParent(ConceptComplex c){
		this.concept = c;
		this.childrenList = new ArrayList<GraphNode>(c.getNumberArguments());
	}
	
	@Override
	public Concept getConcept() {
		return this.concept;
	}
	
	public List<GraphNode> getChildrenList(){
		return this.childrenList;
	}
	
	public void addChild(GraphNode child,int index) throws IncompatibleTypesException{
		List<Type> list = this.concept.getArguments();
		Type t = list.get(index);
		Concept c = child.getConcept();
		Type tChild = c.getType();

		if (LinguisticFactory.getInstance().getTypeManager().isCompatible(tChild,t)) // on verifie la compatibilité de tChild et t
				childrenList.add(index,child); 
		else
			throw new IncompatibleTypesException(tChild, t);
	}

	@Override
	public List<GraphNode> getListNodes() {
		List<GraphNode> list = new LinkedList<GraphNode>();
		list.add(this);
		for (GraphNode node : getChildrenList()){
			list.addAll(node.getListNodes());
		}
		return list;
	}

	@Override
	public GraphNode getRoot() {
		return this;
	}

	@Override
	public int getNumberOfNodes() {
		return getListNodes().size();
	}	

}
