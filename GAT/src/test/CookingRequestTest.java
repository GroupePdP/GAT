package test;

import databaseInspection.CookingRequest;
import databaseInspection.CookingRequestImpl;

public class CookingRequestTest {

	
	public static void main (String[] args){
	
		
		CookingRequest cr = new CookingRequestImpl(null);
		
		cr.addColumn("joueur", "nom" );
		cr.addColumn("joueur", "prenom");
		cr.addColumn("coincoin" , "wtf");
		
		String sql = cr.getRequest();
		
		System.out.println(sql);
		
		
		sql = cr.getRequest();
		System.out.println(sql);
		
		cr.newRequest();
		
		cr.addColumn("nation", "nat_nom" );
		cr.addColumn("nation", "nat_abr");
		
		sql = cr.getRequest();
		System.out.println(sql);
		
	}

	
	
}
