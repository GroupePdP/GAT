package ihm.user;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class DialogInitNewScenario extends JDialog{

	public DialogInitNewScenario()
	{
		this.setTitle("Création d'un nouveau scénario");
		
		JPanel globalPane = new JPanel();
		globalPane.setLayout(new BoxLayout(globalPane, BoxLayout.Y_AXIS));
	}
	
}
