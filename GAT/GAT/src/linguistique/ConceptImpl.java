package linguistique;

public abstract class ConceptImpl implements Concept {
	
	private String nom;
	private Type type;
	
	protected ConceptImpl(String nom, Type type){
		this.nom = nom;
		this.type = type;
	}

	public String getNom(){
		return this.nom;
	}
	
	public Type getType(){
		return this.type;
	}
	
	public abstract String generationSyntox();
	
}
