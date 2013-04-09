package ihm.admin;

import ihm.MainFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import linguistic.conceptsGestion.Concept;
import linguistic.typesGestion.Type;

public class PanelInitProject extends JPanel{

	private static final long serialVersionUID = 1L;
	MainFrame currentFrame;
	PanelHomeAdmin previous;
	
	ConceptsColumn conceptsCol;
	TypesColumn typesCol;
	
	JTextArea currentDescription =  new JTextArea("");
	JPanel descrPanel;
	
	public PanelInitProject(MainFrame mf, PanelHomeAdmin prev){
		this.currentFrame = mf;
		this.setPreferredSize(currentFrame.getSize());
		this.previous = prev;
		this.setLayout(new BorderLayout());
		this.add(initMenuBar(), BorderLayout.NORTH);
		this.add(initCenterPane(), BorderLayout.CENTER);
	}
	
	private JPanel initCenterPane(){
		
		JPanel tmp = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.weightx = 0.9;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		tmp.add(initTabbedPane(), gbc);
		
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.weightx = 0.1;
		gbc.weighty = 1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		tmp.add(initDescPane(), gbc);
		return tmp;
	}
	
	
	private JTabbedPane initTabbedPane(){
		
		JTabbedPane tabbedPane = new JTabbedPane();
		this.conceptsCol = new ConceptsColumn(currentFrame, this);
		this.typesCol = new TypesColumn(currentFrame, this);
		
		
		
		tabbedPane.addTab("Concepts",this.conceptsCol);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		tabbedPane.addTab("Types",this.typesCol);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		return tabbedPane;
	}
	
	private JPanel initDescPane(){
		
		JPanel descrPane = new JPanel(new BorderLayout());

		JLabel description = new JLabel("Description :");
		this.currentDescription = new JTextArea();
		this.currentDescription.setText("");
		this.currentDescription.setLineWrap(true);
		this.currentDescription.setEditable(false);
		JScrollPane descrScroll = new JScrollPane(this.currentDescription);
		descrScroll.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		descrPane.add(description, BorderLayout.NORTH);
		descrPane.add(descrScroll, BorderLayout.CENTER);
		descrPane.setBorder(BorderFactory.
				createEmptyBorder((currentFrame.getHeight())/15,20,
						(currentFrame.getHeight())/15,20));
		this.descrPanel = descrPane;
		
		descrPane.setPreferredSize(new Dimension(
				(int)currentFrame.getWidth()/10*3, descrPane.getHeight()));
		return descrPane;
	}
	
	private JMenuBar initMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("Fichier");

		JMenuItem save = new JMenuItem("Enregistrer Projet en cours");
		save.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				saveProject();
			}
		});
		
		JMenuItem quit = new JMenuItem("Quitter");
		quit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){
				currentFrame.setPane(previous);
			}
		});

		fileMenu.add(save);
		fileMenu.add(quit);
		menuBar.add(fileMenu);
		return menuBar;
	}


	public ConceptsColumn getConceptsCol(){
		return conceptsCol;
	}

	public TypesColumn getTypesCol(){
		return typesCol;
	}

	public JTextArea getCurrentDescription(){
		return currentDescription;
	}

	public void setCurrentDescription(String description){
		this.currentDescription.setText(description);
		this.currentDescription.invalidate();
		this.currentDescription.validate();
		this.repaint();
	}
	
	private void saveProject(){
		for(TypeGraphic tg : this.typesCol.getTypes())
			recMakeType(tg);
		
		for(ConceptGraphic cg : this.conceptsCol.getConcepts())
		{
			Type typeTmp = getTypeForTypeGraphic(cg.type);
			if(!conceptAlreadyExists(typeTmp, cg.toString()))
			{
				if(cg.arguments.size() != 0)
				{
					List<Type> tmp = getTypeList(cg.arguments);
					currentFrame.getCore().getProject().
					getLinguisticFactory().makeConcept(
							cg.toString(),typeTmp , tmp, cg.getDescription());
				}
				else
					currentFrame.getCore().getProject().
					getLinguisticFactory().makeConcept(
							cg.toString(), typeTmp, cg.getDescription());
			}
		}
		
		currentFrame.getCore().backupProject(
				currentFrame.getCore().getProject().getName());
	}

	private Type recMakeType(TypeGraphic type){
		
		Iterator<Type> it = currentFrame.getCore().getProject().
				getLinguisticFactory().getTypeManager().getTypeTree().
				getMap().keySet().iterator();
		for(;it.hasNext();)
		{
			Type tmpType = (Type)it.next();
			if(tmpType.getName().equals(type.toString()))
				return tmpType;
		}

		if (type.getSurType() == null)
			return currentFrame.getCore().getProject().
					getLinguisticFactory().getTypeManager().
					makeType(type.toString(),type.getDescription());
		else
			return currentFrame.getCore().getProject().
					getLinguisticFactory().getTypeManager().
					makeType(type.toString(), recMakeType(
							type.getSurType()), type.getDescription());
	}
	
	public List<Type> getTypeList(Vector<TypeGraphic> vecTypeGraphic){
		
		List<Type> result = new ArrayList<Type>();
		for(TypeGraphic tg : vecTypeGraphic)
		{
			String typeName = tg.toString();
			Iterator<Type> ti = currentFrame.getCore().getProject().
					getLinguisticFactory().getTypeManager().
					getTypeTree().getMap().keySet().iterator();
			for(;ti.hasNext();)
			{
				Type tmpType = (Type)ti.next();
				if(tmpType.getName().equals(typeName))
				{ 
					result.add(tmpType);
					break;
				}
			}
		}
		return result;
	}
	
	public Type getTypeForTypeGraphic(TypeGraphic typeGraphic){
		
		Type result= null;
		Iterator<Type> it = currentFrame.getCore().getProject().
				getLinguisticFactory().getTypeManager().
				getTypeTree().getMap().keySet().iterator();
		for(;it.hasNext();)
		{
			Type tmpType = (Type)it.next();
			if(tmpType.getName().equals(typeGraphic.toString()))
			{
				result = tmpType;
				return result;
			}
		}
		return result;
	}
	
	public boolean conceptAlreadyExists(Type t, String conceptName){
		
		for(Concept c : currentFrame.getCore().getProject().
				getLinguisticFactory().getTypeManager().
				getTypeTree().getConceptsForType(t))
		{
			if(c.getName().equals(conceptName))
				return true;
		}
		return false;
	}
}
