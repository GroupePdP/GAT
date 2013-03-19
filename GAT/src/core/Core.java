package core;
import database_connection.DBConnection;
import ihm.MainFrame;

public class Core {
	
	private Projet projet;
	private DBConnection dbConnection;
//	private Serialisation serial;
	
	public static void main(String[] args){
        MainFrame mf = new MainFrame();
	}

	
/*	public Serialisation getSerial() {
		return serial;
	}


	public void setSerial(Serialisation serial) {
		this.serial = serial;
	}
*/

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public DBConnection getDb_connection() {
		return dbConnection;
	}

	public void setDb_connection(DBConnection db_connection) {
		this.dbConnection = db_connection;
	}
	
	
}
