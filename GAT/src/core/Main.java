package core;

import java.io.File;

import ihm.MainFrame;

public class Main {

	public static void main(String[] args){
		String emplacement = System.getProperty("user.dir").
				substring(0, System.getProperty("user.dir").length() -4)
				+ File.separator + "Projets";
		Core core = new Core(emplacement);
		new MainFrame(core); 
	}
}

