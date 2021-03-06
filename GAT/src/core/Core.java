package core;
import linguistic.graphConceptsGestion.GraphNodeFactory;
import fileManager.LocalStorage;

public class Core {
	
	private Project project;
	private LocalStorage localStorage;
	private GraphNodeFactory graphNodeFactory;
	
	/* Constructeurs */
	
	public Core (String location){
		this.localStorage = new LocalStorage(location);
		this.graphNodeFactory = GraphNodeFactory.getInstance();
	}
	
	public Core (String location, Project p){
		this.project = p;
		this.localStorage = new LocalStorage(location);
		this.graphNodeFactory = GraphNodeFactory.getInstance();
	}
	
	/* Accesseurs et modificateurs */
	
	public Project getProject(){
		return this.project;
	}
	
	public void setProject(Project p){
		this.project = p;
	}
	
	public void newProject(String name){
		this.project = new Project();
		this.project.setName(name);
	}
	
	public String[] getLocalStorageProjectList(){
		return this.localStorage.projectsList();
	}
	
	public LocalStorage getLocalStorage(){
		return this.localStorage;
	}

	public void setLocalStorage(String location){
		this.localStorage = new LocalStorage(location);
	}
	
	public GraphNodeFactory getGraphNodeFactory(){
		return this.graphNodeFactory;
	}
	
	/* Autres methodes */
	
	public void setProjectName(String s){
		this.project.setName(s);
	}
	
	public void loadProject(String name){
		this.project = (Project) this.localStorage.load(name);
	}

	public void backupProject(String name){
		this.localStorage.backup(name, (Object)this.project);
	}
	
	public void backupProject(){
		this.localStorage.backup(this.project.getName(), (Object)this.project);
	}
	
	public String toString(){
		return this.project.toString();
	}	
	
	public String toStringDescr(){
		return this.project.toStringDescr();
	}	
}
