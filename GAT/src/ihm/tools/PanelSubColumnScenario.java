package ihm.tools;

import ihm.user.PanelMiller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import linguistic.conceptsGestion.Concept;
import linguistic.conceptsGestion.ConceptComplex;
import linguistic.conceptsGestion.ConceptSimple;
import linguistic.graphConceptsGestion.GraphNode;
import linguistic.graphConceptsGestion.GraphNodeDefault;
import linguistic.graphConceptsGestion.IncompatibleTypesException;
import linguistic.typesGestion.LinguisticFactory;
import linguistic.typesGestion.Type;
import linguistic.typesGestion.TypeImpl;
import linguistic.typesGestion.TypeTree;

public class PanelSubColumnScenario extends JPanel{

	PanelSubColumnScenario thisPane;
	
	Concept owner;
	Dimension thisColumnSize;
	PanelMiller currentPanel;
	
	ArrayList<PanelSubColumnScenario> list = new ArrayList<PanelSubColumnScenario>();

	JPanel colList = new JPanel();
	
	JList conceptList;
	JScrollPane main;
	
	public PanelSubColumnScenario(Dimension columnSize, PanelMiller curr, Concept toto, LinguisticFactory lf)
	{
		colList.setLayout(new BoxLayout(colList, BoxLayout.Y_AXIS));
		colList.setPreferredSize(new Dimension((int)columnSize.getWidth(), (int)columnSize.getHeight()));
		this.owner = toto;
		this.thisPane = this;
		this.currentPanel=curr;
		this.thisColumnSize= columnSize;
		
		
		if(owner instanceof ConceptComplex)
		{
			for(Type t : ((ConceptComplex)owner).getArguments())
			{
				Vector tmpVec = new Vector(lf.getTypeManager().getTypeTree().getConceptsForType(t));
				
				JPanel tmpPane = new JPanel(new BorderLayout());
				tmpPane.setMaximumSize(new Dimension((int)columnSize.getWidth(),30));
				
				final JComboBox tmp = new JComboBox(tmpVec);
				tmp.setMaximumSize(new Dimension((int)columnSize.getWidth(),30));
				
				JButton tmpArrow = new JButton(">");
				
				final PanelSubColumnScenario newCol = new PanelSubColumnScenario(thisColumnSize, currentPanel,(Concept)tmp.getSelectedItem(),lf);
				newCol.setVisible(false);
				list.add(newCol);
				tmpArrow.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						if(tmp.getSelectedItem() instanceof ConceptComplex)
						{
							currentPanel.addColumn(newCol);
							thisPane.setVisibleAll(false);
							thisPane.setVisible(true);
							newCol.setVisible(true);
						}
					}
					
				});
				tmpArrow.setMaximumSize(new Dimension(20,20));
				
				tmpPane.add(tmp, BorderLayout.CENTER);
				
				if(tmp.getSelectedItem() instanceof ConceptComplex)
					tmpPane.add(tmpArrow, BorderLayout.EAST);
				
				colList.add(tmpPane);
			}
		}
		
		
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
		

		JScrollPane conceptScroll = new JScrollPane(this.colList);
		//conceptScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.main = conceptScroll;
		
		this.add(conceptScroll, BorderLayout.CENTER);
		
		
	}
	
	public void setVisibleAll(Boolean bool)
	{
		this.setVisible(bool);
		
		for(PanelSubColumnScenario ps : this.list)
		{
			ps.setVisibleAll(bool);
		}
	}

	public Concept getOwner() {
		return owner;
	}

	public ArrayList<PanelSubColumnScenario> getList() {
		return list;
	}

	public GraphNode generateGraphConcept(GraphNode thisNode)
	{
		
		
		for(int i = 0 ; i < this.getList().size(); i++)
		{
			GraphNode child = new GraphNodeDefault(this.getList().get(i).getOwner());
			try {
				thisNode.addChild(child,i);
			} catch (IncompatibleTypesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.getList().get(i).generateGraphConcept(child);
		}
		
		return thisNode;
	}
}
