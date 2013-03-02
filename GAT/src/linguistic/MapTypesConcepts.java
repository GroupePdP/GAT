/* 
 * 
 * 
 */

package linguistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTypesConcepts {

	private Map<Type, List<Concept>> map; 
	
	public MapTypesConcepts(){
		this.map = new HashMap<Type, List<Concept>>();
	}
	
	public void addConcept(Concept c){
		Type typeC = c.getType();
		List<Concept> list = map.get(typeC);
		if (list == null)
		{
			List<Concept> newList = new ArrayList<Concept>();
			newList.add(c);
			map.put(typeC, newList);
		}
		list.add(c);
	}
	
	public List<Concept> getListConcept(Type t){
		return map.get(t);
	}
}
