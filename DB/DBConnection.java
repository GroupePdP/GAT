import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;  


public class DBConnection{
    
	private Connection conn;
	private String user;
	private char[] passw;	

    public DBConnection(JDialog dialog){
	}

	public Connection getConnection(){
		return conn;
	}

	class ActionConnexion extends AbstractAction {
        
		public ActionConnexion() {
			super("Connexion");
        }

		public void actionPerformed(ActionEvent event) {
            user = userT.getText();
			passw = passwT.getPassword();

            messageL.setText("  Connexion en cours... ");
            
            /**
            *	Passage de MDP dans un String pour la connexion à la DB. 
            **/

			String mdp="";
            for(int i=0; i<passw.length;i++) mdp+=passw[i];

			try{	
				/** 
				* 	Driver et principe de connexion à la base de données.
				**/
				
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://localhost:PORT/Nom_DB";								    
				conn = DriverManager.getConnection(url, mdp, user);
				Statement state = conn.createStatement();
				
 				dispose();
			}
			catch(Exception e){
				e.printStackTrace();
				messageL.setForeground(Color.RED);
				messageL.setText("  Erreur d'identifiant/mot de passe. ");
				passwT.setText("");
			}
        }
    }
    
}