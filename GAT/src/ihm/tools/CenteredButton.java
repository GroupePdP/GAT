package ihm.tools;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CenteredButton extends JPanel{
	
	public CenteredButton(String buttname, ActionListener listener){
		JButton usrButton = new JButton(buttname);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		Dimension buttSize = new Dimension(200,50);
		UsrButton.setPreferredSize(buttSize);
		UsrButton.addActionListener(listener);
		this.add(usrButton);
	}
}
