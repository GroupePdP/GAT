package databaseInspection;

import databaseConnection.DBConnection;

/* 
   
 */


public class BaseFactoryImpl implements  BaseFactory
{
	
	private BaseFactoryImpl(){};
	private static volatile BaseFactoryImpl instance = null;
	
	@Override
	public BaseFactory getInstance() {
		
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
	public Base extractBase(DBConnection bd) 
	{
		
		
		return null;
	}
}
