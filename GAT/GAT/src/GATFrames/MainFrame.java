package GATFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

	JPanel currentPane = null;
	
	public MainFrame()
	{
		PanelHome home = new PanelHome(this);
		this.getContentPane().setLayout(new BorderLayout());
		Dimension FrameSize = new Dimension(1280,720);
		this.setSize(FrameSize);
		this.setPane(home);
		
		
		this.setVisible(true);
	}
	
	public void setPane(JPanel newPane)
	{
		if(this.currentPane != null)
			this.currentPane.setVisible(false);
		this.currentPane = newPane;
		this.getContentPane().add(newPane, BorderLayout.CENTER);
		newPane.setVisible(true);
	}
}
