package linguistic.graph_concepts_gestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import linguistic.concepts_gestion.Concept;
import linguistic.concepts_gestion.ConceptComplex;
import linguistic.types_gestion.LinguisticFactory;
import linguistic.types_gestion.Type;

public class GraphNode implements GraphNodeDefault {
	
	private ConceptComplex concept;
	private List<GraphNodeDefault> childrenList;

	public GraphNode(ConceptComplex c){
		this.concept = c;
		this.childrenList = new ArrayList<GraphNodeDefault>(c.getNumberArguments());
	}
	
	@Override
	public Concept getConcept() {
		return this.concept;
	}
	
	public List<GraphNodeDefault> getChildrenList(){
		return this.childrenList;
	}
	

	@Override
	public GraphNodeDefault getRoot() {
		return this;
	}
	
	@Override
	public List<GraphNodeDefault> getListNodes() {
		List<GraphNodeDefault> list = new LinkedList<GraphNodeDefault>();
		list.add(this);
		for (GraphNodeDefault node : getChildrenList()){
			list.addAll(node.getListNodes());
		}
		return list;
	}

	@Override
	public int getNumberOfNodes() {
		return getListNodes().size();
	}	
	
	public void addChild(GraphNodeDefault child,int index) throws IncompatibleTypesException{
		List<Type> list = this.concept.getArguments();
		Type t = list.get(index);
		Concept c = child.getConcept();
		Type tChild = c.getType();

		if (LinguisticFactory.getInstance().getTypeManager().isCompatible(tChild,t)) // on verifie la compatibilité de tChild et t
				childrenList.add(index,child); 
		else
			throw new IncompatibleTypesException(tChild, t);
	}

}
