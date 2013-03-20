package gestionnaireFichier;

public interface Stockage {
	public Object charger (String nom);
	public String [] listProjet();
	public boolean sauvegarde (String name, Object obj);
}