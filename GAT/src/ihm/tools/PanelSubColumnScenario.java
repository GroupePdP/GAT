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
import linguistic.concepts_gestion.ConceptComplex;
import linguistic.types_gestion.Type;
import linguistic.types_gestion.TypeImpl;
import linguistic.types_gestion.TypeTree;

public class PanelSubColumnScenario extends JPanel{

	JPanel thisPane;
	
	Concept owner;
	Dimension thisColumnSize;
	JPanel currentPanel;
	
	
	Vector<Type> colList = new Vector<Type>();
	
	JList conceptList;
	JScrollPane main;
	
	public PanelSubColumnScenario(Dimension columnSize, JPanel curr, Concept toto)
	{
		this.owner = toto;
		
		if(owner instanceof ConceptComplex)
		{
			for(Type t : ((ConceptComplex)owner).getArguments())
			{
				colList.add(t);
			}
		}
		
		
		this.thisPane = this;
		this.currentPanel=curr;
		this.thisColumnSize= columnSize;
		
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
		
		this.conceptList=new JList<Type>(colList);
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
