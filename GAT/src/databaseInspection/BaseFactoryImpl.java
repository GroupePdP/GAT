package databaseInspection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databaseConnection.DBConnection;

/* 
   
 */


public class BaseFactoryImpl implements  BaseFactory
{
	
	private static volatile BaseFactoryImpl instance = null;
	private BaseFactoryImpl(){};
	
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
			ArrayList<String> listNameTable = new ArrayList<String>();
		
		
			while(resultTable.next())
			{
				listNameTable.add(resultTable.getString(1));
			}
		
			resultTable.close();
			
			for (String nameTable :listNameTable)
			{
				Table newTable = new TableImpl (nameTable);
				
				String requestLigne = "show columns from "+nameBase+"."+nameTable;
				ResultSet resultLine = bdc.selectQuery(requestLigne);
				while(resultLine.next())
				{
					String lineName = resultLine.getString(1);
					String lineType = resultLine.getString(2);
					//@TODO faire taille plus propre
					int lineLenght = 1; 
					boolean pk = resultLine.getString(4)== "PRI";
					
					Column newLine = new ColumnImpl(lineName, lineType, lineLenght, pk);
					newTable.addLine(newLine);
					
					
				}
				resultLine.close();
				newBase.addTable(newTable);
			}
			
			String requestJoin =
					"select table_name, column_name, referenced_table_name, referenced_column_name " +
					"from information_schema.key_column_usage " +
					"where referenced_table_name is not null and table_schema = '" + nameBase +"';";
			ResultSet resultJoin = bdc.selectQuery(requestJoin);
			
			while(resultJoin.next())
			{
				String table1 = resultJoin.getString(1);
				String tableN = resultJoin.getString(3);
				String key1 = resultJoin.getString(2);
				String keyN = resultJoin.getString(4);
				JoinTable newJoin = new JoinTableImpl(table1, tableN,key1,keyN );
				newBase.addJoin(newJoin);
			}
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newBase;
	}
}
