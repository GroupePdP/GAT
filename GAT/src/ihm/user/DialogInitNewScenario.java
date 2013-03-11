package ihm.user;

import ihm.MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import linguistic.Scenario;

public class DialogInitNewScenario extends JDialog{

	JDialog thisDiag = this;
	MainFrame currentFrame;
	
	JTextField newScenarioTextArea = new JTextField(16);
	
	public DialogInitNewScenario(MainFrame mf)
	{
		this.currentFrame = mf;
		this.setTitle("Cr�ation d'un nouveau sc�nario");
		this.setSize(new Dimension(250,150));
		this.setResizable(false);
		this.setModal(true);
		this.setLocationRelativeTo(mf);
		this.setLocation(mf.getWidth()/2-125, mf.getHeight()/2-75);
		JPanel overGlobal = new JPanel(new BorderLayout());
		
		
		JPanel centerPane = new JPanel(new BorderLayout());
		
		JPanel centSub = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JPanel subGlobalPane = new JPanel();
		subGlobalPane.setLayout(new BoxLayout(subGlobalPane, BoxLayout.Y_AXIS));
		
		JPanel newScenarioLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel newScenarioLabel = new JLabel("Nom du nouveau sc�nario :");
		newScenarioLabelPanel.add(newScenarioLabel);
		
		JPanel newScenarioTextAreaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.newScenarioTextArea.setBorder(BorderFactory.createLoweredBevelBorder());
		newScenarioTextAreaPanel.add(this.newScenarioTextArea);
		
		subGlobalPane.add(newScenarioLabelPanel);
		subGlobalPane.add(newScenarioTextAreaPanel);
		centSub.add(subGlobalPane);
		
		JPanel buttons = new JPanel();
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());
		
		JPanel coucoulol = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension buttSize = new Dimension(100,20);
		
		JPanel retPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton ret = new JButton("Retour");
		ret.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				thisDiag.dispose();
			}
			
		});
		ret.setPreferredSize(buttSize);
		retPanel.add(ret);
		JPanel okPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton ok = new JButton("Valider");
		ok.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				String scenarioName = newScenarioTextArea.getText();
				
				Scenario s = new Scenario(scenarioName);
				PanelNewScenario pns = new PanelNewScenario(currentFrame,s);
				currentFrame.setPane(pns);
				thisDiag.dispose();
			}
			
		});
		ok.setPreferredSize(buttSize);
		retPanel.add(ok);
		
		coucoulol.add(retPanel);
		coucoulol.add(okPanel);
		southPanel.add(coucoulol);
		centerPane.add(centSub, BorderLayout.CENTER);
		
		overGlobal.add(southPanel, BorderLayout.SOUTH);
		overGlobal.add(centerPane,BorderLayout.CENTER);
		this.add(overGlobal);
	}
	
}
