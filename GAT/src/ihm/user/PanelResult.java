package ihm.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import ihm.MainFrame;
import ihm.tools.PanelCenteredButton;

public class PanelResult extends JPanel{

	MainFrame currentFrame;
	JPanel previous;
	JPanel menuUser;
	
	public PanelResult(MainFrame mf, JPanel prev, JPanel menu)
	{
		this.currentFrame = mf ;
		this.previous = prev;
		this.menuUser = menu;
		
		this.setLayout(new BorderLayout());
		
		JPanel southPane = new JPanel();
		southPane.setLayout(new BoxLayout(southPane, BoxLayout.X_AXIS));
		
		PanelCenteredButton returnPanel = new PanelCenteredButton("Retour", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.setPane(previous);
			}
		});
		southPane.add(returnPanel);
		
		PanelCenteredButton menuPanel = new PanelCenteredButton("Menu", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.setPane(menuUser);
			}
		});
		southPane.add(menuPanel);
		
		PanelCenteredButton savePanel = new PanelCenteredButton("Sauvegarder", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				;
			}
		});
		southPane.add(savePanel);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		JPanel subCenterPanel = new JPanel();
		subCenterPanel.setLayout(new BorderLayout());
		
		JPanel northSubCenterP = new JPanel();
		northSubCenterP.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel generatedLabel = new JLabel("Texte genere :");
		northSubCenterP.add(generatedLabel);
		
		JPanel centerSubCenterP = new JPanel();
		centerSubCenterP.setLayout(new FlowLayout(FlowLayout.LEFT));
		JTextArea generatedTArea = new JTextArea();
		generatedTArea.setText("Inter quos Paulus eminebat notarius ortus in Hispania, glabro quidam sub vultu latens, odorandi vias periculorum occultas perquam sagax. is in Brittanniam missus ut militares quosdam perduceret ausos conspirasse Magnentio, cum reniti non possent, iussa licentius supergressus fluminis modo fortunis conplurium sese repentinus infudit et ferebatur per strages multiplices ac ruinas, vinculis membra ingenuorum adfligens et quosdam obterens manicis, crimina scilicet multa consarcinando a veritate longe discreta. unde admissum est facinus impium, quod Constanti tempus nota inusserat sempiterna.");
		generatedTArea.setLineWrap(true);
		generatedTArea.setEditable(false);
		JScrollPane descrScroll = new JScrollPane(generatedTArea);
		descrScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		descrScroll.setPreferredSize(new Dimension(currentFrame.getWidth()/100*80,500));
		centerSubCenterP.add(descrScroll);
		
		subCenterPanel.add(northSubCenterP, BorderLayout.NORTH);
		subCenterPanel.add(centerSubCenterP, BorderLayout.CENTER);
		JPanel containsCenterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
		containsCenterPanel.add(subCenterPanel);
		Border borderP = BorderFactory.createEmptyBorder(30,0,0,0);
		containsCenterPanel.setBorder(borderP);
		centerPanel.add(containsCenterPanel);
		
		
		southPane.setPreferredSize(new Dimension(currentFrame.getWidth(), currentFrame.getHeight()/100*13));
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(southPane, BorderLayout.SOUTH);
	}
}
