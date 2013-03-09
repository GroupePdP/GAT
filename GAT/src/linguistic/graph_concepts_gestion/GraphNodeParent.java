package linguistic.graph_concepts_gestion;

import java.util.ArrayList;
import java.util.List;

import linguistic.concepts_gestion.Concept;
import linguistic.concepts_gestion.ConceptComplex;
import linguistic.types_gestion.LinguisticFactory;
import linguistic.types_gestion.Type;

public class GraphNodeParent implements GraphNode {
	
	private ConceptComplex concept;
	private List<GraphNode> childrenList;

	public GraphNodeParent(ConceptComplex c2){ 
		this.concept = c2;
		this.childrenList = new ArrayList<GraphNode>(c2.getNumberArguments());
	}
	
	@Override
	public Concept getConcept() {
		return this.concept;
	}
	
	public List<GraphNode> getChildrenList(){
		return this.childrenList;
	}
	
	public void addChild(GraphNode child){ // XXXXX
		List<Type> list = this.concept.getArguments();
		Concept c = child.getConcept();
		Type tChild = c.getType();
		// if (LinguisticFactory.getInstance().getTypeManager().isCompatible(tChild,t))
				childrenList.add(child); // rajouter la verification des types !! et lever une exception si pas le cas
	}

}
