package ihm.user;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class DialogInitNewScenario extends JDialog{

	public DialogInitNewScenario()
	{
		this.setTitle("Cr�ation d'un nouveau sc�nario");
		
		JPanel globalPane = new JPanel();
		globalPane.setLayout(new BoxLayout(globalPane, BoxLayout.Y_AXIS));
	}
	
}
