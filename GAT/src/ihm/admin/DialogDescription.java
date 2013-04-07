package ihm.admin;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DialogDescription extends JDialog{

	JButton validate = new JButton("Valider");
	JTextArea descrArea;
	
	public DialogDescription(final PanelInitProject pip, final TypeGraphic tg)
	{
		initComponent();
		initValidateTypeGraphic(pip,tg);
	}
	
	public DialogDescription(final PanelInitProject pip, final ConceptGraphic cg)
	{
		initComponent();
		initValidateConceptGraphic(pip,cg);
	}
	
	private void initComponent()
	{
		JPanel main = new JPanel(new BorderLayout());
		main.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		JLabel descrLabel = new JLabel("Description: ");
		this.descrArea = new JTextArea();

		this.descrArea.setLineWrap(true);
		this.descrArea.setEditable(true);
		JScrollPane descrScroll = new JScrollPane(this.descrArea);
		descrScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		descrScroll.setPreferredSize(new Dimension(main.getWidth(), 60));
		
		JPanel valRetPane = new JPanel();
		valRetPane.setLayout(new BoxLayout(valRetPane, BoxLayout.X_AXIS));

		JPanel valPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		valPane.add(validate);
		JPanel retPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton ret = new JButton("Annuler");
		ret.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		retPane.add(ret);
		
		valRetPane.add(retPane);
		valRetPane.add(valPane);
		
		main.add(descrLabel, BorderLayout.NORTH);
		main.add(descrScroll, BorderLayout.CENTER);
		main.add(valRetPane, BorderLayout.SOUTH);
		
		this.add(main);
		this.pack();
	}
	
	public void initValidateTypeGraphic(final PanelInitProject pip, final TypeGraphic tg)
	{
		this.validate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tg.setDescription(descrArea.getText());
				pip.setCurrentDescription(tg.description);
				dispose();
			}
		});
	}
	
	public void initValidateConceptGraphic(final PanelInitProject pip, final ConceptGraphic cg)
	{
		this.validate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cg.setDescription(descrArea.getText());
				pip.setCurrentDescription(cg.description);
				dispose();
			}
		});
	}
}
