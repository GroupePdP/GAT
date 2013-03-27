package databaseInspection;

public interface Table 
{
	public Line getLine(String key);
	
	public void addLine(Line line);

	public String getName();
}
