import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import linguistic.concepts_gestion.ConceptComplex;
import linguistic.concepts_gestion.ConceptSimple;
import linguistic.graph_concepts_gestion.GraphNodeFactory;
import linguistic.types_gestion.LinguisticFactory;
import linguistic.types_gestion.Type;
import ihm.*;

public class Core {
	public static void main(String[] args){
		
		LinguisticFactory lf = LinguisticFactory.getInstance();
		Type t1 = lf.getTypeManager().makeType("personne");
		Type t2 = lf.getTypeManager().makeType("joueur", t1);
		Type t3 = lf.getTypeManager().makeType("gain_de_match");
		Type t4 = lf.getTypeManager().makeType("match");
		
		ConceptSimple c1 = new ConceptSimple("table1","line3","Joueur1",t2);
		ConceptSimple c2 = new ConceptSimple("table2", "line5","Match 2",t4);
		List<Type> l = new ArrayList<Type>();
		l.add(t2); l.add(t4);
		ConceptComplex c3 = new ConceptComplex("gagner",t3,l); // concept (gagner(joueur, match))
		
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	MainFrame mf = new MainFrame();
            }
        });
      }
}