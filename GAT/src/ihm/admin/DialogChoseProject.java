package ihm.admin;

import ihm.MainFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import linguistic.conceptsGestion.Concept;
import linguistic.typesGestion.Type;
import linguistic.typesGestion.TypeTree;
import linguistic.typesGestion.TypeTreeNode;
import core.Project;

public class DialogChoseProject extends JDialog{

	JDialog thisDiag = this;
	MainFrame currentFrame;
	PanelHomeAdmin previous;

	JPanel comboPane = new JPanel();
	JComboBox combo;
	JButton ok;
	JButton ret;
	JButton suppr;

	Vector<String> vecProjectList = new Vector();

	public DialogChoseProject(MainFrame mf, final PanelHomeAdmin prev){
		this.currentFrame = mf;
		this.previous = prev;
		this.setTitle("Modifier Projet");
		this.setResizable(false);
		this.setModal(true);
		this.setLocationRelativeTo(mf);
		JPanel overGlobal = new JPanel(new BorderLayout());

		for (String s : currentFrame.getCore().getLocalStorageProjectList())
			this.vecProjectList.add(s);

		JPanel centerPane = new JPanel(new BorderLayout());

		JPanel centSub = new JPanel(new FlowLayout(FlowLayout.CENTER));

		JPanel subGlobalPane = new JPanel();
		subGlobalPane.setLayout(new BoxLayout(subGlobalPane, BoxLayout.Y_AXIS));

		JPanel projectLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel projectLabel = new JLabel("Projet :");
		projectLabelPanel.add(projectLabel);

		subGlobalPane.add(projectLabelPanel);

		initCombo();

		subGlobalPane.add(this.comboPane);
		centSub.add(subGlobalPane);

		JPanel buttons = new JPanel();

		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));

		JPanel buttPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension buttSize = new Dimension(100,20);

		JPanel retPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.ret = new JButton("Retour");
		this.ret.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0){
				thisDiag.dispose();
			}
		});
		this.ret.setPreferredSize(buttSize);
		retPanel.add(this.ret);

		JPanel supprPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.suppr = new JButton("Supprimer");
		this.suppr.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				int index = combo.getSelectedIndex();
				File f = new File(
						currentFrame.getCore().getLocalStorage().getLocation()
						+ File.separator + combo.getSelectedItem() + ".xml");
				f.delete();
				vecProjectList.remove(index);
				thisDiag.remove(combo);
				initCombo();
			}
		});

		this.suppr.setPreferredSize(buttSize);
		this.suppr.setEnabled(false);
		supprPanel.add(this.suppr);

		JPanel okPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.ok = new JButton("Valider");
		this.ok.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				loadProject((String) combo.getSelectedItem());
			}
		});

		this.ok.setPreferredSize(buttSize);
		okPanel.add(this.ok);

		buttPanel.add(retPanel);
		buttPanel.add(supprPanel);
		buttPanel.add(okPanel);
		southPanel.add(buttPanel);
		centerPane.add(centSub, BorderLayout.CENTER);

		overGlobal.add(southPanel, BorderLayout.SOUTH);
		overGlobal.add(centerPane,BorderLayout.CENTER);
		this.add(overGlobal);
		this.pack();
		Point loc = this.currentFrame.getLocationOnScreen();
		this.setLocation(loc.x+mf.getWidth()/2-this.getWidth()/2, 
				loc.y+mf.getHeight()/2-this.getHeight()/2);
	}

	private void initCombo(){
		if(this.combo != null)
			this.comboPane.remove(combo);
		this.combo = new JComboBox(vecProjectList);
		this.combo.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0){
				if(combo.getSelectedItem() != null)
					suppr.setEnabled(true);
			}
		});
		this.combo.setSelectedItem(null);
		this.combo.setPreferredSize(new Dimension(200,20));
		this.comboPane.add(this.combo);
		this.comboPane.invalidate();
		this.comboPane.validate();
		this.thisDiag.repaint();
	}

	private void loadProject(String project){
		Project p = (Project) currentFrame.getCore().
				getLocalStorage().load(project);
		currentFrame.getCore().setProject(p);

		PanelInitProject pip = new PanelInitProject(currentFrame,this.previous);

		TypeTree treeTmp = currentFrame.getCore().getProject().
				getLinguisticFactory().getTypeManager().getTypeTree();
		for(linguistic.typesGestion.Type t : treeTmp.getMap().keySet())
		{
			if(!t.getName().equals("object") && 
					!pip.getTypesCol().typeAlreadyExists(t.getName()))
				addType(pip, t);
		}

		TypeTreeNode root = treeTmp.getRoot();
		for (Concept c : treeTmp.getConceptsForType(root.getType()))
			addConcept(pip, c);

		currentFrame.setPane(pip);
		thisDiag.dispose();
	}

	private TypeGraphic addType(PanelInitProject pip, 
			linguistic.typesGestion.Type t){
		if(t.getSurtype() != null && !t.getSurtype().getName().equals("object"))
		{
			if(pip.getTypesCol().typeAlreadyExists(t.getSurtype().getName()))
			{
				TypeGraphic tmp = new TypeGraphic(pip, t.getName(), 
						pip.getTypesCol().getTypeByName(t.getSurtype().getName()));
				tmp.setDescription(t.getDescription());
				pip.getTypesCol().addTypeGraphic(tmp);
				return tmp;
			}
			else{
				TypeGraphic tmp = new TypeGraphic(pip, t.getName(), 
						addType(pip, t.getSurtype()));
				tmp.setDescription(t.getDescription());
				pip.getTypesCol().addTypeGraphic(tmp);
				return tmp;
			}
		}
		else{
			TypeGraphic tmp = new TypeGraphic(pip, t.getName());
			tmp.setDescription(t.getDescription());
			pip.getTypesCol().addTypeGraphic(tmp);
			return tmp;
		}
	}

	private void addConcept(PanelInitProject pip, Concept concept){
		if(concept.getNumberArguments() == 0)
		{
			ConceptGraphic tmp = new ConceptGraphic(
					pip, concept.getName(), pip.getTypesCol().getTypeByName(
							concept.getType().getName()));
			tmp.setDescription(concept.getDescription());
			pip.getConceptsCol().addConceptGraphic(tmp);
		}
		else{
			ConceptGraphic tmp = new ConceptGraphic(pip, concept.getName(), 
					pip.getTypesCol().getTypeByName(concept.getType().getName()));
			for(linguistic.typesGestion.Type t : concept.getArguments())
				tmp.addArgument(pip.getTypesCol().getTypeByName(t.getName()));
			tmp.setDescription(concept.getDescription());
			pip.getConceptsCol().addConceptGraphic(tmp);
		}
	}
}
