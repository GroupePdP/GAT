package ihm.tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import linguistic.Scenario;
import linguistic.concepts_gestion.Concept;
import linguistic.concepts_gestion.ConceptComplex;
import linguistic.concepts_gestion.ConceptSimple;
import linguistic.types_gestion.LinguisticFactory;
import linguistic.types_gestion.Type;
import linguistic.types_gestion.TypeImpl;

public class PanelColumnScenario extends JPanel{
	
	JPanel thisPane;
	JPanel currentPanel;
	Dimension thisColumnSize;
	Scenario scenario;
	
	List<Concept> conceptsList = new ArrayList<Concept>();
	Vector vecConceptList = new Vector(conceptsList);
	
	List<Concept> concepts = new ArrayList<Concept>();
	Vector vec = new Vector(concepts);
	
	JComboBox combo;
	JButton validateButton = new JButton("Valider");
	JButton addConceptButton = new JButton("Ajouter Concept");
	JList conceptListTest;
	JScrollPane main;
	JPanel columnMenu = new JPanel(new BorderLayout());
	
	

	public PanelColumnScenario(Dimension columnSize, JPanel curr, Scenario s)
	{
		this.thisPane = this;
		this.currentPanel=curr;
		this.thisColumnSize= columnSize;
		
		this.scenario = s;
		
		// vecConceptList.add(new ConceptSimple("coucou", "caymoi", "Concept 1" ,new TypeImpl("randomshit")));
		// vecConceptList.add(new ConceptSimple("coucou", "caymoi", "Concept 2" ,new TypeImpl("randomshit")));
		// vecConceptList.add(new ConceptSimple("coucou", "caymoi", "Concept 3" ,new TypeImpl("randomshit")));
		// vecConceptList.add(new ConceptSimple("coucou", "caymoi", "Concept 4" ,new TypeImpl("randomshit")));
		
		final LinguisticFactory lf = LinguisticFactory.getInstance();
		Type t1 = lf.getTypeManager().makeType("personne");
		Type t2 = lf.getTypeManager().makeType("joueur", t1);
		Type t3 = lf.getTypeManager().makeType("gain_de_match");
		Type t4 = lf.getTypeManager().makeType("match");
		
		ConceptSimple c1 = new ConceptSimple("table1","line3","Joueur1",t2);
		ConceptSimple c2 = new ConceptSimple("table2", "line5","Match 2",t4);
		List<Type> l = new ArrayList<Type>();
		l.add(t2); l.add(t4);
		ConceptComplex c3 = new ConceptComplex("gagner",t3,l); // concept (gagner(joueur, match))
		
		lf.getTypeManager().getTypeTree().addConcept(c1);
		lf.getTypeManager().getTypeTree().addConcept(c2);
		lf.getTypeManager().getTypeTree().addConcept(c3);
		
		vecConceptList.add(c1);
		vecConceptList.add(c2);
		vecConceptList.add(c3);
		
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
		
		JPanel overNewCol = new JPanel(new BorderLayout());
		
		JPanel newCol = new JPanel(new BorderLayout());
		
		this.conceptListTest=new JList(vec);
		this.conceptListTest.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.conceptListTest.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getValueIsAdjusting())
			      {
					PanelSubColumnScenario newCol = new PanelSubColumnScenario(thisColumnSize, currentPanel,(Concept)conceptListTest.getSelectedValue(),lf);
					currentPanel.add(newCol);
					currentPanel.revalidate();
			      }
				
				
			}
			
		});
		
		conceptListTest.setFixedCellWidth((int)columnSize.getWidth());
		DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		conceptListTest.setCellRenderer(centerRenderer);
		
		JScrollPane conceptScroll = new JScrollPane(conceptListTest);
		conceptScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.main = conceptScroll;
		newCol.add(conceptScroll, BorderLayout.CENTER);
		
		this.addConceptButton.setPreferredSize(new Dimension(200,30));
		this.addConceptButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addConceptButton.setVisible(false);
				validateButton.setVisible(true);
				combo.setVisible(true);
				columnMenu.repaint();
			}
			
		});
		this.validateButton.setPreferredSize(new Dimension(200,30));
		this.validateButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addConceptButton.setVisible(true);
				validateButton.setVisible(false);
				combo.setVisible(false);
				Concept c = (Concept)combo.getSelectedItem();
				addConcept(c);
				
				
				columnMenu.repaint();
			}
			
		});
		this.validateButton.setVisible(false);
		
		this.combo = new JComboBox(this.vecConceptList);
		this.combo.setVisible(false);
		
		
		this.columnMenu.add(this.addConceptButton, BorderLayout.SOUTH);
		this.columnMenu.add(this.validateButton, BorderLayout.CENTER);
		this.columnMenu.add(this.combo, BorderLayout.NORTH);
		
		
		
		overNewCol.add(newCol, BorderLayout.CENTER);
		
		
		overNewCol.add(this.columnMenu, BorderLayout.SOUTH);
		this.add(overNewCol, BorderLayout.WEST);
	}
	
	private void addConcept(Concept concept)
	{
		this.vec.add(concept);
		
		this.conceptListTest.setModel(new DefaultListModel());
		this.conceptListTest.setListData(this.vec);
		this.main.repaint();
	}
}
