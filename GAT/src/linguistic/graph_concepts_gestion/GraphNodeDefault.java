package src.linguistic.graph_concepts_gestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import src.linguistic.concepts_gestion.Concept;
import src.linguistic.types_gestion.LinguisticFactory;
import src.linguistic.types_gestion.Type;

public class GraphNodeDefault implements GraphNode {

	private boolean tag;
	private GraphNode reference;
	private Concept concept;
	private List<GraphNode> childrenList;

	public GraphNodeDefault(Concept c){
		this.tag = false;
		this.reference = null;
		this.concept = c;
		this.childrenList = new ArrayList<GraphNode>(c.getNumberArguments());
	}

	public GraphNodeDefault(Concept c, GraphNode ref){
		this.tag = false;
		this.reference = ref;
		this.concept = c;
		this.childrenList = new ArrayList<GraphNode>(c.getNumberArguments());
	}

	public boolean isTagged(){
		return this.tag;
	}
	
	public GraphNode getReference(){
		return this.reference;
	}

	@Override
	public Concept getConcept() {
		return this.concept;
	}

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
	public GraphNode toTree(){
		this.tag = true;
		GraphNode tree = new GraphNodeDefault(getConcept());
		if (tree.getNumberOfNodes() != 1){
			for (int i = 0; i< tree.getChildrenList().size(); i++){
				GraphNode child = tree.getChildrenList().get(i);
					try {
						if (!child.isTagged())
							tree.addChild(child.toTree(),i);

						else if (child.isTagged()){
							GraphNodeDefault newChild = new GraphNodeDefault(child.getConcept(), child);
							tree.addChild(newChild, i);
							}
					} catch (IncompatibleTypesException e) {
						return null;
					}
			}
		}
		return tree;
	}
}