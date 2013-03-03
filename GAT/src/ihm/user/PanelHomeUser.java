package ihm.user;

import ihm.MainFrame;
import ihm.PanelHome;
import ihm.tools.CenteredButton;

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
		
		JPanel global = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gbc.gridy = 1;
		
		JPanel content = new JPanel();
		Dimension PaneSize = new Dimension(200, 200);
		content.setPreferredSize(PaneSize);
		content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
		
		JPanel SEButtPain = new CenteredButton("Scenarios Existants", new ActionListener(){ // pk "pain" ?
			public void actionPerformed(ActionEvent arg0) 
			{
				PanelExistingScenario pes = new PanelExistingScenario(currentFrame, thisPane);
				currentFrame.setPane(pes);
			}
		});
		
		content.add(SEButtPain);
		
		JPanel SPButtPain = new CenteredButton("Scenario Personnalise", new ActionListener(){ // mm question
			public void actionPerformed(ActionEvent arg0) 
			{
				;
			}
		});	
		
		content.add(SPButtPain);
		
		JPanel BackButtPain = new CenteredButton("Retour", new ActionListener(){ // mm question
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.setPane(previous);
			}
		});	
		
		content.add(BackButtPain);
		global.add(content,gbc);
		this.add(global, BorderLayout.CENTER);
	}
}
