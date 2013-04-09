package ihm.admin;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogRename extends JDialog{

	private static final long serialVersionUID = 1L;

	JTextField nameTextField = new JTextField(16);

	JButton validate = new JButton("Valider");

	public DialogRename(final PanelInitProject pip, final TypeGraphic tg){
		initComponent();
		this.nameTextField.setText(tg.toString());
		initValidateTypeGraphic(pip,tg);
	}

	public DialogRename(final PanelInitProject pip, final ConceptGraphic cg){
		initComponent();
		this.nameTextField.setText(cg.toString());
		initValidateConceptGraphic(pip,cg);
	}

	private void initComponent(){
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		JLabel descrLabel = new JLabel("Entrez un nouveau nom: ");

		JPanel valRetPane = new JPanel();
		valRetPane.setLayout(new BoxLayout(valRetPane, BoxLayout.X_AXIS));

		JPanel valPane = new JPanel(new FlowLayout(FlowLayout.CENTER));

		valPane.add(validate);
		JPanel retPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton ret = new JButton("Annuler");
		ret.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});

		retPane.add(ret);

		valRetPane.add(retPane);
		valRetPane.add(valPane);

		main.add(descrLabel);
		main.add(this.nameTextField);
		main.add(valRetPane);

		this.add(main);
		this.pack();
	}

	public void initValidateTypeGraphic(
			final PanelInitProject pip, final TypeGraphic tg){
		this.validate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(nameTextField.getText().length() != 0)
				{
					tg.setName(nameTextField.getText());
					pip.getTypesCol().renameTypeGraphic(
							nameTextField.getText(), tg);
					dispose();
				}
			}
		});
	}

	public void initValidateConceptGraphic(
			final PanelInitProject pip, final ConceptGraphic cg){
		this.validate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cg.setName(nameTextField.getText());
				pip.getConceptsCol().renameConceptGraphic(
						nameTextField.getText(), cg);
				dispose();
				dispose();
			}
		});
	}
}
