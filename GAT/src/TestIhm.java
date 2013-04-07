import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import core.Core;
import core.Project;

import linguistic.conceptsGestion.Concept;
import linguistic.conceptsGestion.ConceptSimple;
import linguistic.typesGestion.LinguisticFactory;
import linguistic.typesGestion.Type;


import ihm.*;

public class TestIhm {
	public static void main(String[] args){
		/*
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	MainFrame mf = new MainFrame();
            }
        });
        
        */
		Project tmp = new Project("Projet");
		LinguisticFactory lf = tmp.getLinguisticFactory();
		
		
		
		String emplacement = System.getProperty("user.dir").substring(0, System.getProperty("user.dir").length() -4) + File.separator+"Projets";
		Core core = new Core(emplacement, tmp);
		MainFrame mf = new MainFrame(core);
      }
}