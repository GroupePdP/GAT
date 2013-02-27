package linguistique;

public class ConceptAtomique extends ConceptAbstract {
	
	private String sqlTable;
	private String sqlColonne;
	
	public ConceptAtomique(String sqlTable, String sqlColonne, String nom, Type type){
		super(nom, type);
		this.sqlTable = sqlTable;
		this.sqlColonne = sqlColonne;
	}

	@Override
	public String generationSyntox() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getSqlColonne(){
		return this.sqlColonne;
	}
	
	public String getSqlTable(){
		return this.sqlTable;
	}
}
