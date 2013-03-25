package ihm.admin;

import ihm.MainFrame;
import ihm.tools.PanelArgsColumnProject;

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

import core.Project;

public class DialogChoseProject extends JDialog{

	JDialog thisDiag = this;
	MainFrame currentFrame;
	
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
		this.combo = new JComboBox(vecProjectList);
		this.combo.addItemListener(new ItemListener(){
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(combo.getSelectedItem() != null )
					suppr.setEnabled(true);
			}
		});
		combo.setSelectedItem(null);
		combo.setPreferredSize(new Dimension(200,20));
		
		subGlobalPane.add(this.combo);
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
				File f = new File(currentFrame.getCore().getLocalStorage().getLocation());
				f.delete();
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
}
