package databaseInspection;


public interface Line 
{
	public String getName();

	public String getType();

	public int getLenght();

	public boolean isPk();

	public boolean isFk();

	public boolean equals( Line l);


}
