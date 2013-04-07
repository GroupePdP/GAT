package ihm.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TypeGraphic extends JPanel{

	PanelInitProject currentPane;
	
	String name;
	TypeGraphic surType = null;
	String description = "";
	
	
	
	JTextField surTypeTextField = new JTextField();
	
	JPanel menu;
	JButton addSurType = new JButton("Ajouter Sur-type");
	JButton modSurType = new JButton("Modifier Sur-type");
	
	JPanel comboPane;
	JComboBox typeCombo= new JComboBox();
	
	JButton suppr = new JButton("Supprimer");
	
	JPanel valRetPane;
	JButton validate = new JButton("Valider");
	JButton ret = new JButton("Annuler");
	
	
	
	public TypeGraphic(PanelInitProject pip, String name)
	{
		this.setLayout(new BorderLayout());
		this.currentPane = pip;
		this.name = name;
		initMenu();
	}

	public TypeGraphic(PanelInitProject pip, String name, TypeGraphic surType)
	{
		this.currentPane = pip;
		this.name = name;
		this.surType = surType;
		initMenu();
		this.surTypeTextField.setText(surType.toString());
	}

	private void initMenu()
	{
		this.setLayout(new BorderLayout());
		
		
		this.addSurType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetComboBox();
				comboPane.setVisible(true);

				
				addSurType.setVisible(false);
				valRetPane.setVisible(true);
			}
		});
		this.addSurType.setVisible(false);
		
		this.modSurType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetComboBox();
				comboPane.setVisible(true);
				
				suppr.setVisible(true);
				modSurType.setVisible(false);
				valRetPane.setVisible(true);
			}
		});
		this.modSurType.setVisible(false);
		
		this.suppr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				surType = null;
				surTypeTextField.setText("");
				selectMenuToShow();
			}
		});
		this.suppr.setVisible(false);
		
		this.validate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				surType = (TypeGraphic) typeCombo.getSelectedItem();
				surTypeTextField.setText(surType.toString());
				selectMenuToShow();
			}
		});

		this.ret.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectMenuToShow();
			}
		});
		
		
		JPanel validatePane = new JPanel(new BorderLayout());
		validatePane.add(this.validate, BorderLayout.CENTER);
		
		JPanel retPane = new JPanel(new BorderLayout());
		retPane.add(this.ret, BorderLayout.CENTER);
		
		this.valRetPane = new JPanel();
		this.valRetPane.setLayout(new BoxLayout(this.valRetPane, BoxLayout.X_AXIS));
		this.valRetPane.add(retPane);
		this.valRetPane.add(validatePane);
		this.valRetPane.setVisible(false);


		JPanel addSurTypePane = new JPanel(new BorderLayout());
		addSurTypePane.add(this.addSurType, BorderLayout.CENTER);

		JPanel modSurTypePane = new JPanel(new BorderLayout());
		modSurTypePane.add(this.modSurType, BorderLayout.CENTER);

		JPanel supprPane = new JPanel(new BorderLayout());
		supprPane.add(this.suppr, BorderLayout.CENTER);

		this.comboPane = new JPanel(new BorderLayout());
		this.comboPane.add(this.typeCombo, BorderLayout.CENTER);
		this.typeCombo.setVisible(false);
		
		JPanel surTypePane = new JPanel(new BorderLayout());

		this.surTypeTextField.setHorizontalAlignment(JTextField.CENTER);
		this.surTypeTextField.setEditable(false);
		surTypePane.add(surTypeTextField, BorderLayout.CENTER);
		
		this.menu = new JPanel();
		this.menu.setLayout(new BoxLayout(this.menu, BoxLayout.Y_AXIS));
		
		this.menu.add(this.comboPane);
		this.menu.add(supprPane);
		this.menu.add(this.valRetPane);
		this.menu.add(addSurTypePane);
		this.menu.add(modSurTypePane);
		this.selectMenuToShow();
		this.add(surTypePane, BorderLayout.NORTH);
		this.add(this.menu, BorderLayout.SOUTH);
		selectMenuToShow();
	}

	
	public void selectMenuToShow()
	{
		this.valRetPane.setVisible(false);
		this.suppr.setVisible(false);
		this.comboPane.setVisible(false);
		
		if(this.surType!= null)
		{
			this.addSurType.setVisible(false);
			this.modSurType.setVisible(true);
		}
		
		else
		{
			this.addSurType.setVisible(true);
			this.modSurType.setVisible(false);
		}
		
		this.currentPane.invalidate();
		this.currentPane.validate();
		this.currentPane.repaint();
	}
	
	private void resetComboBox()
	{
		Vector<TypeGraphic> tmp = new Vector();
		for (TypeGraphic tg : currentPane.getTypesCol().getTypes())
		{
			if (! tg.toString().equals(this.name))
			{
				if(this.getSurType() != null)
				{
					if(! tg.toString().equals(this.getSurType().toString()))
							tmp.add(tg);
				}
					else
						tmp.add(tg);
			}
		}
		comboPane.remove(typeCombo);
		typeCombo= new JComboBox(tmp);
		typeCombo.setSelectedItem(null);
		comboPane.add(typeCombo);
		comboPane.invalidate();
		comboPane.validate();
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	public TypeGraphic getSurType() {
		return surType;
	}
	
	public void setDescription(String descr)
	{
		this.description = descr;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
