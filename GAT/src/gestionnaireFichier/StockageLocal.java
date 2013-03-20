package gestionnaireFichier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FilenameFilter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class StockageLocal implements Stockage {

	private XStream xstream;
	private String repertoireSauvegarde;
	
	public void setRepertoire (String name){
		this.repertoireSauvegarde = name;
	}

	public StockageLocal(String emplacement)
	{

		//TODO refaire mieux teste si valide
		this.repertoireSauvegarde = emplacement;

		this.xstream = new XStream (new DomDriver());
	}
	@Override
	public Object charger(String nom)
	{
		String fichier ="";

		fichier.concat(this.repertoireSauvegarde);
		fichier.concat(nom);
		fichier.concat(".xml");
		try {
			FileReader fr = new FileReader(fichier);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			String xml = "";
			while (line != null)
			{
				xml.concat(line);
				line = br.readLine();
			}

			br.close();
			return this.xstream.fromXML(xml);
		}
		catch(IOException ex) { ex.printStackTrace(); }

		return null;
	}

	//TODO faire plus propre sans extention de fichier
	@Override
	public String[] listProjet()
	{
		File rep = new File(this.repertoireSauvegarde);
		FilenameFilter filter = new FilenameFilter(){
				public boolean accept(File rep, String fileName){
					return fileName.endsWith(".xml");
				}		
		};
		
		
		String[] in = rep.list(filter);
		String[] out = new String[in.length];
		int i = 0;
		while (i < out.length){
			out[i] = in[i].substring(0, in[i].length() - 4);
			i ++;
		}
		
		return out;

	}



	@Override
	public boolean sauvegarde(Object obj)
	{
		String fichier ="";

		fichier.concat(this.repertoireSauvegarde);
		fichier.concat(obj.toString());
		fichier.concat(".xml");
		try {
			FileWriter fw = new FileWriter(fichier);
			String xml = this.xstream.toXML(obj);
			fw.write(xml);
			fw.close();
		}
		catch(IOException ex) { ex.printStackTrace(); }

		return true;
	}

}