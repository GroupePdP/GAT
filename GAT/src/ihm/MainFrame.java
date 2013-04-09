package ihm;

import javax.swing.*;

import core.Core;

import java.awt.*;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	JPanel currentPane = null;
	private Core mainCore;
	
	public MainFrame(Core core){
		PanelHome home = new PanelHome(this);
		this.getContentPane().setLayout(new BorderLayout());
		Dimension frameSize = new Dimension(1280,720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(frameSize);
		this.setResizable(false);
		this.mainCore = core;
		this.setPane(home);
		Dimension loc = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)loc.getWidth()/2-this.getWidth()/2, 
				(int)loc.getHeight()/2-this.getHeight()/2);
		this.setVisible(true);
	}
	
	public void setPane(JPanel newPane){
		if(this.currentPane != null)
			this.currentPane.setVisible(false);
		
		this.currentPane = newPane;
		this.getContentPane().add(newPane, BorderLayout.CENTER);
		newPane.setVisible(true);
		this.pack();
	}

	public Core getCore(){
		return mainCore;
	}
}
