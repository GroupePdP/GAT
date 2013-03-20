package core;

import ihm.MainFrame;

public class Main {

	
	public static void main(String[] args){
		
		String emplacement = System.getProperty("user.dir");
	       
		Core core = new Core();
		core.setStockageLocal(emplacement);
		
		MainFrame mf = new MainFrame();
		
		String[] fichiersXml = core.getStockageLocal();
		for (String i : fichiersXml){
			System.out.println(i);
	}
}
}
