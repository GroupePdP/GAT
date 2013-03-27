package databaseInspection;


public interface Line {
	public String getName();
	public String getType();
	public int getLength();
	public boolean isPk();
	public boolean isFk();
	public boolean equals(Line l);

}
