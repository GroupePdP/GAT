package ihm.tools;

import ihm.user.PanelMiller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import linguistic.conceptsGestion.Concept;
import linguistic.conceptsGestion.ConceptComplex;
import linguistic.graphConceptsGestion.GraphNode;
import linguistic.graphConceptsGestion.GraphNodeDefault;
import linguistic.typesGestion.IncompatibleTypesException;
import linguistic.typesGestion.LinguisticFactory;
import linguistic.typesGestion.Type;

public class PanelSubColumnScenario extends JPanel{

	private static final long serialVersionUID = 1L;
	PanelSubColumnScenario thisPane;
	Concept owner;
	Dimension thisColumnSize;
	PanelMiller currentPanel;

	ArrayList<PanelSubColumnScenario> list = 
			new ArrayList<PanelSubColumnScenario>();

	JPanel colList = new JPanel();
	JList conceptList;
	JScrollPane main;

	public PanelSubColumnScenario(Dimension columnSize, 
			PanelMiller curr, Concept owner, LinguisticFactory lf, 
			ArrayList<PanelSubColumnScenario> list){
		
		colList.setLayout(new BoxLayout(colList, BoxLayout.Y_AXIS));
		colList.setPreferredSize(new Dimension((int)columnSize.getWidth(), 
				(int)columnSize.getHeight()));
		this.owner = owner;
		this.thisPane = this;
		this.currentPanel = curr;
		this.thisColumnSize = columnSize;

		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));


		JScrollPane conceptScroll = new JScrollPane(this.colList);
		this.main = conceptScroll;

		this.add(conceptScroll, BorderLayout.CENTER);
	}

	public PanelSubColumnScenario(Dimension columnSize, PanelMiller curr, 
			Concept toto, LinguisticFactory lf){
		
		colList.setLayout(new BoxLayout(colList, BoxLayout.Y_AXIS));
		colList.setPreferredSize(new Dimension((int)columnSize.getWidth(), 
				(int)columnSize.getHeight()));
		this.owner = toto;
		this.thisPane = this;
		this.currentPanel=curr;
		this.thisColumnSize= columnSize;

		if(owner instanceof ConceptComplex)
		{
			for(Type t : ((ConceptComplex)owner).getArguments())
			{
				Vector tmpVec = new Vector(lf.getTypeManager().getTypeTree().
						getConceptsForType(t));

				JPanel tmpPane = new JPanel(new BorderLayout());
				tmpPane.setMaximumSize(
						new Dimension((int)columnSize.getWidth(),30));

				final JComboBox tmp = new JComboBox(tmpVec);
				tmp.setMaximumSize(new Dimension((int)columnSize.getWidth(),30));

				JButton tmpArrow = new JButton(">");

				final PanelSubColumnScenario newCol = 
						new PanelSubColumnScenario(thisColumnSize, 
								currentPanel,(Concept)tmp.getSelectedItem(),lf);
				newCol.setVisible(false);
				list.add(newCol);
				tmpArrow.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e){
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
		this.setBorder(BorderFactory.createMatteBorder(
				0, 0, 0, 1, Color.black));

		JScrollPane conceptScroll = new JScrollPane(this.colList);
		this.main = conceptScroll;

		this.add(conceptScroll, BorderLayout.CENTER);
	}

	public void addChildren(GraphNode father, LinguisticFactory lf){

		if (!father.getChildrenList().isEmpty()){
			for (GraphNode child : father.getChildrenList())
			{		
				PanelSubColumnScenario newCol = new PanelSubColumnScenario(
						thisColumnSize, this.currentPanel,
						father.getConcept(), lf, null);
				newCol.addChildren(child, lf);
				newCol.setVisible(false);
				currentPanel.addColumn(newCol);
				this.list.add(newCol);
			}
		}
	}

	public void setVisibleAll(Boolean bool){
		this.setVisible(bool);
		for(PanelSubColumnScenario ps : this.list)
			ps.setVisibleAll(bool);
	}

	public Concept getOwner(){
		return owner;
	}

	public ArrayList<PanelSubColumnScenario> getList(){
		return list;
	}

	public void addPane(PanelSubColumnScenario pan){
		this.list.add(pan);
	}

	public GraphNode generateGraphConcept(GraphNode thisNode){
		
		for(int i = 0 ; i < this.getList().size(); i++)
		{
			GraphNode child = new GraphNodeDefault(
					this.getList().get(i).getOwner());
			try {
				thisNode.addChild(child,i);
			} catch (IncompatibleTypesException e){
				e.printStackTrace();
			}
			this.getList().get(i).generateGraphConcept(child);
		}
		return thisNode;
	}
}
