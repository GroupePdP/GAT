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
import ihm.tools.CenteredButton;

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
		
		JPanel SouthPane = new JPanel();
		SouthPane.setLayout(new BoxLayout(SouthPane, BoxLayout.X_AXIS));
		
		CenteredButton Return = new CenteredButton("Retour", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.setPane(previous);
			}
		});
		SouthPane.add(Return);
		
		
		
		CenteredButton Menu = new CenteredButton("Menu", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.setPane(menuUser);
			}
		});
		SouthPane.add(Menu);
		
		CenteredButton Save = new CenteredButton("Sauvegarder", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				;
			}
		});
		SouthPane.add(Save);
		
		JPanel CenterPanel = new JPanel();
		CenterPanel.setLayout(new BoxLayout(CenterPanel, BoxLayout.Y_AXIS));
		
		JPanel DAD = new JPanel();
		DAD.setLayout(new BorderLayout());
		
		JPanel tmp1 = new JPanel();
		tmp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel GeneratedText = new JLabel("Texte généré :");
		tmp1.add(GeneratedText);
		
		JPanel tmp2 = new JPanel();
		tmp2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JTextArea TextArea = new JTextArea();
		TextArea.setText("Inter quos Paulus eminebat notarius ortus in Hispania, glabro quidam sub vultu latens, odorandi vias periculorum occultas perquam sagax. is in Brittanniam missus ut militares quosdam perduceret ausos conspirasse Magnentio, cum reniti non possent, iussa licentius supergressus fluminis modo fortunis conplurium sese repentinus infudit et ferebatur per strages multiplices ac ruinas, vinculis membra ingenuorum adfligens et quosdam obterens manicis, crimina scilicet multa consarcinando a veritate longe discreta. unde admissum est facinus impium, quod Constanti tempus nota inusserat sempiterna.");
		TextArea.setLineWrap(true);
		TextArea.setEditable(false);
		JScrollPane DescrScroll = new JScrollPane(TextArea);
		DescrScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		DescrScroll.setPreferredSize(new Dimension(currentFrame.getWidth()/100*80,500));
		tmp2.add(DescrScroll);
		
		DAD.add(tmp1, BorderLayout.NORTH);
		DAD.add(tmp2, BorderLayout.CENTER);
		JPanel BIGDADDY = new JPanel(new FlowLayout(FlowLayout.CENTER));
		BIGDADDY.add(DAD);
		Border cpd = BorderFactory.createEmptyBorder(30,0,0,0);
		BIGDADDY.setBorder(cpd);
		CenterPanel.add(BIGDADDY);
		
		
		SouthPane.setPreferredSize(new Dimension(currentFrame.getWidth(), currentFrame.getHeight()/100*13));
		this.add(CenterPanel, BorderLayout.CENTER);
		this.add(SouthPane, BorderLayout.SOUTH);
	}
}
