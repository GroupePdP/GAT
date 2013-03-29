package databaseInspection;


public interface Column {
	public String getName();
	public String getType();
	public int getLength();
	public boolean isPk();
	public boolean equals(Column l);

}
