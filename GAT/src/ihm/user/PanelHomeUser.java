package ihm.user;

import ihm.MainFrame;
import ihm.PanelHome;
import ihm.tools.PanelCenteredButton;

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
		Dimension panelSize = new Dimension(200, 200);
		content.setPreferredSize(panelSize);
		content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
		
		JPanel scExisPanel = new PanelCenteredButton("Scenarios Existants", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				PanelExistingScenario pes = new PanelExistingScenario(currentFrame, thisPane);
				currentFrame.setPane(pes);
			}
		});
		
		content.add(scExisPanel);
		
		JPanel scPersPanel = new PanelCenteredButton("Scenario Personnalise", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				DialogInitNewScenario dins = new DialogInitNewScenario(currentFrame);
				dins.setVisible(true);
			}
		});	
		
		content.add(scPersPanel);
		
		JPanel backPanel = new PanelCenteredButton("Retour", new ActionListener(){ 
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.setPane(previous);
			}
		});	
		
		content.add(backPanel);
		global.add(content,gbc);
		this.add(global, BorderLayout.CENTER);
	}
}
