/**
 * Je modifie le fichier pour ne laisser que les éléments important. 
**/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;  

   
// Elements pour illustrer.

private Connection conn;
private String user;
private char[] passw;	


/**
*   Passage de MDP dans un String pour la connexion à la DB. 
* 	Il est possible d'utiliser un élément Password qui cache le mot de passe taper. Ce dernier peut être 
* 	ensuite passé en "char" au moyen d'une méthode mais il est nécessaire de l'avoir en String pour la
* 	connexion.	
**/

String mdp="";
for(int i=0; i<passw.length;i++) mdp+=passw[i];

			
/** 
*   Driver et principe de connexion à la base de données.
* 	Obligatoirement dans un bloc try/catch
**/
try{				
	Class.forName("org.postgresql.Driver");
	String url = "jdbc:postgresql://localhost:PORT/Nom_DB";								    
	conn = DriverManager.getConnection(url, mdp, user);
	Statement state = conn.createStatement();
}
catch(Exception e){
	
	e.printStackTrace();
	
	//On peut penser à rénitialiser le mot de passe en cas c'échec. Ici le JTextField utilisé pour le rentrer est
	//passwT	
	messageL.setForeground(Color.RED);
	messageL.setText("  Erreur d'identifiant/mot de passe. ");
	passwT.setText("");
}
        

/**
* Méthode Get à prévoir selon comment on utilisera l'objet.
**/
public Connection getConnection(){
	return conn;
}
	
