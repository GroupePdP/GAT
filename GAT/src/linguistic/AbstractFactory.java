package linguistic;

public interface AbstractFactory {
	
	public Type makeType(String name, Type surtype);
	public Type makeType(String name);
	
}
