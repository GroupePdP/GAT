package linguistic.graphConceptsGestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import linguistic.conceptsGestion.Concept;
import linguistic.typesGestion.LinguisticFactory;
import linguistic.typesGestion.Type;

public class GraphNodeDefault implements GraphNode {

	private boolean tag;
	private GraphNode reference; // le graphNode auquel this fait reference (s'il existe)
	private boolean isReference ; // true si d'autres graphNodes font reference a this
	private Concept concept;
	private List<GraphNode> childrenList;

	public GraphNodeDefault(Concept c){
		this.tag = false;
		this.reference = null;
		this.isReference = false;
		this.concept = c;
		this.childrenList = new ArrayList<GraphNode>(c.getNumberArguments());
	}

	public GraphNodeDefault(GraphNode ref){
		this.tag = ref.isTagged();
		this.reference = ref.getReference();
		this.isReference = ref.getIsReference();
		this.concept = ref.getConcept();
		this.childrenList = ref.getChildrenList();
	}
	
	@Override
	public boolean isTagged(){
		return this.tag;
	}
	
	@Override
	public void setTag(boolean b){
		this.tag = b;
	}
	
	@Override
	public GraphNode getReference(){
		return this.reference;
	}
	
	@Override
	public void setReference(GraphNode node){
		this.reference = node;
	}
	
	@Override
	public boolean getIsReference(){
		return this.isReference;
	}
	
	@Override
	public void setIsReference(boolean b){
		this.isReference = b;
	}
	
	@Override
	public Concept getConcept() {
		return this.concept;
	}
	
	@Override
	public List<GraphNode> getChildrenList(){
		return this.childrenList;
	}

	@Override
	public GraphNode getRoot() {
		return this;
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
	public int getNumberOfNodes() {
		return getListNodes().size();
	}
	
	@Override
	public void addChild(GraphNode child,int index) throws IncompatibleTypesException{
		List<Type> list = getConcept().getArguments();
		Type t = list.get(index);
		Concept c = child.getConcept();
		Type tChild = c.getType();

		if (LinguisticFactory.getInstance().getTypeManager().isCompatible(tChild,t)){ // on verifie la compatibilité de tChild et t
			if(child.isTagged()){
				GraphNode childReference = new GraphNodeDefault(child);
				childReference.setReference(child);
				child.setIsReference(true);
				if(getChildrenList().size()<=index)
					getChildrenList().add(index,childReference);
				getChildrenList().set(index,childReference);
			}
			else // child n'est pas tague
			{
				child.setTag(true);
				if(getChildrenList().size()<=index)
					getChildrenList().add(index,child);
				getChildrenList().set(index,child);
			}
		}
		else
			throw new IncompatibleTypesException(tChild, t);
	}

}