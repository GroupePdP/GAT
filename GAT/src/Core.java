import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import linguistic.conceptsGestion.ConceptSimple;
import linguistic.typesGestion.LinguisticFactory;
import linguistic.typesGestion.Type;


import ihm.*;

public class Core {
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	MainFrame mf = new MainFrame();
            }
        });
      }
}