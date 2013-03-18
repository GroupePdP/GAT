package src.ihm;

import src.ihm.admin.PanelHomeAdmin;
import src.ihm.tools.PanelBasicMenu;
import src.ihm.tools.PanelCenteredButton;
import src.ihm.user.PanelHomeUser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelHome extends JPanel {
	
	MainFrame currentFrame;
	PanelHome thisPane;
	
	public PanelHome(MainFrame mf)
	{
		this.setLayout(new BorderLayout());
		this.currentFrame = mf;
		
		JPanel usrPanel = new PanelCenteredButton("Utilisateur", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				PanelHomeUser phu = new PanelHomeUser(currentFrame, thisPane);
				currentFrame.setPane(phu);
				
			}
		});
		JPanel adminPanel = new PanelCenteredButton("Administrateur", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				PanelHomeAdmin pha = new PanelHomeAdmin(currentFrame, thisPane);
				currentFrame.setPane(pha);
			}
		});
		
		
		PanelBasicMenu menu = new PanelBasicMenu(new JPanel[]{usrPanel, adminPanel});
		
		this.thisPane = this;
		this.add(menu, BorderLayout.CENTER);
	}
	
}	
