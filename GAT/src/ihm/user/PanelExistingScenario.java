package ihm.user;

import ihm.MainFrame;
import ihm.PanelHome;
import ihm.tools.CenteredButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelExistingScenario extends JPanel{
	
	MainFrame currentFrame;
	PanelHomeUser previous;

	public PanelExistingScenario(MainFrame mf, PanelHomeUser prev){
		
		this.currentFrame = mf;
		this.previous = prev;
		
		this.setLayout(new BorderLayout());
		
		JPanel SouthPanel = new JPanel();
		SouthPanel.setLayout(new BoxLayout(SouthPanel, BoxLayout.X_AXIS));
		
		JPanel ReturnButt = new CenteredButton("Retour", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.setPane(previous);
			}
		});
		
		JPanel NextButt = new CenteredButton("Valider", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.setPane(previous);
			}
		});
		ReturnButt.setBackground(Color.blue);
		NextButt.setBackground(Color.red);
		SouthPanel.add(ReturnButt);
		SouthPanel.add(NextButt);
		
		
		
		SouthPanel.setPreferredSize(new Dimension(currentFrame.getWidth(), currentFrame.getHeight()/100*13));
		
		this.add(SouthPanel, BorderLayout.SOUTH);
		
		
		JPanel CenterPanel = new JPanel();
		CenterPanel.setBackground(Color.yellow);
		
		this.add(CenterPanel, BorderLayout.CENTER);
	}
	
}
