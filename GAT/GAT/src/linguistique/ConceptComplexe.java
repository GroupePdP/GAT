package linguistique;

import java.util.List;

public class ConceptComplexe extends ConceptImpl {
	
	private List<Type> arguments;
	
	protected ConceptComplexe(String nom, Type type, List<Type> args) {
		super(nom, type);
		this.arguments = args;
	}

	public List<Type> getArguments(){
		return this.arguments;
	}

	@Override
	public String generationSyntox() {
		// TODO Auto-generated method stub
		return null;
	}

}
