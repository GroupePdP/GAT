package linguistique;

public abstract class ConceptAbstract implements Concept {
	
	private String nom;
	private Type type;
	
	protected ConceptAbstract(String nom, Type type){
		this.nom = nom;
		this.type = type;
	}

	public String getNom(){
		return this.nom;
	}
	
	public Type getType(){
		return this.type;
	}
	
}
