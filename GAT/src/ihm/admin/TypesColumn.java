package ihm.admin;

import ihm.MainFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TypesColumn extends JPanel{

	MainFrame currentFrame;
	
	PanelInitProject currentPane;
	
	Dimension size;
	
	TypeGraphic currentTypePanel= null;
	
	JPanel displayArea = new JPanel();
	Vector<TypeGraphic> types = new Vector();
	JList typesJList;
	
	JPanel menu = new JPanel();
	JButton addType = new JButton("Ajouter Type");
	JButton validate = new JButton("Valider");
	JButton ret = new JButton("Annuler");
	JLabel typeLabel = new JLabel("Type: ");
	JLabel surTypeLabel = new JLabel("Sur-type: ");
	JTextField typeName = new JTextField(12);
	JComboBox surTypeCombo= new JComboBox();
	
	
	public TypesColumn(MainFrame currentFrame, PanelInitProject pip)
	{
		this.currentFrame = currentFrame;
		this.currentPane = pip;
		this.setLayout(new GridLayout(1,2));
		initMainColumn();
	}

	private void initMainColumn(){

		JPanel main = new JPanel(new BorderLayout());
		
		// Initialisation de la JList
		
		this.typesJList = new JList(this.types);
		this.typesJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		this.typesJList.setCellRenderer(centerRenderer);
		JScrollPane scrollJList = new JScrollPane(this.typesJList);
		scrollJList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.typesJList.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) 
			{
				// TODO Auto-generated method stub
				if(arg0.getValueIsAdjusting())
			      {
					setCurrentTypePanel(types.get(typesJList.getSelectedIndex()));
			      }
			}
		});
		
		this.typesJList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 3)
				{
					typesJList.setSelectedIndex(typesJList.locationToIndex(e.getPoint()));
					JPopupMenu popup = initPopup();
					popup.show(typesJList, e.getX(), e.getY());
				}
			}
		});

		// Initialisation du menu
		
		this.menu = new JPanel();
		this.menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
		this.menu.setVisible(false);
		
		
		this.addType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menu.remove(surTypeCombo);
				surTypeCombo= new JComboBox(types);
				surTypeCombo.setSelectedItem(null);
				menu.add(surTypeCombo);
				typeName.setText("");
				menu.invalidate();
				menu.validate();
				menu.setVisible(true);
				currentFrame.invalidate();
				currentFrame.validate();
				addType.setVisible(false);
				validate.setVisible(true);
				ret.setVisible(true);
			}
		});
		
		this.validate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menu.setVisible(false);
				addType.setVisible(true);
				validate.setVisible(false);
				ret.setVisible(false);
				TypeGraphic tmp;
				if((TypeGraphic)surTypeCombo.getSelectedItem() != null)
				{
					tmp = new TypeGraphic(currentPane, typeName.getText(), (TypeGraphic)surTypeCombo.getSelectedItem());
				}
				else
				{
					tmp=new TypeGraphic(currentPane, typeName.getText());
				}
				addTypeGraphic(tmp);
			}
		});
		this.validate.setVisible(false);
		
		this.ret.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menu.setVisible(false);
				addType.setVisible(true);
				validate.setVisible(false);
				ret.setVisible(false);
			}
		});
		this.ret.setVisible(false);
		
		this.menu.add(this.typeLabel);
		this.menu.add(this.typeName);
		this.menu.add(this.surTypeLabel);
		this.menu.add(this.surTypeCombo);
		
		JPanel validatePane = new JPanel(new BorderLayout());
		validatePane.add(this.validate, BorderLayout.CENTER);
		
		JPanel retPane = new JPanel(new BorderLayout());
		retPane.add(this.ret, BorderLayout.CENTER);
		
		JPanel addConceptPane = new JPanel(new BorderLayout());
		addConceptPane.add(this.addType, BorderLayout.CENTER);
		
		JPanel valRetPane = new JPanel();
		valRetPane.setLayout(new BoxLayout(valRetPane, BoxLayout.X_AXIS));
		valRetPane.add(retPane);
		valRetPane.add(validatePane);
		
		JPanel tmp = new JPanel();
		tmp.setLayout(new BoxLayout(tmp,BoxLayout.Y_AXIS));
		tmp.add(menu);
		tmp.add(addConceptPane);
		tmp.add(valRetPane);
		main.add(scrollJList, BorderLayout.CENTER);
		main.add(tmp, BorderLayout.SOUTH);
	
		this.add(main);
		
		this.displayArea.setLayout(new BoxLayout(this.displayArea, BoxLayout.X_AXIS));
		this.add(this.displayArea);

	}
	
	public void setCurrentTypePanel(TypeGraphic cg)
	{
		if(this.currentTypePanel != null)
		{
			this.currentTypePanel.setVisible(false);
		}
		this.currentTypePanel = cg;
		this.currentTypePanel.selectMenuToShow();
		this.currentTypePanel.setVisible(true);
		this.currentPane.setCurrentDescription(cg.description);

		this.invalidate();
		this.validate();
		this.repaint();
	}
	
	public Vector<TypeGraphic> getTypes() {
		return types;
	}
	
	public void addTypeGraphic(TypeGraphic cg)
	{
		cg.setVisible(false);
		cg.selectMenuToShow();
		this.setCurrentTypePanel(cg);
		this.types.add(cg);
		this.typesJList.setModel(new DefaultListModel());
		this.typesJList.setListData(this.types);
		this.displayArea.add(cg);
		this.invalidate();
		this.validate();
		this.repaint();
	}
	
	public void removeTypeGraphic(TypeGraphic cg)
	{
		this.types.remove(cg);
		this.typesJList.setModel(new DefaultListModel());
		this.typesJList.setListData(this.types);
		this.currentTypePanel.setVisible(false);
		this.currentTypePanel = null;
		this.invalidate();
		this.validate();
	}
	
	private JPopupMenu initPopup()
	{
		JPopupMenu popup = new JPopupMenu();
		
		JMenuItem rename = new JMenuItem("Renommer Type");
		rename.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DialogRename dd = new DialogRename(currentPane, types.get(typesJList.getSelectedIndex()));
				
				Point loc = currentFrame.getLocationOnScreen();
				dd.setLocation(loc.x+currentFrame.getWidth()/2-dd.getWidth()/2, loc.y+currentFrame.getHeight()/2-dd.getHeight()/2);
				dd.setVisible(true);
			}
			
		});
		
		
		JMenuItem suppr = new JMenuItem("Supprimer Type");
		suppr.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeTypeGraphic(types.remove(typesJList.getSelectedIndex()));
			}
			
		});

		JMenuItem descr = new JMenuItem("Ajouter Description");
		descr.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DialogDescription dd = new DialogDescription(currentPane, types.get(typesJList.getSelectedIndex()));
				
				Point loc = currentFrame.getLocationOnScreen();
				dd.setLocation(loc.x+currentFrame.getWidth()/2-dd.getWidth()/2, loc.y+currentFrame.getHeight()/2-dd.getHeight()/2);
				dd.setVisible(true);
			}
			
		});
		popup.add(rename);
		popup.add(descr);
		popup.add(suppr);
		return popup;
	}
	
	public boolean typeAlreadyExists(String typeName)
	{
		for(TypeGraphic tg : types)
		{
			if(tg.toString().equals(typeName))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public TypeGraphic getTypeByName(String typeName)
	{
		
		
		for(TypeGraphic tg : types)
		{
			if(tg.toString().equals(typeName))
				return tg;
		}
		
		return null;
	}
	
	public void renameTypeGraphic(String newName, TypeGraphic tg)
	{
		tg.name = newName;
		this.typesJList.setModel(new DefaultListModel());
		this.typesJList.setListData(this.types);
		this.invalidate();
		this.validate();
	}
	
}
