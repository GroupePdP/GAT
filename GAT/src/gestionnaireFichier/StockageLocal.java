package gestionnaireFichier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class StockageLocal implements Stockage {

	private XStream xstream;
	private String repertoirSauvegarde;

	public StockageLocal(String emplacement)
	{

		//TODO refaire mieux teste si valide
		this.repertoirSauvegarde = emplacement;

		this.xstream = new XStream (new DomDriver());
	}
	@Override
	public Object charger(String nom)
	{
		String fichier ="";

		fichier.concat(this.repertoirSauvegarde);
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
		File rep = new File(this.repertoirSauvegarde);
		return rep.list();
	}

	@Override
	public boolean sauvegarde(Object obj)
	{
		String fichier ="";

		fichier.concat(this.repertoirSauvegarde);
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