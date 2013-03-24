package ihm.admin;

import ihm.MainFrame;
import ihm.tools.PanelArgsColumnProject;
import ihm.tools.PanelConceptColumnProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelNewProject extends JPanel{

	PanelNewProject thisPane;
	JPanel previous;
	MainFrame currentFrame;
	
	Vector<PanelArgsColumnProject> vecConceptList = new Vector(/*conceptsList*/);
	
	JPanel conceptColumnPanel;

	JPanel currentArgs = new JPanel();
	
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
	
	private void setColumnsPanel()
	{
		JPanel globalPanel = new JPanel(new BorderLayout());
		globalPanel.setBorder(BorderFactory.createEmptyBorder((currentFrame.getHeight())/30,20,(currentFrame.getHeight())/30,20));
		//JPanel columnsPanel = new JPanel(new BorderLayout());
		JPanel columnsSubPanel = new JPanel();
		this.conceptColumnPanel = columnsSubPanel;
		columnsSubPanel.setLayout(new BoxLayout(columnsSubPanel,BoxLayout.X_AXIS));
		
		columnsSubPanel.add(new PanelConceptColumnProject(currentFrame,this));

		/*
		JScrollPane scrollPane = new JScrollPane(columnsPanel);
		scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener(){

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				
				thisPane.repaint();
				
			}
			
		});
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		*/
		
		
		//columnsPanel.setBackground(Color.red);
		globalPanel.add(columnsSubPanel,BorderLayout.WEST);
		this.thisPane.add(globalPanel, BorderLayout.CENTER);
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
	
	public Vector<PanelArgsColumnProject> getVecConceptList() {
		return vecConceptList;
	}


}

