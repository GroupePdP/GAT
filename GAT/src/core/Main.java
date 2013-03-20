package core;

import ihm.MainFrame;

public class Main {


	public static void main(String[] args){

		String emplacement = System.getProperty("user.dir").substring(0, System.getProperty("user.dir").length() -4) + "/Projets";
		

		Core core = new Core();
		core.setStockageLocal(emplacement);

		MainFrame mf = new MainFrame();

		String[] fichiersXml = core.getStockageLocal();
		for (String i : fichiersXml){
			System.out.println(i);
		}
	}
}
