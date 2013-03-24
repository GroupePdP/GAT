package ihm.user;

import ihm.MainFrame;
import ihm.PanelHome;
import ihm.tools.PanelBasicMenu;
import ihm.tools.PanelCenteredButton;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import core.Project;

import ihm.user.*;

public class PanelHomeUser extends JPanel {
	
	MainFrame currentFrame;
	PanelHome previous;
	PanelHomeUser thisPane;
	Project currentProject;
	
	
	public PanelHomeUser(MainFrame mf, PanelHome prev, Project p)
	{
		this.setLayout(new BorderLayout());
		this.thisPane = this; // bizarre, cette ligne de code...
		this.previous = prev;
		this.currentFrame = mf;
		this.currentProject = p;
		
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
