package databaseInspection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databaseConnection.DBConnection;

/* 
   
 */


public class BaseFactoryImpl implements  BaseFactory
{
	
	private BaseFactoryImpl(){};
	private static volatile BaseFactoryImpl instance = null;
	
	public static BaseFactory getInstance() {
		
		if(BaseFactoryImpl.instance == null)
		{
			synchronized(BaseFactoryImpl.class)
			{
				if(BaseFactoryImpl.instance == null)
				{
					BaseFactoryImpl.instance = new BaseFactoryImpl();
				}
			}
		}
		
		
		return BaseFactoryImpl.instance;
	}
	
	@Override
	public Base extractBase(DBConnection bdc) 
	{
		String nameBase = bdc.getNameBase();
		Base newBase = new BaseImpl(nameBase);
		
		try {
			String requestTable = "show tables from "+ nameBase;
			ResultSet resultTable = bdc.selectQuery(requestTable);
			ArrayList<String> lisNameTable = new ArrayList<String>();
		
		
			while(resultTable.next())
			{
				lisNameTable.add(resultTable.getString(1));
			}
		
			resultTable.close();
			
			for (String nameTable :lisNameTable)
			{
				Table newTable = new TableImpl (nameTable);
				
				String requestLigne = "show columns from "+nameBase+"."+nameTable;
				ResultSet resultLine = bdc.selectQuery(requestLigne);
				while(resultLine.next())
				{
					String lineName = resultLine.getString(1);
					String lineType = resultLine.getString(2);
					//@TODO faire taille plus propre
					int lineLenght = 0; 
					boolean pk = resultLine.getString(4)== "PRI";
					Column newLine = new ColumnImpl(lineName, lineType, lineLenght, pk);
					
					newTable.addLine(newLine);
					
					
				}
				resultLine.close();
				newBase.addTable(newTable);
			}
			
			//@TODO ajout des jointure
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newBase;
	}
}
