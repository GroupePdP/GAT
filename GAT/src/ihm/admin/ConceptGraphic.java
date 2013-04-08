package ihm.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import linguistic.conceptsGestion.Concept;
import linguistic.typesGestion.Type;

public class ConceptGraphic extends JPanel{

	Concept concept;
	PanelInitProject currentPane;
	String name;
	TypeGraphic type;
	Vector<TypeGraphic> arguments = new Vector();
	String description;
	JList argsJList;
	JPanel menu;
	JButton addArgument = new JButton("Ajouter argument");
	JPanel valRetPane;
	JButton validate = new JButton("Valider");
	JButton ret = new JButton("Annuler");
	JPanel comboPane= new JPanel();
	JComboBox typesCombo = new JComboBox();

	public ConceptGraphic(PanelInitProject pip, String name, TypeGraphic type){
		this.currentPane = pip;
		this.type =  type;
		this.name = name;
		initMainColumn();
	}

	private void initMainColumn(){
		JPanel main = new JPanel(new BorderLayout());

		// Initialisation de la JList
		this.argsJList = new JList(this.arguments);
		DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		this.argsJList.setCellRenderer(centerRenderer);
		JScrollPane scrollJList = new JScrollPane(this.argsJList);
		scrollJList.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		this.argsJList.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if (e.getButton() == 3)
				{
					argsJList.setSelectedIndex(
							argsJList.locationToIndex(e.getPoint()));
					JPopupMenu popup = initPopup();
					popup.show(argsJList, e.getX(), e.getY());
				}
			}
		});

		// Initialisation du menu
		this.menu = new JPanel();
		this.menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));

		this.addArgument.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){
				comboPane.remove(typesCombo);
				typesCombo= new JComboBox(currentPane.getTypesCol().getTypes());
				typesCombo.setSelectedItem(null);
				comboPane.add(typesCombo, BorderLayout.CENTER);
				comboPane.invalidate();
				comboPane.validate();
				addArgument.setVisible(false);
				typesCombo.setVisible(true);
				valRetPane.setVisible(true);
			}
		});

		this.validate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addArgument(currentPane.getTypesCol().getTypes().get(
						typesCombo.getSelectedIndex()));
				valRetPane.setVisible(false);
				typesCombo.setVisible(false);
				addArgument.setVisible(true);
			}
		});

		this.ret.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				valRetPane.setVisible(false);
				typesCombo.setVisible(false);
				addArgument.setVisible(true);
			}
		});

		JPanel validatePane = new JPanel(new BorderLayout());
		validatePane.add(this.validate, BorderLayout.CENTER);

		JPanel retPane = new JPanel(new BorderLayout());
		retPane.add(this.ret, BorderLayout.CENTER);

		this.valRetPane = new JPanel();
		this.valRetPane.setLayout(new BoxLayout(valRetPane, BoxLayout.X_AXIS));
		this.valRetPane.add(retPane);
		this.valRetPane.add(validatePane);
		this.valRetPane.setVisible(false);

		this.typesCombo.setVisible(false);

		this.comboPane.setLayout(new BorderLayout());
		this.comboPane.add(this.typesCombo , BorderLayout.CENTER);

		JPanel addArgPane = new JPanel(new BorderLayout());
		addArgPane.add(this.addArgument, BorderLayout.CENTER);

		this.menu.add(addArgPane);
		this.menu.add(this.comboPane);
		this.menu.add(this.valRetPane);

		main.add(scrollJList, BorderLayout.CENTER);
		main.add(this.menu, BorderLayout.SOUTH);	

		this.setLayout(new BorderLayout());
		this.add(main, BorderLayout.CENTER);
	}


	public void addArgument(TypeGraphic tg){
		this.arguments.add(tg);
		this.argsJList.setModel(new DefaultListModel());
		this.argsJList.setListData(this.arguments);
		this.invalidate();
		this.validate();
	}

	private void removeArgument(TypeGraphic tg){
		this.arguments.remove(tg);
		this.argsJList.setModel(new DefaultListModel());
		this.argsJList.setListData(this.arguments);
		this.invalidate();
		this.validate();
	}

	@Override
	public String toString(){
		return this.name;
	}

	private JPopupMenu initPopup(){
		JPopupMenu popup = new JPopupMenu();
		JMenuItem suppr = new JMenuItem("Supprimer Concept");
		suppr.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){
				removeArgument(arguments.remove(argsJList.getSelectedIndex()));
			}
		});
		popup.add(suppr);
		return popup;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String descr){
		this.description = descr;
	}

	public void setName(String name){
		this.name = name;
	}
}