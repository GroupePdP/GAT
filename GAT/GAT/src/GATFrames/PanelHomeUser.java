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

public class PanelHomeUser extends JPanel {
	
	MainFrame currentFrame;
	PanelHome previous;
	
	
	public PanelHomeUser(MainFrame mf, PanelHome previous)
	{
		this.setLayout(new BorderLayout());
		
		this.previous = previous;
		this.currentFrame = mf;
		
		JPanel global = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gbc.gridy = 1;
		
		JPanel content = new JPanel();
		Dimension PaneSize = new Dimension(200, 200);
		content.setPreferredSize(PaneSize);
		content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
		
		Dimension ButtSize = new Dimension(200,50);
		
		JButton SEButton = new JButton("Scénarios Existants");
		JPanel SEButtPain = new JPanel(new FlowLayout(FlowLayout.CENTER));
		SEButton.setPreferredSize(ButtSize);
		SEButtPain.add(SEButton);
		content.add(SEButtPain);
		
		JButton SPButton = new JButton("Scénario Personnalisé");
		JPanel SPButtPain = new JPanel(new FlowLayout(FlowLayout.CENTER));
		SPButton.setPreferredSize(ButtSize);
		SPButtPain.add(SPButton);
		content.add(SPButtPain);
		
		JButton BackButton = new JButton("Retour");
		JPanel BackButtPain = new JPanel(new FlowLayout(FlowLayout.CENTER));
		BackButton.setPreferredSize(ButtSize);
		BackButton.addActionListener(new BoutonListener());
		BackButtPain.add(BackButton);
		content.add(BackButtPain);
		
		global.add(content,gbc);
		
		this.add(global, BorderLayout.CENTER);
		
		
		
		
	}
	
	class BoutonListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent arg0) 
		{
			currentFrame.setPane(previous);
		}
	}
}
