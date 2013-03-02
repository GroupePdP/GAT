package ihm;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame{

	JPanel currentPane = null;
	
	public MainFrame()
	{
		PanelHome home = new PanelHome(this);
		this.getContentPane().setLayout(new BorderLayout());
		Dimension FrameSize = new Dimension(1280,720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(FrameSize);
		this.setResizable(false);
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
