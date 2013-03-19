package ihm.user;

import ihm.MainFrame;
import ihm.PanelHome;
import ihm.tools.PanelCenteredButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class PanelExistingScenario extends JPanel{
	
	MainFrame currentFrame;
	PanelHomeUser previous;
	JPanel thisPane;

	public PanelExistingScenario(MainFrame mf, PanelHomeUser prev){
		
		this.currentFrame = mf;
		this.previous = prev;
		this.thisPane = this;
		
		this.setLayout(new BorderLayout());
		
		setSouthPanel();
		
		JPanel centerPanel = new JPanel(new BorderLayout());
		
		centerPanel.add(setEastPanel(),BorderLayout.WEST);
		centerPanel.add(setWestPanel(),BorderLayout.EAST);
		
		this.add(centerPanel, BorderLayout.CENTER);
	}
	
	private void setSouthPanel()
	{
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
		
		JPanel returnPanel = new PanelCenteredButton("Retour", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.setPane(previous);
			}
		});
		
		JPanel nextPanel = new PanelCenteredButton("Valider", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				PanelResult pr = new PanelResult(currentFrame, thisPane, previous);
				currentFrame.setPane(pr);
			}
		});
		
		
		southPanel.add(returnPanel);
		southPanel.add(nextPanel);
		
		southPanel.setPreferredSize(new Dimension(currentFrame.getWidth(), currentFrame.getHeight()/100*13));
		
		this.thisPane.add(southPanel, BorderLayout.SOUTH);
	}
	
	private JPanel setWestPanel()
	{
		JPanel leftPanel = new JPanel(new BorderLayout());
		leftPanel.setPreferredSize(new Dimension((currentFrame.getWidth()/100)*55,currentFrame.getHeight()/100*87));
		leftPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		
		JPanel northSubLeftP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		northSubLeftP.add(new JLabel("Description :"));
		
		JPanel centerSubLeftP = new JPanel(new BorderLayout());
		JTextArea descrTArea = new JTextArea();
		descrTArea.setText("Inter quos Paulus eminebat notarius ortus in Hispania, glabro quidam sub vultu latens, odorandi vias periculorum occultas perquam sagax. is in Brittanniam missus ut militares quosdam perduceret ausos conspirasse Magnentio, cum reniti non possent, iussa licentius supergressus fluminis modo fortunis conplurium sese repentinus infudit et ferebatur per strages multiplices ac ruinas, vinculis membra ingenuorum adfligens et quosdam obterens manicis, crimina scilicet multa consarcinando a veritate longe discreta. unde admissum est facinus impium, quod Constanti tempus nota inusserat sempiterna.");
		descrTArea.setLineWrap(true);
		descrTArea.setEditable(false);
		JScrollPane descrScroll = new JScrollPane(descrTArea);
		descrScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		descrScroll.setSize(centerSubLeftP.getWidth(),centerSubLeftP.getHeight());
		centerSubLeftP.add(descrScroll, BorderLayout.CENTER);
		
		leftPanel.add(northSubLeftP, BorderLayout.NORTH);
		leftPanel.add(centerSubLeftP, BorderLayout.CENTER);
		
		JPanel containsLeftPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		containsLeftPanel.add(leftPanel);
		
		return containsLeftPanel;
	}
	
	private JPanel setEastPanel()
	{
		JPanel rightPanel = new JPanel(new BorderLayout());
		rightPanel.setPreferredSize(new Dimension((currentFrame.getWidth()/100)*45,currentFrame.getHeight()/100*87));
		rightPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		
		JPanel northSubRightP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		northSubRightP.add(new JLabel("Scénario :"));
		
		JPanel centerSubRightP = new JPanel(new BorderLayout());
		// Création de la liste à faire.
		JList scenarioList = new JList(); 
		JScrollPane scrollPane = new JScrollPane(scenarioList);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setSize(centerSubRightP.getWidth(),centerSubRightP.getHeight());
		centerSubRightP.add(scrollPane, BorderLayout.CENTER);
		
		rightPanel.add(northSubRightP, BorderLayout.NORTH);
		rightPanel.add(centerSubRightP, BorderLayout.CENTER);
		
		JPanel containsRightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		containsRightPanel.add(rightPanel);
		
		return containsRightPanel;
	}
}
