package ihm.tools;

import ihm.MainFrame;
import ihm.admin.PanelNewProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import linguistic.conceptsGestion.Concept;
import linguistic.conceptsGestion.ConceptComplex;

public class PanelConceptColumnProject extends JPanel{

	MainFrame currentFrame;
	PanelNewProject thisPane;
	
	//ArrayList<PanelArgsColumnProject> conceptsList = new ArrayList<PanelArgsColumnProject>();
	Vector<PanelArgsColumnProject> vecConceptList;
	
	JList conceptsJList;
	
	JButton validateButton = new JButton("Valider");
	JButton addConceptButton = new JButton("Ajouter Concept");
	JTextField conceptName = new JTextField(16);
	JScrollPane scrollMain;
	JPanel columnMenu = new JPanel(new BorderLayout());
	
	public PanelConceptColumnProject(MainFrame mf, PanelNewProject pane)
	{
		this.setLayout(new BorderLayout());
		//this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
		this.currentFrame = mf;
		this.thisPane = pane;
		this.vecConceptList = this.thisPane.getVecConceptList();
		
		this.setBackground(Color.ORANGE);
		Dimension columnSize = new Dimension(350,this.thisPane.getHeight());
		this.setPreferredSize(columnSize);
		
		this.conceptsJList=new JList(vecConceptList);
		this.conceptsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.conceptsJList.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) 
			{
				// TODO Auto-generated method stub
				if(arg0.getValueIsAdjusting())
			      {
					thisPane.setCurrentArgsPanel(vecConceptList.get(conceptsJList.getSelectedIndex()));
			      }
			}
		});
		this.addConceptButton.setPreferredSize(new Dimension(200,30));
		this.addConceptButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addConceptButton.setVisible(false);
				validateButton.setVisible(true);
				conceptName.setText("");
				conceptName.setVisible(true);
				columnMenu.repaint();
			}
			
		});
		this.validateButton.setVisible(false);
		this.validateButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addConceptButton.setVisible(true);
				validateButton.setVisible(false);
				conceptName.setVisible(false);
				PanelArgsColumnProject tmp = new PanelArgsColumnProject(currentFrame, thisPane,conceptName.getText());
				addConcept(tmp);
				columnMenu.repaint();
			}
			
		});
		this.conceptName.setVisible(false);
		
		this.columnMenu.add(this.addConceptButton, BorderLayout.SOUTH);
		this.columnMenu.add(this.validateButton, BorderLayout.CENTER);
		this.columnMenu.add(this.conceptName, BorderLayout.NORTH);
		
		
		//conceptsJList.setFixedCellWidth((int)columnSize.getWidth());
		DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		conceptsJList.setCellRenderer(centerRenderer);
		JScrollPane conceptScroll = new JScrollPane(conceptsJList);
		conceptScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.scrollMain=conceptScroll;
		
		JPanel overCol = new JPanel(new BorderLayout());
		this.add(this.scrollMain, BorderLayout.CENTER);
		this.add(this.columnMenu, BorderLayout.SOUTH);
	}
	
	private void addConcept(PanelArgsColumnProject concept)
	{
		this.vecConceptList.add(concept);
		concept.setVisible(false);
		this.thisPane.getConceptColumnPanel().add(concept);
		this.conceptsJList.setModel(new DefaultListModel());
		this.conceptsJList.setListData(this.vecConceptList);
		this.thisPane.repaint();
		//this.scrollMain.repaint();
	}
}
