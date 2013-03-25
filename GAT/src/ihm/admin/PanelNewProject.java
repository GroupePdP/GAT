package ihm.admin;

import ihm.MainFrame;
import ihm.tools.PanelArgsColumnProject;
import ihm.tools.PanelConceptColumnProject;
import ihm.tools.PanelSurTypeColumnProject;
import ihm.tools.PanelTypeColumnProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import linguistic.conceptsGestion.Concept;

public class PanelNewProject extends JPanel{

	PanelNewProject thisPane;
	JPanel previous;
	MainFrame currentFrame;
	
	Vector<PanelArgsColumnProject> vecConceptList = new Vector(/*conceptsList*/);
	Vector<PanelSurTypeColumnProject> vecTypeList = new Vector(/*conceptsList*/);
	
	JPanel conceptColumnPanel;
	JPanel typeColumnPanel;

	JPanel currentArgs = new JPanel();
	JPanel currentSurType = new JPanel();
	
	public PanelNewProject(MainFrame mf, JPanel prev)
	{
		this.thisPane = this;
		this.previous = prev;
		this.currentFrame = mf;
		this.setLayout(new BorderLayout());
		setMenuBar();
		setDescrPanel();
		setColumnsPanel();
	}
	
	private void setMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu test1 = new JMenu("Fichier");
		
		JMenuItem item1 = new JMenuItem("Enregistrer Projet en cours");
		JMenuItem item2 = new JMenuItem("Enregistrer");
		JMenuItem item3 = new JMenuItem("Quitter");
		
		item1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				for (PanelSurTypeColumnProject type : vecTypeList)
					currentFrame.getCore().getProject().getLinguisticFactory().makeType(type.toString());
				for (PanelArgsColumnProject concept : vecConceptList)
					currentFrame.getCore().getProject().getLinguisticFactory().makeConcept(concept.conceptName, currentFrame.getCore().getProject().getLinguisticFactory().makeType("blergu"), concept.typeList);
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
	
	private void setColumnsPanel()
	{
		JTabbedPane test = new JTabbedPane();
		test.setMaximumSize(new Dimension(700, this.thisPane.getHeight()));
		test.setBorder(BorderFactory.createEmptyBorder((currentFrame.getHeight())/30,20,(currentFrame.getHeight())/30,20));
		
		
		JPanel conceptPanel = new JPanel(new BorderLayout());
		
		JPanel columnsSubPanel = new JPanel();
		columnsSubPanel.setLayout(new BoxLayout(columnsSubPanel,BoxLayout.X_AXIS));
		columnsSubPanel.add(new PanelConceptColumnProject(currentFrame,this));
		this.conceptColumnPanel = columnsSubPanel;
		
		conceptPanel.add(this.conceptColumnPanel,BorderLayout.WEST);
		
		JPanel typePanel = new JPanel(new BorderLayout());
		
		JPanel typeSubPanel = new JPanel();
		typeSubPanel.setLayout(new BoxLayout(typeSubPanel,BoxLayout.X_AXIS));
		typeSubPanel.add(new PanelTypeColumnProject(currentFrame,this));
		this.typeColumnPanel = typeSubPanel;
		
		typePanel.add(this.typeColumnPanel,BorderLayout.WEST);
		
		
		
		
		
		test.addTab("Concepts",conceptPanel);
		test.setMnemonicAt(0, KeyEvent.VK_1);
		
		test.addTab("Types",typePanel);
		test.setMnemonicAt(1, KeyEvent.VK_2);

		this.thisPane.add(test, BorderLayout.WEST);
	}
	
	private void setDescrPanel()
	{
		JPanel right = new JPanel(new BorderLayout());
		
		JLabel description = new JLabel("Description :");
		JTextArea descrTArea = new JTextArea();
		descrTArea.setText("Inter quos Paulus eminebat notarius ortus in Hispania, glabro quidam sub vultu latens, odorandi vias periculorum occultas perquam sagax. is in Brittanniam missus ut militares quosdam perduceret ausos conspirasse Magnentio, cum reniti non possent, iussa licentius supergressus fluminis modo fortunis conplurium sese repentinus infudit et ferebatur per strages multiplices ac ruinas, vinculis membra ingenuorum adfligens et quosdam obterens manicis, crimina scilicet multa consarcinando a veritate longe discreta. unde admissum est facinus impium, quod Constanti tempus nota inusserat sempiterna.");
		descrTArea.setLineWrap(true);
		descrTArea.setEditable(false);
		JScrollPane descrScroll = new JScrollPane(descrTArea);
		descrScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		right.setPreferredSize(new Dimension(currentFrame.getWidth()/4,currentFrame.getHeight()/15*13));
		right.add(description, BorderLayout.NORTH);
		right.add(descrScroll, BorderLayout.CENTER);
		right.setBorder(BorderFactory.createEmptyBorder((currentFrame.getHeight())/15,20,(currentFrame.getHeight())/15,20));
		
		this.thisPane.add(right, BorderLayout.EAST);
	}
	
	public void setCurrentArgsPanel(PanelArgsColumnProject pacp){
		this.currentArgs.setVisible(false);
		this.currentArgs = pacp;
		this.currentArgs.setVisible(true);
	}	
	
	public JPanel getConceptColumnPanel() {
		return conceptColumnPanel;
	}
	
	public JPanel getTypeColumnPanel() {
		return typeColumnPanel;
	}
	
	public Vector<PanelArgsColumnProject> getVecConceptList() {
		return vecConceptList;
	}

	public Vector<PanelSurTypeColumnProject> getVecTypeList() {
		return vecTypeList;
	}

	public void setCurrentSurTypePanel(PanelSurTypeColumnProject pacp){
		this.currentSurType.setVisible(false);
		this.currentSurType = pacp;
		this.currentSurType.setVisible(true);
	}
}

