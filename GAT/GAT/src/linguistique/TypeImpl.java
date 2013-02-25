package linguistique;

public class TypeImpl implements Type {
	
	private String nom;
	private Type surtype;
	
	public TypeImpl(String nom, Type surtype){
		this.nom = nom;
		this.surtype = surtype;
	}

	public Type getSurtype() {
		return this.surtype;
	}
	
	public String getNom(){
		return this.nom;
	}

}
