package ihm.tools;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelCenteredButton extends JPanel{
	
	public PanelCenteredButton(String buttname, ActionListener listener){
		JButton usrButton = new JButton(buttname);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		Dimension buttSize = new Dimension(200,50);
		usrButton.setPreferredSize(buttSize);
		usrButton.addActionListener(listener);
		this.add(usrButton);
	}
}