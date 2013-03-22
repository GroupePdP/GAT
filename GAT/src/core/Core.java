package core;
import linguistic.typesGestion.LinguisticFactory;
import fileManager.*;


public class Core {
	
	private Project project;
	private LocalStorage localStorage;
	private LinguisticFactory linguisticFactory;
	
	public Core (String location){
		this.localStorage = new LocalStorage(location);
	}
	
	public Core (String location, Project p){
		this.project = p;
		this.localStorage = new LocalStorage(location);
	}
	
	
	
	public void loadProject (String name){
		this.project = (Project) this.localStorage.load(name);
	}

	public void backupProject (String name){
		this.localStorage.backup(name, (Object)this.project);
	}
	
	public void backupProject (){
		this.localStorage.backup(this.project.getName(), (Object)this.project);
	}
	
	public String toString(){
		return this.project.toString();

	}
	
	
	
	public String[] getLocalStorage(){
		return this.localStorage.projectsList();
	}

	public void setLocalStorage(String location) {
		this.localStorage = new LocalStorage(location);
	}


	public void setProjetName(String s) {
		this.project.setName(s);
	}


	
}
