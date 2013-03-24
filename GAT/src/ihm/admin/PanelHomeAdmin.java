package ihm.admin;

import ihm.MainFrame;
import ihm.PanelHome;
import ihm.tools.PanelBasicMenu;
import ihm.tools.PanelCenteredButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PanelHomeAdmin extends JPanel{

	MainFrame currentFrame;
	PanelHome previous;
	PanelHomeAdmin thisPane;
	
	
	public PanelHomeAdmin(MainFrame mf, PanelHome prev)
	{
		this.setLayout(new BorderLayout());
		this.thisPane = this;
		this.previous = prev;
		this.currentFrame = mf;
		
		JPanel createProjectPanel = new PanelCenteredButton("Cr�er Projet", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				DialogInitNewProject dinp = new DialogInitNewProject(currentFrame, thisPane);
				dinp.setVisible(true);
			}
		});
		
		JPanel modifyProjectPanel = new PanelCenteredButton("Modifier Projet", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				DialogChoseProject dinp = new DialogChoseProject(currentFrame, thisPane);
				dinp.setVisible(true);
			}
		});	
		
		JPanel backPanel = new PanelCenteredButton("Retour", new ActionListener(){ 
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.setPane(previous);
			}
		});	
		
		JPanel optPanel = new PanelCenteredButton("Options", new ActionListener(){ 
			public void actionPerformed(ActionEvent arg0) 
			{
				//currentFrame.setPane(previous);
			}
		});	
		
		PanelBasicMenu menu = new PanelBasicMenu(new JPanel[]{createProjectPanel, modifyProjectPanel, optPanel, backPanel});
		
		this.add(menu, BorderLayout.CENTER);
	}
}
