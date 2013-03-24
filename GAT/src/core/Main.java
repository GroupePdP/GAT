package core;

import ihm.MainFrame;

public class Main {

	public static void main(String[] args){

		String emplacement = System.getProperty("user.dir").substring(0, System.getProperty("user.dir").length() -4) + "\\Projets";
		Core core = new Core(emplacement);

		System.out.println(PasswordManager.encrypt("testpassword123lolilol"));
		System.out.println(PasswordManager.decrypt((PasswordManager.encrypt("testpassword123lolilol"))));

		MainFrame mf = new MainFrame();

	}
}

