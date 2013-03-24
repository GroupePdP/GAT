package fileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FilenameFilter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class LocalStorage implements Storage {

	private XStream xstream;
	private String backupDirectory;
	
	public void setDirectory (String name){
		this.backupDirectory = name;
	}

	public LocalStorage(String location)
	{
		//TODO refaire mieux teste si valide
		this.backupDirectory = location;
		this.xstream = new XStream (new DomDriver());
	}
	
	
	@Override
	public Object load(String name)
	{
		String file = this.backupDirectory + "\\" + name + ".xml";
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			String xml = "";
			while (line != null)
			{
				xml = xml + line;
				line = br.readLine();
			}
			br.close();			
			return this.xstream.fromXML(xml);
		}
		catch(IOException ex) {
			ex.printStackTrace(); 
			}
		return null;
	}

	//TODO faire plus propre sans extension de fichier
	@Override
	public String[] projectsList()
	{
		File rep = new File(this.backupDirectory);
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
			i++;
		}
		return out;
	}

	@Override
	public boolean backup(String name, Object obj)
	{
		String file = this.backupDirectory + "\\" + name + ".xml";
		try {
			FileWriter fw = new FileWriter(file);
			String xml = this.xstream.toXML(obj);
			fw.write(xml);
			fw.close();
		}
		catch(IOException ex) { 
			ex.printStackTrace(); 
			}
		return true;
	}

}