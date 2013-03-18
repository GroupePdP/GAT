package src.ihm.user;

import src.ihm.MainFrame;
import src.ihm.PanelHome;
import src.ihm.tools.PanelBasicMenu;
import src.ihm.tools.PanelCenteredButton;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import src.ihm.user.*;

public class PanelHomeUser extends JPanel {
	
	MainFrame currentFrame;
	PanelHome previous;
	PanelHomeUser thisPane;
	
	
	public PanelHomeUser(MainFrame mf, PanelHome prev)
	{
		this.setLayout(new BorderLayout());
		this.thisPane = this; // bizarre, cette ligne de code...
		this.previous = prev;
		this.currentFrame = mf;
		
		JPanel scExisPanel = new PanelCenteredButton("Scenarios Existants", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				PanelExistingScenario pes = new PanelExistingScenario(currentFrame, thisPane);
				currentFrame.setPane(pes);
			}
		});
		
		JPanel scPersPanel = new PanelCenteredButton("Scenario Personnalise", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				DialogInitNewScenario dins = new DialogInitNewScenario(currentFrame, thisPane);
				dins.setVisible(true);
			}
		});	
		
		JPanel backPanel = new PanelCenteredButton("Retour", new ActionListener(){ 
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.setPane(previous);
			}
		});	
		
		PanelBasicMenu menu = new PanelBasicMenu(new JPanel[]{scExisPanel, scPersPanel, backPanel});
		
		this.add(menu, BorderLayout.CENTER);
	}
}
