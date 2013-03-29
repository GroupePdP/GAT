package ihm.tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import ihm.MainFrame;
import ihm.admin.PanelNewProject;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import linguistic.typesGestion.Type;

public class PanelArgsColumnProject extends JPanel{

	MainFrame currentFrame;
	PanelNewProject thisPane;
	
	public String conceptName;
	public List<Type> typeList;
	
	public PanelSurTypeColumnProject conceptType;
	
	Vector<PanelSurTypeColumnProject> vecArgsList = new Vector();
	
	JPanel columnMenu = new JPanel(new BorderLayout());
	JComboBox combo;
	JButton addConceptButton = new JButton("Ajouter Argument");
	JButton validateButton = new JButton("Valider");
	JButton retButton = new JButton("Annuler");
	
	JPanel valRet = new JPanel(new FlowLayout());
	
	JList argsJList;
	JScrollPane scrollMain;
	
	
	
	public PanelArgsColumnProject(MainFrame mf, PanelNewProject currentPane, String name)
	{
		this.currentFrame = mf;
		this.thisPane = currentPane;
		this.conceptName = name;
		
		Dimension columnSize = new Dimension(350,this.thisPane.getConceptColumnPanel().getHeight());
		this.setPreferredSize(columnSize);
		this.setLayout(new BorderLayout());
		
		//final DefaultComboBoxModel model = new DefaultComboBoxModel(this.thisPane.getVecConceptList());
		
		this.combo = new JComboBox(thisPane.getVecTypeList());
		this.combo.setSelectedItem(null);
		this.combo.setVisible(false);
		
		this.addConceptButton.setPreferredSize(new Dimension(200,30));
		this.addConceptButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				combo = new JComboBox(thisPane.getVecTypeList());
				combo.setSelectedItem(null);
				columnMenu.add(combo, BorderLayout.NORTH);
				thisPane.invalidate();
				thisPane.validate();
				addConceptButton.setVisible(false);
				valRet.setVisible(true);
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
				valRet.setVisible(false);
				combo.setVisible(false);
				PanelSurTypeColumnProject c = (PanelSurTypeColumnProject)combo.getSelectedItem();
				addConcept(c);
				
				
				columnMenu.repaint();
			}
			
		});
		
		this.retButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				thisPane.remove(combo);
				addConceptButton.setVisible(true);
				valRet.setVisible(false);
				combo.setVisible(false);
				columnMenu.repaint();
			}
			
		});
		
		this.valRet.add(retButton);
		this.valRet.add(validateButton);
		this.valRet.setVisible(false);
		
		this.columnMenu.add(this.addConceptButton, BorderLayout.SOUTH);
		this.columnMenu.add(this.valRet, BorderLayout.CENTER);
		this.columnMenu.add(this.combo, BorderLayout.NORTH);
		
		this.argsJList=new JList(this.vecArgsList);
		this.argsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		this.argsJList.setCellRenderer(centerRenderer);
		JScrollPane conceptScroll = new JScrollPane(argsJList);
		conceptScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.scrollMain=conceptScroll;
		
		this.add(this.scrollMain, BorderLayout.CENTER);
		this.add(this.columnMenu, BorderLayout.SOUTH);
	}
	
	public void addConcept(PanelSurTypeColumnProject pane)
	{
		this.vecArgsList.add(pane);
		this.argsJList.setModel(new DefaultListModel());
		this.argsJList.setListData(this.vecArgsList);
		this.thisPane.repaint();
	}
	
	
	public String getName()
	{
		return this.conceptName;
	}
	
	public String toString() {
		return this.conceptName+"("+this.conceptType.toString()+")";
	}

	public Vector<PanelSurTypeColumnProject> getVecArgsList() {
		return vecArgsList;
	}
}
