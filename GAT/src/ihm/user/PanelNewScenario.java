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
import linguistic.concepts_gestion.ConceptComplex;
import linguistic.concepts_gestion.ConceptSimple;
import linguistic.types_gestion.LinguisticFactory;
import linguistic.types_gestion.Type;

public class PanelNewScenario extends JPanel{

	MainFrame currentFrame;
	JPanel thisPane=this;
	JPanel previous;
	JPanel colcont;
	
	Scenario scenario;
	
	public PanelSubColumnScenario[] tab;
	
	private Dimension columnSize;
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu test1 = new JMenu("Fichier");
	
	private JMenuItem item1 = new JMenuItem("Enregistrer Scénario en cours");
	private JMenuItem item2 = new JMenuItem("Enregistrer");
	private JMenuItem item3 = new JMenuItem("Quitter");
	
	public PanelNewScenario(MainFrame mf,Scenario s, JPanel prev)
	{
		this.currentFrame = mf;
		this.previous = prev;
		
		this.currentFrame.setTitle(s.getName());
		
		this.scenario = s;
		
		this.setLayout(new BorderLayout());
		
		LinguisticFactory lf = LinguisticFactory.getInstance();
		Type t1 = lf.getTypeManager().makeType("personne");
		Type t2 = lf.getTypeManager().makeType("joueur", t1);
		Type t3 = lf.getTypeManager().makeType("gain_de_match");
		Type t4 = lf.getTypeManager().makeType("match");
		
		ConceptSimple c1 = new ConceptSimple("table1","line3","Joueur1",t2);
		ConceptSimple c2 = new ConceptSimple("table2", "line5","Match 2",t4);
		List<Type> l = new ArrayList<Type>();
		l.add(t2); l.add(t4);
		ConceptComplex c3 = new ConceptComplex("gagner",t3,l); // concept (gagner(joueur, match))
		
		lf.getTypeManager().getTypeTree().addConcept(c1);
		lf.getTypeManager().getTypeTree().addConcept(c2);
		lf.getTypeManager().getTypeTree().addConcept(c3);
		
		
		
		setMenuBar();
		setDescrPane();
		this.add(new PanelMiller(this.scenario/*, lf*/), BorderLayout.CENTER);
		
	}
	
	private void setMenuBar()
	{
		item1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
	


}
