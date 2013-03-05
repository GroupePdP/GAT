package ihm.user;

import ihm.MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelNewScenario extends JPanel{

	MainFrame currentFrame;
	JPanel thisPane=this;
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu test1 = new JMenu("Fichier");
	
	private JMenuItem item1 = new JMenuItem("Enregistrer Scénario en cours");
	private JMenuItem item2 = new JMenuItem("Enregistrer");
	private JMenuItem item3 = new JMenuItem("Quitter");
	
	public PanelNewScenario(MainFrame mf)
	{
		this.currentFrame = mf;
		
		this.setLayout(new BorderLayout());
		test1.add(item1);
		test1.add(item2);
		test1.add(item3);
		
		menuBar.add(test1);
		
		this.add(menuBar, BorderLayout.NORTH);
		
		
		JPanel left = new JPanel(new BorderLayout());
		JPanel millerGlobal = new JPanel(new BorderLayout());
		millerGlobal.setBackground(Color.RED);
		
		millerGlobal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		//millerGlobal.setPreferredSize(new Dimension(currentFrame.getWidth()/4*3-60, currentFrame.getHeight()-60));
		
		left.add(millerGlobal,BorderLayout.CENTER);
		Border borderP = BorderFactory.createEmptyBorder(20,20,20,20);
		left.setBorder(borderP);
		
		
		JPanel right = new JPanel(new BorderLayout());
		right.setBackground(Color.ORANGE);
		right.setPreferredSize(new Dimension(currentFrame.getWidth()/4,currentFrame.getHeight()));
		
		left.setBackground(Color.GREEN);
		this.add(right, BorderLayout.EAST);
		this.add(left, BorderLayout.CENTER);
		
	}
}
