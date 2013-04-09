package ihm;

import ihm.admin.PanelHomeAdmin;
import ihm.tools.PanelBasicMenu;
import ihm.tools.PanelCenteredButton;
import ihm.user.DialogChoseProject;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PanelHome extends JPanel{

	private static final long serialVersionUID = 1L;
	MainFrame currentFrame;
	PanelHome thisPane;
	
	public PanelHome(MainFrame mf){
		
		this.setLayout(new BorderLayout());
		this.currentFrame = mf;
		
		JPanel usrPanel = new PanelCenteredButton("Utilisateur", 
				new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				DialogChoseProject tmp = new DialogChoseProject(
						currentFrame, thisPane);
				tmp.setVisible(true);
			}
		});
		
		JPanel adminPanel = new PanelCenteredButton("Administrateur", 
				new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				PanelHomeAdmin pha = new PanelHomeAdmin(currentFrame, thisPane);
				currentFrame.setPane(pha);
			}
		});
		
		PanelBasicMenu menu = new PanelBasicMenu(
				new JPanel[]{usrPanel, adminPanel});
		
		this.thisPane = this;
		this.add(menu, BorderLayout.CENTER);
	}
}	
