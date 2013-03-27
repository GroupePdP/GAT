package syntox;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class SyntoxConnection{
	
	private String inputText;
	private String grammarText;
	private String lexiconText;
	private String postEditionText;
	private String currentPath = System.getProperty("user.dir")+"/src/syntox/";

	public SyntoxConnection(String requestSyntox){
		this.inputText = requestSyntox;	
		this.grammarText = readFile((new File(currentPath+"grammar.txt")));	
		this.lexiconText = readFile((new File(currentPath+"lexicon.txt")));
		this.postEditionText = readFile((new File(currentPath+"postEdition.txt")));
	}
	
	public SyntoxConnection(String requestSyntox, String grammarFile, String lexiconFile, String postEditionFile){
		this.inputText = requestSyntox;			
		this.grammarText = readFile((new File(currentPath+grammarFile)));	
		this.lexiconText = readFile((new File(currentPath+lexiconFile)));
		this.postEditionText = readFile((new File(currentPath+postEditionFile)));	
	}
	
	public String readFile(File file){
		String fileText="";
		try {
			InputStream ips = new FileInputStream(file);
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader reader = new BufferedReader(ipsr);
			String line;
			while((line = reader.readLine()) != null){
				fileText += line+"\n";         
			}
			reader.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} 
		return fileText; 
	}
	
	public void createFile(){
		String filePath = "src/syntox/pdp.html";
		try {
			File file = new File(filePath);
			FileWriter fw = new FileWriter(file.getAbsolutePath(), false);
			BufferedWriter output = new BufferedWriter(fw);
			output.write(readFile(new File(currentPath+"headerPage.html")));
			output.write(inputText+"\n</TEXTAREA>");
			output.write("\n<INPUT type=\"hidden\" name=\"grammarText\" value=\"\n"+grammarText+"\">\n");
			output.write("\n<INPUT type=\"hidden\" name=\"lexiconText\" value=\"\n"+lexiconText+"\">\n");
			output.write("\n<INPUT type=\"hidden\" name=\"postEditionText\" value=\"\n"+postEditionText+"\">\n");
			output.write(readFile(new File(currentPath+"endingPage.html")));
			output.flush();
			output.close();			
		} catch (IOException e) {
		};		
	}
	
	public void requestSyntox(){
		this.createFile();
		try {
			URI uri = new URI("file://"+currentPath+"pdp.html");
			Desktop.getDesktop().browse(uri);
		} catch (URISyntaxException e) {
		} catch (IOException e) {
		}
	}	
}