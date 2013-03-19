package ihm.tools;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelBasicMenu extends JPanel{

	public PanelBasicMenu (JPanel[] buttons)
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gbc.gridy = 1;
		
		
		JPanel content = new JPanel();
		Dimension panelSize = new Dimension(200, 200);
		content.setPreferredSize(panelSize);
		
		content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
		
		for(int i = 0; i<buttons.length ; i++)
		{
			content.add(buttons[i]);
		}
		
		this.add(content);
	}
	
}
