package syntox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**	
  * ATTENTION : Cette classe est encore une ébauche.
**/

public class SyntoxConnection {
	
	private OutputStreamWriter writer;
	private BufferedReader reader;
	private URLConnection connection;
	private String answer, requete;

	public SyntoxConnection(){
		try {
			URL url = new URL("https://signes.bordeaux.inria.fr/syntox/pdp.php");
			this.connection = url.openConnection();			
			connection.setDoOutput(true);
			this.writer = new OutputStreamWriter(connection.getOutputStream());
		} catch (IOException e) {
			// Prévoir éventuellement une JDialog annonçant l'erreur si jamais la connexion échoue.
		}
	}

	public void sendRequestToSyntox(String r){
		try {
			requete = "Axiom[PRED:commander, subj:[PRED:pro, person:1, number:sg], obj:[PRED:article, " +
					"gender:ms, number:sg, def:-, poss:-, dem:-, possnumber:sg, possperson:1], à-obj:[FORM:\"Martin-Duplomb\", " +
					"number:sg, person:3, gender:ms], diathesis:active, tense:present, pastp:-]";
			writer.write(requete);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// Prévoir éventuellement une JDialog annonçant l'erreur si jamais la requête n'est pas envoyée.
		}
	}

	public String getAnswerFromSyntox(){
		try {
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((answer = reader.readLine()) != null) {
				System.out.println(answer);
			}
			return answer;
		} catch (IOException e) {
			return null;
			// Prévoir éventuellement une JDialog annonçant l'erreur si jamais la requête n'est pas envoyée.
		}
	}

	/* Main pour tester
	public static void main(String []args){
		SyntoxConnection sc = new SyntoxConnection();
		sc.syntoxRequest("");
		try {
			sc.syntoxAnswer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("END");
	}*/

}
