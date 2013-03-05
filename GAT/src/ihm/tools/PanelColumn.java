package ihm.tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;

public class PanelColumn extends JPanel{

	public PanelColumn(Dimension columnSize)
	{
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
		
		JPanel newCol = new JPanel();
		newCol.setLayout(new BoxLayout(newCol, BoxLayout.Y_AXIS));
		newCol.setPreferredSize(columnSize);
		
		JList conceptList = new JList();
		
		String[] testList = {"test", "test"};
		
		this.add(newCol, BorderLayout.WEST);
	}
	
	
}
