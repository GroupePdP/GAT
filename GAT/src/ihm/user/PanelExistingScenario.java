/* Attention aux noms de variables ! doivent commencer par une minuscule et etre explicites
 * 
 */

package ihm.user;

import ihm.MainFrame;
import ihm.PanelHome;
import ihm.tools.CenteredButton;

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
		
		JPanel SouthPanel = new JPanel();
		SouthPanel.setLayout(new BoxLayout(SouthPanel, BoxLayout.X_AXIS));
		
		JPanel ReturnButt = new CenteredButton("Retour", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.setPane(previous);
			}
		});
		
		JPanel NextButt = new CenteredButton("Valider", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				PanelResult pr = new PanelResult(currentFrame, thisPane, previous);
				currentFrame.setPane(pr);
			}
		});
		
		
		SouthPanel.add(ReturnButt);
		SouthPanel.add(NextButt);
		
		SouthPanel.setPreferredSize(new Dimension(currentFrame.getWidth(), currentFrame.getHeight()/100*13));
		
		this.add(SouthPanel, BorderLayout.SOUTH);
		
		JPanel CenterPanel = new JPanel(); // attention, centerPanel et pas CenterPanel
		CenterPanel.setLayout(new BoxLayout(CenterPanel, BoxLayout.X_AXIS));
		
		JPanel RightPanel = new JPanel(); // attention, rightPanel et pas RightPanel
		RightPanel.setLayout(new BorderLayout());
		RightPanel.setPreferredSize(new Dimension((currentFrame.getWidth()/100)*45,currentFrame.getHeight()/100*87));
		
		JPanel tmp1 = new JPanel();
		tmp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel scenario = new JLabel("Sc�nario :");
		tmp1.add(scenario);
		
		JPanel tmp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JList ScenarioList = new JList(); // Et attention a la creation
		JScrollPane ScrollPane = new JScrollPane(ScenarioList);
		ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		ScrollPane.setPreferredSize(new Dimension(400,500));
		tmp2.add(ScrollPane);
		
		RightPanel.add(tmp1, BorderLayout.NORTH);
		RightPanel.add(tmp2, BorderLayout.CENTER);
		
		JPanel BIGRightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // attention a la casse des noms de variables
		BIGRightPanel.add(RightPanel);
		
		JPanel LeftPanel = new JPanel();
		LeftPanel.setLayout(new BorderLayout());
		LeftPanel.setPreferredSize(new Dimension((currentFrame.getWidth()/100)*55,currentFrame.getHeight()/100*87));
		
		JPanel tmp3 = new JPanel();
		tmp3.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel description = new JLabel("Description :");
		tmp3.add(description);
		
		JPanel tmp4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextArea DescrField = new JTextArea();
		DescrField.setText("Inter quos Paulus eminebat notarius ortus in Hispania, glabro quidam sub vultu latens, odorandi vias periculorum occultas perquam sagax. is in Brittanniam missus ut militares quosdam perduceret ausos conspirasse Magnentio, cum reniti non possent, iussa licentius supergressus fluminis modo fortunis conplurium sese repentinus infudit et ferebatur per strages multiplices ac ruinas, vinculis membra ingenuorum adfligens et quosdam obterens manicis, crimina scilicet multa consarcinando a veritate longe discreta. unde admissum est facinus impium, quod Constanti tempus nota inusserat sempiterna.");
		DescrField.setLineWrap(true);
		DescrField.setEditable(false);
		JScrollPane DescrScroll = new JScrollPane(DescrField);
		DescrScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		DescrScroll.setPreferredSize(new Dimension(500,500));
		tmp4.add(DescrScroll);
		
		LeftPanel.add(tmp3, BorderLayout.NORTH);
		LeftPanel.add(tmp4, BorderLayout.CENTER);
		
		JPanel BIGLeftPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // mm remarque qu'au dessus
		BIGLeftPanel.add(LeftPanel);
		
		Border cpd = BorderFactory.createEmptyBorder(30,120,0,0); // pk cpd ?
		BIGRightPanel.setBorder(cpd);
		BIGLeftPanel.setBorder(cpd);
		
		CenterPanel.add(BIGRightPanel);
		CenterPanel.add(BIGLeftPanel);
		
		this.add(CenterPanel, BorderLayout.CENTER);
	}
	
}
