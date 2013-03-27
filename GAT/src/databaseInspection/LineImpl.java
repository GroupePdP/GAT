package databaseInspection;

public class LineImpl implements Line 
{

	private String type;
	private String name;
	private int length;
	private boolean primaryKey;
	private boolean foreignKey;

	public LineImpl (String nom, String type, int length, boolean pk,boolean fk)
	{
		this.name = nom;
		this.type = type;
		this.length = length;
		this.primaryKey = pk;
		this.foreignKey = fk;
	}

	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public String getType()
	{
		return this.type;
	}

	@Override
	public int getLenght()
	{
		return this.length;
	}

	@Override
	public boolean isPk() {
		return this.foreignKey;
	}

	@Override
	public boolean isFk() 
	{
		return this.primaryKey;
	}
	
	@Override
	public boolean equals( Line l)
	{
		return this.name.equals(l.getName());
	}


}
