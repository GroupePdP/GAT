package ihm;

import ihm.tools.CenteredButton;
import ihm.user.PanelHomeUser;

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
		
		JPanel global = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gbc.gridy = 1; 
		
		JPanel content = new JPanel();
		Dimension panelSize = new Dimension(200, 200);
		content.setPreferredSize(panelSize);
		content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
		
		JPanel usrPanel = new CenteredButton("Utilisateur", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				PanelHomeUser phu = new PanelHomeUser(currentFrame, thisPane);
				currentFrame.setPane(phu);
				
			}
		});
		JPanel adminPanel = new CenteredButton("Administrateur", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				;
			}
		});
		
		
		content.add(usrPanel);
		content.add(adminPanel);
		
		
		
		global.add(content,gbc);
		
		this.thisPane = this;
		this.add(global, BorderLayout.CENTER);
	}
	
}	
