package ihm.user;

import ihm.MainFrame;
import ihm.tools.PanelCenteredButton;
import ihm.tools.PanelColumnScenario;
import ihm.tools.PanelSubColumnScenario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import linguistic.Scenario;
import linguistic.conceptsGestion.Concept;
import linguistic.conceptsGestion.ConceptComplex;
import linguistic.conceptsGestion.ConceptSimple;
import linguistic.graphConceptsGestion.GraphConcepts;
import linguistic.graphConceptsGestion.GraphNode;
import linguistic.graphConceptsGestion.GraphNodeDefault;
import linguistic.graphConceptsGestion.IncompatibleTypesException;
import linguistic.typesGestion.LinguisticFactory;
import linguistic.typesGestion.Type;

public class PanelNewScenario extends JPanel{

	MainFrame currentFrame;
	PanelNewScenario thisPane=this;
	PanelHomeUser previous;
	//JPanel colcont;
	
	Scenario scenario;
	
	PanelColumnScenario scenarioRaw;

	

	public PanelSubColumnScenario[] tab;
	
	private Dimension columnSize;
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu test1 = new JMenu("Fichier");
	
	private JMenuItem item1 = new JMenuItem("Enregistrer Scenario en cours");
	private JMenuItem item2 = new JMenuItem("Enregistrer");
	private JMenuItem item3 = new JMenuItem("Quitter");
	
	public PanelNewScenario(MainFrame mf,Scenario s, PanelHomeUser prev)
	{
		this.currentFrame = mf;
		this.previous = prev;
		
		this.currentFrame.setTitle(s.getName());
		
		this.scenario = s;
		
		this.setLayout(new BorderLayout());
		
		setMenuBar();
		setDescrPane();
		this.add(new PanelMiller(this.scenario, this.previous, this), BorderLayout.CENTER);
		
	}
	
	public void setScenarioRaw(PanelColumnScenario scenarioRaw) {
		this.scenarioRaw = scenarioRaw;
	}

	private void setMenuBar()
	{
		item1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				thisPane.generateScenario();
				currentFrame.getCore().getProject().ajouterScenario(scenario);
				currentFrame.getCore().backupProject(currentFrame.getCore().getProject().getName());
			}
			
		});
		
		item2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		item3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				currentFrame.setPane(previous);
			}
		});
		test1.add(item1);
		test1.add(item2);
		test1.add(item3);
		
		menuBar.add(test1);
		
		this.thisPane.add(menuBar, BorderLayout.NORTH);
	}

	private void setDescrPane()
	{
		JPanel right = new JPanel(new BorderLayout());
		
		JLabel description = new JLabel("Description :");
		JTextArea descrTArea = new JTextArea();
		descrTArea.setText("Inter quos Paulus eminebat notarius ortus in Hispania, glabro quidam sub vultu latens, odorandi vias periculorum occultas perquam sagax. is in Brittanniam missus ut militares quosdam perduceret ausos conspirasse Magnentio, cum reniti non possent, iussa licentius supergressus fluminis modo fortunis conplurium sese repentinus infudit et ferebatur per strages multiplices ac ruinas, vinculis membra ingenuorum adfligens et quosdam obterens manicis, crimina scilicet multa consarcinando a veritate longe discreta. unde admissum est facinus impium, quod Constanti tempus nota inusserat sempiterna.");
		descrTArea.setLineWrap(true);
		descrTArea.setEditable(false);
		JScrollPane descrScroll = new JScrollPane(descrTArea);
		descrScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		right.setPreferredSize(new Dimension(currentFrame.getWidth()/4,currentFrame.getHeight()));
		right.add(description, BorderLayout.NORTH);
		right.add(descrScroll, BorderLayout.CENTER);
		right.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		this.thisPane.add(right, BorderLayout.EAST);
	}
	
	public void generateScenario()
	{
		ArrayList<PanelSubColumnScenario> tmp = scenarioRaw.getList();
		
		for(PanelSubColumnScenario ps : tmp)
		{
			Concept root = ps.getOwner();
			
			GraphNode nodeRoot = this.currentFrame.getCore().getGraphNodeFactory().makeNode(root);
			
			for(int i = 0 ; i < ps.getList().size(); i++)
			{
				GraphNode child = new GraphNodeDefault(ps.getList().get(i).getOwner());
				try {
					nodeRoot.addChild(child,i);
				} catch (IncompatibleTypesException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ps.getList().get(i).generateGraphConcept(child);
			}
			
			GraphConcepts gc = new GraphConcepts(nodeRoot);
			this.scenario.addGraphConcepts(gc);
		}
		
		
	}

}
