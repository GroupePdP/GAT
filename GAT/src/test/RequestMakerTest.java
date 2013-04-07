package test;

import java.sql.SQLException;
import java.util.Scanner;

import databaseConnection.DBConnectionImpl;
import databaseInspection.Base;
import databaseInspection.BaseFactory;
import databaseInspection.BaseFactoryImpl;
import databaseInspection.RequestMaker;
import databaseInspection.RequestMakerImpl;

public class RequestMakerTest {

	
	public static void main (String[] args){
	
		String url ="";//jdbc:mysql://dbserver/";
		String user = "";
		String pwd= "";
		DBConnectionImpl dbc = null;
		Scanner sc = new Scanner(System.in);
		BaseFactory bF = BaseFactoryImpl.getInstance();
		Base myBase = null;
		
		System.out.println("entrer url");
		url = sc.nextLine();
		
		System.out.println("entrer user");
		user = sc.nextLine();

		System.out.println("entrer pwd");
		pwd = sc.nextLine();
		
		
		
		dbc = new DBConnectionImpl(url,user, pwd);
		try {
			dbc.connection();
			myBase = bF.extractBase(dbc);
			dbc.disconnection();
			
			RequestMaker cr = new RequestMakerImpl(myBase);
			
			cr.addColumn("joue", "nat_essai" );
			cr.addColumn("joue", "nat_trans");
			cr.addColumn("nation" , "nat_nom");
			
			String sql = cr.getRequest();
			
			System.out.println(sql);
			
			
			sql = cr.getRequest();
			System.out.println(sql);
			
			cr.newRequest();
			
//			cr.addColumn("nation", "nat_nom" );
//			cr.addColumn("nation", "nat_abr");
//			
//			sql = cr.getRequest();
//			System.out.println(sql);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		sc.close();
		
		
	}

	
	
}
