package ihm.tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import linguistic.concepts_gestion.Concept;

public class PanelSubColumnScenario extends JPanel{

	JPanel thisPane;
	
	Concept owner;
	Dimension thisColumnSize;
	JPanel currentPanel;
	
	
	//Vector<PanelSubColumnScenario> colList = new Vector<PanelSubColumnScenario>();
	
	JList conceptList;
	JScrollPane main;
	
	public PanelSubColumnScenario(Dimension columnSize, JPanel curr, Concept owner)
	{
		this.owner = owner;
		this.thisPane = this;
		this.currentPanel=curr;
		this.thisColumnSize= columnSize;
		
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
		
		String[] test = new String[]{"SUB"};
		this.conceptList=new JList(test);
		this.conceptList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.conceptList.setFixedCellWidth((int)columnSize.getWidth());
		DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		this.conceptList.setCellRenderer(centerRenderer);
		
		JScrollPane conceptScroll = new JScrollPane(this.conceptList);
		conceptScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.main = conceptScroll;
		this.add(conceptScroll, BorderLayout.CENTER);
		
		
	}
	
}
