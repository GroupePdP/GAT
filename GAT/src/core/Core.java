package core;
import linguistic.types_gestion.LinguisticFactory;
import gestionnaireFichier.*;


public class Core {
	
	private Projet projet;
	private StockageLocal stockageLocal;
	private LinguisticFactory linguisticFactory;
	
	
	
	public Core (String emplacement, Projet p){
		this.projet = p;
		this.stockageLocal = new StockageLocal(emplacement);
	}
	
	public void chargerProjet (String name){
		this.projet = (Projet) this.stockageLocal.charger(name);
	}

	public void sauvegarderProjet (String name){
		this.stockageLocal.sauvegarde(name, (Object)this.projet);
	}
	
	public void sauvegarderProjet (){
		this.stockageLocal.sauvegarde(this.projet.getName(), (Object)this.projet);
	}
	
	public String toString(){
		String s = this.projet.toString();
		return s;
	}
	
	
	
	public String[] getStockageLocal(){
		return this.stockageLocal.listProjet();
	}

	public void setStockageLocal(String emplacement) {
		this.stockageLocal = new StockageLocal(emplacement);
	}


	public void setProjetName(String s) {
		this.projet.setName(s);
	}


	
}
