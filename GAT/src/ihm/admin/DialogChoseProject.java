package ihm.admin;

import ihm.MainFrame;
import ihm.tools.PanelArgsColumnProject;
import ihm.tools.PanelSurTypeColumnProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import linguistic.conceptsGestion.Concept;

import core.Project;

public class DialogChoseProject extends JDialog{

	JDialog thisDiag = this;
	MainFrame currentFrame;
	
	JPanel comboPane = new JPanel();
	JComboBox combo;
	JButton ok;
	JButton ret;
	JButton suppr;
	
	Vector<String> vecProjectList = new Vector();
	
	public DialogChoseProject(MainFrame mf, final JPanel prev)
	{
		this.currentFrame = mf;
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

			public void actionPerformed(ActionEvent arg0) {
				thisDiag.dispose();
			}
			
		});
		this.ret.setPreferredSize(buttSize);
		retPanel.add(this.ret);
		
		JPanel supprPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.suppr = new JButton("Supprimer");
		this.suppr.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int index = combo.getSelectedIndex();
				File f = new File(currentFrame.getCore().getLocalStorage().getLocation() + File.separator + combo.getSelectedItem() + ".xml");
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

			public void actionPerformed(ActionEvent e) {
				Project p = (Project) currentFrame.getCore().getLocalStorage().load((String) combo.getSelectedItem());
				currentFrame.getCore().setProject(p);
				Vector<PanelSurTypeColumnProject> types = new Vector();
				Vector<PanelArgsColumnProject> concepts = new Vector();
				PanelNewProject pnp = new PanelNewProject(currentFrame, prev, concepts, types);

				Iterator it = currentFrame.getCore().getProject().getLinguisticFactory().getTypeManager().getTypeTree().getMap().keySet().iterator();
				for (;it.hasNext();)
				{
					linguistic.typesGestion.Type type = (linguistic.typesGestion.Type) it.next();
					if (! type.getName().equals("object"))
					{
						PanelSurTypeColumnProject pane = new PanelSurTypeColumnProject(currentFrame, pnp, type.getName());
						types.add(pane);
						for (Concept c : currentFrame.getCore().getProject().getLinguisticFactory().getTypeManager().getTypeTree().getConceptsForType(type))
						{
							PanelArgsColumnProject cons = new PanelArgsColumnProject(currentFrame, pnp, c.getName());
							cons.conceptType = pane;
							concepts.add(cons);
						}
					}
				}

				
				currentFrame.setPane(pnp);
				thisDiag.dispose();
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
		this.setLocation(loc.x+mf.getWidth()/2-this.getWidth()/2, loc.y+mf.getHeight()/2-this.getHeight()/2);
	}
	
	private void initCombo()
	{
		if(this.combo != null)
			this.comboPane.remove(combo);
		this.combo = new JComboBox(vecProjectList);
		this.combo.addItemListener(new ItemListener(){
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(combo.getSelectedItem() != null )
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
}
