package fileManager;

public interface Storage{
	
	public Object load (String name);
	public String[] projectsList();
	public boolean backup (String name, Object obj);
}