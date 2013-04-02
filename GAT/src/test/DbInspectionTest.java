package test;

import java.sql.SQLException;
import java.util.Scanner;

import databaseConnection.DBConnectionImpl;
import databaseInspection.Base;
import databaseInspection.BaseFactory;
import databaseInspection.BaseFactoryImpl;


public class DbInspectionTest {
	public static void main (String[] args){
		
		String url ="";
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
			String nameBase = myBase.getName();
			System.out.println(nameBase);
			dbc.disconnection();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		sc.close();
		
	}
}
