package ihm.user;

import ihm.MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import linguistic.Scenario;

public class DialogInitNewScenario extends JDialog{

	private static final long serialVersionUID = 1L;
	JDialog thisDiag = this;
	MainFrame currentFrame;
	
	JTextField newScenarioTextArea = new JTextField(16);
	
	JLabel error = new JLabel("Nom de scenario incorrect");
	
	public DialogInitNewScenario(MainFrame mf, final PanelHomeUser prev){
		
		this.currentFrame = mf;
		this.setTitle("Creation d'un nouveau scenario");
		this.setSize(new Dimension(250,150));
		this.setResizable(false);
		this.setModal(true);
		this.setLocationRelativeTo(mf);
		Point loc = this.currentFrame.getLocationOnScreen();
		this.setLocation(loc.x+mf.getWidth()/2-125, loc.y+mf.getHeight()/2-75);
		JPanel overGlobal = new JPanel(new BorderLayout());
		
		
		JPanel centerPane = new JPanel(new BorderLayout());
		
		JPanel centSub = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JPanel subGlobalPane = new JPanel();
		subGlobalPane.setLayout(new BoxLayout(subGlobalPane, BoxLayout.Y_AXIS));
		
		JPanel newScenarioLabelPanel = new JPanel(
				new FlowLayout(FlowLayout.LEFT));
		JLabel newScenarioLabel = new JLabel("Nom du nouveau scenario :");
		newScenarioLabelPanel.add(newScenarioLabel);
		
		JPanel newScenarioTextAreaPanel = new JPanel(
				new FlowLayout(FlowLayout.LEFT));
		this.newScenarioTextArea.getDocument().
		addDocumentListener(new DocumentListener(){
			
			@Override
			public void changedUpdate(DocumentEvent arg0){
				error.setVisible(false);
			}

			@Override
			public void insertUpdate(DocumentEvent e){
				error.setVisible(false);
			}

			@Override
			public void removeUpdate(DocumentEvent e){
				error.setVisible(false);
			}
		});
		
		this.newScenarioTextArea.setBorder(
				BorderFactory.createLoweredBevelBorder());
		newScenarioTextAreaPanel.add(this.newScenarioTextArea);
		
		this.error.setForeground(Color.RED);
		this.error.setVisible(false);
		JPanel errorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		errorPanel.add(this.error);
		
		subGlobalPane.add(newScenarioLabelPanel);
		subGlobalPane.add(newScenarioTextAreaPanel);
		subGlobalPane.add(errorPanel);
		centSub.add(subGlobalPane);
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());
		
		JPanel coucoulol = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension buttSize = new Dimension(100,20);
		
		JPanel retPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton ret = new JButton("Retour");
		ret.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0){
				thisDiag.dispose();
			}
			
		});
		ret.setPreferredSize(buttSize);
		retPanel.add(ret);
		JPanel okPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton ok = new JButton("Valider");
		ok.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				
				String scenarioName = newScenarioTextArea.getText();
				
				if(scenarioName.length() != 0)
				{
					Scenario s = new Scenario(scenarioName);
					PanelNewScenario pns = new PanelNewScenario(
							currentFrame,s,prev);
					currentFrame.setPane(pns);
					thisDiag.dispose();
				}
				
				else
				{
					error.setVisible(true);
					thisDiag.invalidate();
				}
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
