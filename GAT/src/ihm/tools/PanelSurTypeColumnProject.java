package ihm.tools;

import ihm.MainFrame;
import ihm.admin.PanelNewProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import linguistic.typesGestion.Type;

public class PanelSurTypeColumnProject extends JPanel{
	MainFrame currentFrame;
	PanelNewProject thisPane;
	
	String typeName;
	PanelSurTypeColumnProject type;
	//Vector<PanelSurTypeColumnProject> vecSurTypeList = new Vector(/*conceptsList*/);
	
	JPanel columnMenu = new JPanel(new BorderLayout());
	
	JComboBox combo = new JComboBox();
	
	JButton addTypeButton = new JButton("Ajouter Sur-type");
	
	JButton validateButton = new JButton("Valider");
	JButton retButton = new JButton("Annuler");
	JPanel valRet = new JPanel(new FlowLayout());
	
//	JList surTypeJList;
	JTextField surType = new JTextField(8);
//	JScrollPane scrollMain;
	
	
	
	public PanelSurTypeColumnProject(MainFrame mf, PanelNewProject currentPane, String name)
	{
		this.currentFrame = mf;
		this.thisPane = currentPane;
		this.typeName = name;
		
		Dimension columnSize = new Dimension(350,this.thisPane.getTypeColumnPanel().getHeight());
		this.setPreferredSize(columnSize);
		this.setLayout(new BorderLayout());
		
		
		this.combo = new JComboBox(this.thisPane.getVecTypeList());
		//this.combo.setSelectedItem(null);
		this.combo.setVisible(false);
		
		this.addTypeButton.setPreferredSize(new Dimension(200,30));
		this.addTypeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				thisPane.remove(combo);
				combo = new JComboBox(thisPane.getVecTypeList());
				columnMenu.add(combo, BorderLayout.NORTH);
				thisPane.invalidate();
				thisPane.validate();
				addTypeButton.setVisible(false);
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
				addTypeButton.setVisible(true);
				valRet.setVisible(false);
				PanelSurTypeColumnProject c = (PanelSurTypeColumnProject) combo.getItemAt(combo.getSelectedIndex());
				combo.setVisible(false);
				surType.setText(c.toString());
				type=c;
				thisPane.invalidate();
				thisPane.validate();
				
				
				columnMenu.repaint();
			}
			
		});
		
		this.retButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				thisPane.remove(combo);
				addTypeButton.setVisible(true);
				valRet.setVisible(false);
				combo.setVisible(false);
				columnMenu.repaint();
			}
			
		});
		
		this.valRet.add(retButton);
		this.valRet.add(validateButton);
		this.valRet.setVisible(false);
		
		this.columnMenu.add(this.addTypeButton, BorderLayout.SOUTH);
		this.columnMenu.add(this.valRet, BorderLayout.CENTER);
		this.columnMenu.add(this.combo, BorderLayout.NORTH);
		
/*		this.surTypeJList=new JList(this.vecSurTypeList);
		this.surTypeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		this.surTypeJList.setCellRenderer(centerRenderer);
		JScrollPane surTypeScroll = new JScrollPane(surTypeJList);
		surTypeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.scrollMain=surTypeScroll;*/
		
		this.surType.setEditable(false);
		this.setBackground(Color.WHITE);
		
		this.add(this.surType, BorderLayout.NORTH);
		this.add(this.columnMenu, BorderLayout.SOUTH);
	}
	
/*	
	public void addSurType(PanelSurTypeColumnProject pane)
	{
		this.vecSurTypeList.add(pane);
		this.surTypeJList.setModel(new DefaultListModel());
		this.surTypeJList.setListData(this.vecSurTypeList);
		
		this.surType.setText(t)
		this.thisPane.repaint();
		
	}
*/	
	
	
	
	public String toString() {
		return this.typeName;
	}

	public PanelSurTypeColumnProject getType() {
		return type;
	}

	public void setType(PanelSurTypeColumnProject type) {
		this.type = type;
		surType.setText(type.toString());
		this.thisPane.invalidate();
		this.thisPane.validate();
	}
	
	
}
