package GATFrames;

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
		Dimension PaneSize = new Dimension(200, 200);
		content.setPreferredSize(PaneSize);
		content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
		
		Dimension ButtSize = new Dimension(200,50);
		
		JButton UsrButton = new JButton("Utilisateur");
		JPanel UsrButtPain = new JPanel(new FlowLayout(FlowLayout.CENTER));
		UsrButton.setPreferredSize(ButtSize);
		UsrButton.addActionListener(new UsrBoutonListener());
		UsrButtPain.add(UsrButton);
		
		JButton AdminButton = new JButton("Administrateur");
		JPanel AdminButtPain = new JPanel(new FlowLayout(FlowLayout.CENTER));
		AdminButton.setPreferredSize(ButtSize);
		AdminButtPain.add(AdminButton);
		
		content.add(UsrButtPain);
		content.add(AdminButtPain);
		
		
		
		global.add(content,gbc);
		
		this.thisPane = this;
		this.add(global, BorderLayout.CENTER);
	}
	
	class UsrBoutonListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent arg0) 
		{
			PanelHomeUser phu = new PanelHomeUser(currentFrame, thisPane);
			currentFrame.setPane(phu);
			
		}
	}
	
}	
