package databaseInspection;

public class ColumnImpl implements Column 
{
	private String type;
	private String name;
	private int length;
	private boolean primaryKey;

	public ColumnImpl(String name, String type, int length, boolean pk){
		this.name = name;
		this.type = type;
		this.length = length;
		this.primaryKey = pk;
	}

	@Override
	public String getName(){
		return this.name;
	}

	@Override
	public String getType(){
		return this.type;
	}

	@Override
	public int getLength(){
		return this.length;
	}

	@Override
	public boolean isPk(){
		return this.primaryKey;
	}
	
	@Override
	public boolean equals(Column l){
		return this.name.equals(l.getName());
	}
}
