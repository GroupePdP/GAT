/* Classe ConceptSimple (herite de ConceptAbstract)
 * 
 * Un concept atomique ne contient pas d'arguments
 * ne contient qu'une reference a une ligne / colonne de la bdd.
 */

package linguistic.concepts_gestion;

import java.util.ArrayList;
import java.util.List;

import linguistic.types_gestion.Type;

public class ConceptSimple extends ConceptAbstract 
{
	private String sqlTable;
	private String sqlColumn;
	
	public ConceptSimple(String sqlTable, String sqlColumn, String name, Type type)
	{
		super(name, type);
		this.sqlTable = sqlTable;
		this.sqlColumn = sqlColumn;
	}
	
	// Autres methodes
	
	@Override
	public String generateSyntox()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Type> getArguments(){
		return new ArrayList<Type>();
	}

	@Override
	public int getNumberArguments() {
		return 0;
	}
	
}
