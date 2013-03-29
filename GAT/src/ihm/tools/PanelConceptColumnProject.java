package ihm.tools;

import ihm.MainFrame;
import ihm.admin.PanelNewProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import linguistic.Scenario;
import linguistic.conceptsGestion.Concept;
import linguistic.typesGestion.TypeTree;

public class PanelConceptColumnProject extends JPanel{

	MainFrame currentFrame;
	PanelNewProject thisPane;
	
	//ArrayList<PanelArgsColumnProject> conceptsList = new ArrayList<PanelArgsColumnProject>();
	Vector<PanelArgsColumnProject> vecConceptList;
	
	JList conceptsJList;
	
	JButton validateButton = new JButton("Valider");
	JButton addConceptButton = new JButton("Ajouter Concept");
	JTextField conceptName = new JTextField(16);
	
	JComboBox conceptTypeCombo = new JComboBox();
	
	
	JScrollPane scrollMain;
	JPanel menuPanel = new JPanel();
	JPanel columnMenu = new JPanel(new BorderLayout());
	
	public PanelConceptColumnProject(MainFrame mf, PanelNewProject pane)
	{
		this.setLayout(new BorderLayout());
		this.currentFrame = mf;
		this.thisPane = pane;
		this.vecConceptList = this.thisPane.getVecConceptList();
		
		this.setBackground(Color.ORANGE);
		Dimension columnSize = new Dimension(350,this.thisPane.getHeight());
		this.setPreferredSize(columnSize);
		
		final JPopupMenu popup_desktop = new JPopupMenu("Desktop Menu : ");
		JMenuItem suppr = new JMenuItem("Supprimer Concept");
		suppr.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeConcept(conceptsJList.getSelectedIndex());
			}
			
		});
		
		JMenuItem syntox = new JMenuItem("Ajouter entrée Synthox");
		syntox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TypeTree treeTmp = currentFrame.getCore().getProject().getLinguisticFactory().getTypeManager().getTypeTree();
				List<Concept> tmp = treeTmp.getConceptsForType(treeTmp.getRoot().getType());
				for(Concept c : tmp)
				{
					int index = conceptsJList.getSelectedIndex();
					PanelArgsColumnProject tmpCon = thisPane.getVecConceptList().get(index);
					if(c.getName().equals(tmpCon.getName()))
					{
						DialogSetSyntoxInput newDia = new DialogSetSyntoxInput(currentFrame, c);
						newDia.setVisible(true);
						break;
					}
				}
				
			}
			
		});
		popup_desktop.add(suppr);
		popup_desktop.add(syntox);
		
		
		this.conceptsJList=new JList(this.thisPane.getVecConceptList());
		this.conceptsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.conceptsJList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
	              if (e.getButton() == 3)
	              {
	            	  conceptsJList.setSelectedIndex(conceptsJList.locationToIndex(e.getPoint()));
	            	  popup_desktop.show(conceptsJList, e.getX(), e.getY());
	              }
	        }
	});
		
		this.conceptsJList.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) 
			{
				// TODO Auto-generated method stub
				if(arg0.getValueIsAdjusting())
			      {
					thisPane.setCurrentArgsPanel(thisPane.getVecConceptList().get(conceptsJList.getSelectedIndex()));
			      }
			}
		});
		this.addConceptButton.setPreferredSize(new Dimension(200,30));
		this.addConceptButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addConceptButton.setVisible(false);
				
				menuPanel.remove(conceptTypeCombo);
				conceptTypeCombo= new JComboBox(thisPane.getVecTypeList());
				conceptTypeCombo.setVisible(true);
				menuPanel.add(conceptTypeCombo);
				thisPane.invalidate();
				thisPane.validate();
				conceptName.setText("");
				menuPanel.setVisible(true);
				validateButton.setVisible(true);
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
				menuPanel.setVisible(false);
				PanelSurTypeColumnProject tmpCC = (PanelSurTypeColumnProject)conceptTypeCombo.getItemAt(conceptTypeCombo.getSelectedIndex());
				System.out.println(conceptTypeCombo.getItemAt(conceptTypeCombo.getSelectedIndex()).toString());
				PanelArgsColumnProject tmp = new PanelArgsColumnProject(currentFrame, thisPane,conceptName.getText());
				tmp.conceptType = tmpCC;
				addConcept(tmp);
				columnMenu.repaint();
			}
			
		});
		
		
		this.menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		JLabel typeLabel = new JLabel("Type: ");
		JLabel conceptLabel = new JLabel("Concept: ");
		
		this.menuPanel.add(conceptLabel);
		this.menuPanel.add(conceptName);
		this.menuPanel.add(typeLabel);
		
		this.conceptTypeCombo= new JComboBox(this.thisPane.getVecTypeList());
		this.conceptTypeCombo.setPreferredSize(new Dimension(menuPanel.getWidth(), 20));
		
		
		this.menuPanel.add(conceptTypeCombo);
		
		this.menuPanel.setVisible(false);
		
		this.columnMenu.add(this.addConceptButton, BorderLayout.SOUTH);
		this.columnMenu.add(this.validateButton, BorderLayout.CENTER);
		this.columnMenu.add(this.menuPanel, BorderLayout.NORTH);
		
		
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
	
	public void addConcept(PanelArgsColumnProject concept)
	{
		this.thisPane.getVecConceptList().add(concept);
		concept.setVisible(false);
		this.thisPane.getConceptColumnPanel().add(concept);
		this.conceptsJList.setModel(new DefaultListModel());
		this.conceptsJList.setListData(this.thisPane.getVecConceptList());
		this.thisPane.repaint();
	}
	
	public void removeConcept(int index)
	{
		this.thisPane.getVecConceptList().remove(index);
		this.thisPane.getConceptColumnPanel().remove(index);
		this.conceptsJList.setModel(new DefaultListModel());
		this.conceptsJList.setListData(this.thisPane.getVecConceptList());
		if(index == 0)
			
		this.thisPane.invalidate();
		this.thisPane.validate();
		this.thisPane.repaint();
	}
}
