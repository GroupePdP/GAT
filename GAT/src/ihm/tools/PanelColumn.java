package ihm.tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class PanelColumn extends JPanel{

	public PanelColumn(Dimension columnSize)
	{
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
		
		JPanel overNewCol = new JPanel(new BorderLayout());
		
		JPanel newCol = new JPanel();
		newCol.setLayout(new BoxLayout(newCol, BoxLayout.Y_AXIS));
		newCol.setPreferredSize(columnSize);
		
		String[] testList = {"test", "test"};
		
		JList conceptList = new JList(testList);
		conceptList.setFixedCellWidth((int)columnSize.getWidth());
		DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		conceptList.setCellRenderer(centerRenderer);
		
		
		JButton addConceptButton = new JButton("Ajouter Concept");
		addConceptButton.setPreferredSize(new Dimension(200,30));
		
		newCol.add(conceptList);
		
		overNewCol.add(newCol, BorderLayout.CENTER);
		overNewCol.add(addConceptButton, BorderLayout.SOUTH);
		this.add(overNewCol, BorderLayout.WEST);
	}
	
	
}
