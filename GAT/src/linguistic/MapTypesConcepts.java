package linguistic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTypesConcepts {

	private static Map<Type, List<Concept>> map; 
	
	public MapTypesConcepts(){
		this.map = new HashMap<Type, List<Concept>>();
	}
	
	static public List<Concept> addConcept(Concept c){
		Type typeC = c.getType();
		List<Concept> list = map.get(typeC);
		list.add(c); // vérifier ce qu'il se passe si la key typeC n'existe pas dans la map !
		return map.put(typeC, list);
	}
	
	static public List<Concept> getListConcept(Type t){
		return map.get(t);
	}
}
