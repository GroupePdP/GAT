/* Classe ConceptSimple (herite de ConceptAbstract)
 * 
 * Un concept atomique ne contient pas d'arguments
 * ne contient qu'une reference a une ligne / colonne de la bdd.
 */

package linguistic;

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
	
	// Accesseurs 
	
	public String getSqlColumn()
	{

		return this.sqlColumn;
	}
	
	public String getSqlTable()
	{
		return this.sqlTable;
	}
	
	// Autres methodes
	
	@Override
	public String syntoxGeneration()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
