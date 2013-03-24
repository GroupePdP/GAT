package ihm.tools;

import ihm.user.PanelHomeUser;
import ihm.user.PanelMiller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
import linguistic.conceptsGestion.Concept;
import linguistic.conceptsGestion.ConceptComplex;
import linguistic.conceptsGestion.ConceptSimple;
import linguistic.typesGestion.LinguisticFactory;
import linguistic.typesGestion.Type;
import linguistic.typesGestion.TypeImpl;

public class PanelColumnScenario extends JPanel{
	
	JPanel thisPane;
	PanelMiller currentPanel;
	Dimension thisColumnSize;
	Scenario scenario;
	PanelHomeUser currentHome;
	
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
	
	ArrayList<PanelSubColumnScenario> list = new ArrayList<PanelSubColumnScenario>();

	public PanelColumnScenario(Dimension columnSize, PanelMiller curr, Scenario s, PanelHomeUser p)
	{
		this.thisPane = this;
		this.currentPanel=curr;
		this.thisColumnSize= columnSize;
		this.currentHome = p;
		this.scenario = s;
		
		/*
		vecConceptList.add(c1);
		vecConceptList.add(c2);
		vecConceptList.add(c3);
		vecConceptList.add(c4);
		vecConceptList.add(c5);
		vecConceptList.add(c6);
		vecConceptList.add(c7);
		vecConceptList.add(c8);
		*/
		
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
					Concept tmp = (Concept)conceptListTest.getSelectedValue();
					
					if(tmp instanceof ConceptComplex)
					{
						Iterator it = list.iterator();
						
						for(;it.hasNext();)
						{
							PanelSubColumnScenario tmpCol = (PanelSubColumnScenario) it.next();
							tmpCol.setVisibleAll(false);
						}
						
						
						
						
						list.get(conceptListTest.getSelectedIndex()).setVisible(true);
					}
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
				PanelSubColumnScenario newCol = new PanelSubColumnScenario(thisColumnSize, currentPanel,c,lf);
				newCol.setVisible(false);
				currentPanel.addColumn(newCol);
				list.add(newCol);
				
				
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
