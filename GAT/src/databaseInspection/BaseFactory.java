package databaseInspection;

import databaseConnection.DBConnection;


public interface BaseFactory {
	
	public Base extractBase(DBConnection bd);
}
