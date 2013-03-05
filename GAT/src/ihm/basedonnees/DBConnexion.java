package ihm.basedonnees;

import java.sql.Connection;

public interface DBConnexion {
	
	public Connection connexion();
	public Connection deconnexion();

}
