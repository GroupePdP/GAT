package linguistic;

import java.util.ArrayList;
import java.util.List;

import linguistic.graph_concepts_gestion.GraphConcepts;

public class Scenario {

	private String name;
	private List<GraphConcepts> graphList;
	
	public Scenario(String name, List<GraphConcepts> list){
		this.name = name;
		this.graphList = list;
	}
	
	public Scenario(String name){
		this.name = name;
		this.graphList = new ArrayList<GraphConcepts>();
	}
	
	public String toString(){
		return this.name + this.graphList.toString();
	}
	
	public String getName(){
		return this.name;
	}
	
	public List<GraphConcepts> getGraphList(){
		return this.graphList;
	}
	
	public void setGraphList(List<GraphConcepts> list){
		this.graphList = list;
	}
	
	public void addGraphConcepts(GraphConcepts g){
		this.graphList.add(g);
	}
	
}
