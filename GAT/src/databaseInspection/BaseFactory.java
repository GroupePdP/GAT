package databaseInspection;

import databaseConnection.DBConnection;

/* 
   
 */


public interface BaseFactory {
	
	public BaseFactory getInstance ();
    public Base extractBase(DBConnection bd);
}
