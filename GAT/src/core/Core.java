package core;
import database_connection.DBConnection;
import gestionnaireFichier.*;


public class Core {
	
	private Projet projet;
	private DBConnection dbConnection;
	private StockageLocal stockageLocal;
	
	public Core (String emplacement, DBConnection dbConnection, Projet projet){
		this.stockageLocal = new StockageLocal(emplacement);
	//	this.dbConnection = new DBConnection();
	//	this.projet = new Projet();
		
	}
	
	
	public Core (String emplacement, Projet p){
		this.projet = p;
		this.stockageLocal = new StockageLocal(emplacement);
	}
	

	public void sauvegarderProjet (String name){
		this.stockageLocal.sauvegarde(name, (Object)this.projet);
	}
	
	
	public String[] getStockageLocal(){
		return this.stockageLocal.listProjet();
	}

	public void setStockageLocal(String emplacement) {
		this.stockageLocal = new StockageLocal(emplacement);
	}


	public void setProjet(Projet projet) {
		this.projet = projet;
	}


	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	
}
