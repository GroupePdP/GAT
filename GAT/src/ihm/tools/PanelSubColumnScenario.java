package ihm.tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import linguistic.concepts_gestion.Concept;
import linguistic.concepts_gestion.ConceptComplex;
import linguistic.types_gestion.LinguisticFactory;
import linguistic.types_gestion.Type;
import linguistic.types_gestion.TypeImpl;
import linguistic.types_gestion.TypeTree;

public class PanelSubColumnScenario extends JPanel{

	JPanel thisPane;
	
	Concept owner;
	Dimension thisColumnSize;
	JPanel currentPanel;
	

	JPanel colList = new JPanel();
	
	JList conceptList;
	JScrollPane main;
	
	public PanelSubColumnScenario(Dimension columnSize, JPanel curr, Concept toto, LinguisticFactory lf)
	{
		colList.setLayout(new BoxLayout(colList, BoxLayout.Y_AXIS));
		colList.setMaximumSize(new Dimension((int)columnSize.getWidth(), curr.getHeight()));
		this.owner = toto;
		
		if(owner instanceof ConceptComplex)
		{
			for(Type t : ((ConceptComplex)owner).getArguments())
			{
				//Vector tmpVec = new Vector(lf.getTypeManager().getTypeTree().getConceptsForType(t));
				Vector tmpVec=new Vector();
				tmpVec.add("lol");
				
				
			/*	for(Concept c : lf.getTypeManager().getTypeTree().getConceptsForType(t))
				{
					tmpVec.add("lol");
				}
			*/	
				JComboBox tmp = new JComboBox(tmpVec);
				tmp.setPreferredSize(new Dimension((int)columnSize.getWidth(),20));
				
				colList.add(tmp);
			}
		}
		
		
		this.thisPane = this;
		this.currentPanel=curr;
		this.thisColumnSize= columnSize;
		
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
		

		JScrollPane conceptScroll = new JScrollPane(this.colList);
		//conceptScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.main = conceptScroll;
		
		this.add(conceptScroll, BorderLayout.NORTH);
		
		
	}
	
}
