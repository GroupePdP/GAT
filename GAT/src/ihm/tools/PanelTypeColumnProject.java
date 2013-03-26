package ihm.tools;

import ihm.MainFrame;
import ihm.admin.PanelNewProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

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

public class PanelTypeColumnProject extends JPanel{
	MainFrame currentFrame;
	PanelNewProject thisPane;
	
	//ArrayList<PanelArgsColumnProject> conceptsList = new ArrayList<PanelArgsColumnProject>();
	Vector<PanelSurTypeColumnProject> vecTypeList;
	
	JList typesJList;
	
	JButton validateButton = new JButton("Valider");
	JButton addTypeButton = new JButton("Ajouter Type");
	JTextField typeName = new JTextField(16);
	JScrollPane scrollMain;
	JPanel columnMenu = new JPanel(new BorderLayout());
	
	public PanelTypeColumnProject(MainFrame mf, PanelNewProject pane)
	{
		this.setLayout(new BorderLayout());
		//this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
		this.currentFrame = mf;
		this.thisPane = pane;
		this.vecTypeList = this.thisPane.getVecTypeList();
		
		this.setBackground(Color.ORANGE);
		Dimension columnSize = new Dimension(350,this.thisPane.getHeight());
		this.setPreferredSize(columnSize);
		
		this.typesJList=new JList(vecTypeList);
		this.typesJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.typesJList.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) 
			{
				// TODO Auto-generated method stub
				if(arg0.getValueIsAdjusting())
			      {
					thisPane.setCurrentSurTypePanel(vecTypeList.get(typesJList.getSelectedIndex()));
			      }
			}
		});
		this.addTypeButton.setPreferredSize(new Dimension(200,30));
		this.addTypeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addTypeButton.setVisible(false);
				validateButton.setVisible(true);
				typeName.setText("");
				typeName.setVisible(true);
				columnMenu.repaint();
			}
			
		});
		this.validateButton.setVisible(false);
		this.validateButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addTypeButton.setVisible(true);
				validateButton.setVisible(false);
				typeName.setVisible(false);
				PanelSurTypeColumnProject tmp = new PanelSurTypeColumnProject(currentFrame, thisPane,typeName.getText());
				addType(tmp);
				columnMenu.repaint();
			}
			
		});
		this.typeName.setVisible(false);
		
		this.columnMenu.add(this.addTypeButton, BorderLayout.SOUTH);
		this.columnMenu.add(this.validateButton, BorderLayout.CENTER);
		this.columnMenu.add(this.typeName, BorderLayout.NORTH);
		
		
		//conceptsJList.setFixedCellWidth((int)columnSize.getWidth());
		DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		typesJList.setCellRenderer(centerRenderer);
		JScrollPane typeScroll = new JScrollPane(typesJList);
		typeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.scrollMain=typeScroll;
		
		JPanel overCol = new JPanel(new BorderLayout());
		this.add(this.scrollMain, BorderLayout.CENTER);
		this.add(this.columnMenu, BorderLayout.SOUTH);
	}
	
	private void addType(PanelSurTypeColumnProject type)
	{
		this.thisPane.addType(type);
		type.setVisible(false);
		this.thisPane.getTypeColumnPanel().add(type);
		this.typesJList.setModel(new DefaultListModel());
		this.typesJList.setListData(this.thisPane.getVecTypeList());
		this.thisPane.invalidate();
		this.thisPane.validate();
		this.thisPane.repaint();
	}
}
