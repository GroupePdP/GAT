package ihm.admin;

import ihm.MainFrame;

import java.awt.BorderLayout;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ConceptsColumn extends JPanel{
	
	MainFrame currentFrame;
	
	PanelInitProject currentPane;
	
	ConceptGraphic currentConceptPanel;
	
	Vector<ConceptGraphic> concepts = new Vector();
	JList conceptsJList;
	
	JPanel displayArea = new JPanel();
	
	JPanel menu = new JPanel();
	JButton addConcept = new JButton("Ajouter Concept");
	JButton validate = new JButton("Valider");
	JButton ret = new JButton("Annuler");
	JLabel typeLabel = new JLabel("Type: ");
	JLabel conceptLabel = new JLabel("Concept: ");
	JTextField conceptName = new JTextField(16);
	JComboBox typeCombo= new JComboBox();
	
	public ConceptsColumn(MainFrame currentFrame, PanelInitProject pip) 
	{
		this.currentFrame = currentFrame;
		this.setLayout(new GridLayout(1,2));
		this.currentPane = pip;
		initMainColumn();
	}
	
	private void initMainColumn()
	{
		JPanel main = new JPanel(new BorderLayout());
		
		// Initialisation de la JList
		
		
		this.conceptsJList = new JList(this.concepts);
		DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		this.conceptsJList.setCellRenderer(centerRenderer);
		JScrollPane scrollJList = new JScrollPane(this.conceptsJList);
		scrollJList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.conceptsJList.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) 
			{
				// TODO Auto-generated method stub
				if(arg0.getValueIsAdjusting())
			      {
					
					setCurrentConceptPanel(concepts.get(conceptsJList.getSelectedIndex()));
			      }
			}
		});
		
		this.conceptsJList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 3)
				{
					conceptsJList.setSelectedIndex(conceptsJList.locationToIndex(e.getPoint()));
					JPopupMenu popup = initPopup();
					popup.show(conceptsJList, e.getX(), e.getY());
				}
			}
		});

		
		// Initialisation du menu
		
		this.menu = new JPanel();
		this.menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
		this.menu.setVisible(false);
		
		
		this.addConcept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menu.remove(typeCombo);
				typeCombo= new JComboBox(currentPane.getTypesCol().getTypes());
				typeCombo.setSelectedItem(null);
				menu.add(typeCombo);
				conceptName.setText("");
				menu.invalidate();
				menu.validate();
				menu.setVisible(true);
				addConcept.setVisible(false);
				validate.setVisible(true);
				ret.setVisible(true);
			}
		});
		
		this.validate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menu.setVisible(false);
				addConcept.setVisible(true);
				validate.setVisible(false);
				ret.setVisible(false);
				ConceptGraphic tmp = new ConceptGraphic(currentPane, conceptName.getText(), (TypeGraphic)typeCombo.getSelectedItem());
				
				addConceptGraphic(tmp);
			}
		});
		this.validate.setVisible(false);
		this.ret.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menu.setVisible(false);
				addConcept.setVisible(true);
				validate.setVisible(false);
				ret.setVisible(false);
			}
		});
		this.ret.setVisible(false);

		this.menu.add(this.conceptLabel);
		this.menu.add(this.conceptName);
		this.menu.add(this.typeLabel);
		this.menu.add(this.typeCombo);
		
		JPanel validatePane = new JPanel(new BorderLayout());
		validatePane.add(this.validate, BorderLayout.CENTER);
		
		JPanel retPane = new JPanel(new BorderLayout());
		retPane.add(this.ret, BorderLayout.CENTER);
		
		JPanel valRetPane = new JPanel();
		valRetPane.setLayout(new BoxLayout(valRetPane, BoxLayout.X_AXIS));
		valRetPane.add(retPane);
		valRetPane.add(validatePane);
		
		
		JPanel addConceptPane = new JPanel(new BorderLayout());
		addConceptPane.add(this.addConcept, BorderLayout.CENTER);
		
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

	public void setCurrentConceptPanel(ConceptGraphic cg)
	{
		if(this.currentConceptPanel != null)
		{
			this.currentConceptPanel.setVisible(false);
		}
		this.currentConceptPanel = cg;
		this.currentConceptPanel.setVisible(true);
		this.currentPane.setCurrentDescription(cg.description);
	}
	
	public void addConceptGraphic(ConceptGraphic cg)
	{
		cg.setVisible(false);
		this.setCurrentConceptPanel(cg);
		this.concepts.add(cg);
		this.conceptsJList.setModel(new DefaultListModel());
		this.conceptsJList.setListData(this.concepts);
		this.displayArea.add(cg);
		this.invalidate();
		this.validate();
	}
	
	public void removeConceptGraphic(ConceptGraphic cg)
	{
		cg.setVisible(false);
		this.concepts.remove(cg);
		this.conceptsJList.setModel(new DefaultListModel());
		this.conceptsJList.setListData(this.concepts);
		this.invalidate();
		this.validate();
	}
	

	public Vector<ConceptGraphic> getConcepts() {
		return concepts;
	}

	private JPopupMenu initPopup()
	{
		JPopupMenu popup = new JPopupMenu();
		
		JMenuItem rename = new JMenuItem("Renommer Concept");
		rename.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DialogRename dd = new DialogRename(currentPane, concepts.get(conceptsJList.getSelectedIndex()));
				
				Point loc = currentFrame.getLocationOnScreen();
				dd.setLocation(loc.x+currentFrame.getWidth()/2-dd.getWidth()/2, loc.y+currentFrame.getHeight()/2-dd.getHeight()/2);
				dd.setVisible(true);
			}
			
		});
		
		
		JMenuItem suppr = new JMenuItem("Supprimer Concept");
		suppr.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeConceptGraphic(concepts.remove(conceptsJList.getSelectedIndex()));
				currentPane.setCurrentDescription("");
			}
			
		});
		
		JMenuItem syntox = new JMenuItem("Ajouter entrée Synthox");
		syntox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
			
		});

		JMenuItem descr = new JMenuItem("Editer Description");
		descr.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DialogDescription dd = new DialogDescription(currentPane, concepts.get(conceptsJList.getSelectedIndex()));

				Point loc = currentFrame.getLocationOnScreen();
				dd.setLocation(loc.x+currentFrame.getWidth()/2-dd.getWidth()/2, loc.y+currentFrame.getHeight()/2-dd.getHeight()/2);
				dd.setVisible(true);
			}

		});

		popup.add(rename);
		popup.add(descr);
		popup.add(syntox);
		popup.add(suppr);
		return popup;
	}
	
	public void renameConceptGraphic(String newName, ConceptGraphic tg)
	{
		tg.name = newName;
		this.conceptsJList.setModel(new DefaultListModel());
		this.conceptsJList.setListData(this.concepts);
		this.invalidate();
		this.validate();
	}
}
