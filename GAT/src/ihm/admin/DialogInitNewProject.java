package ihm.admin;

import ihm.MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import core.InfoDb;
import core.Project;
import databaseConnection.DBConnection;
import databaseInspection.Base;
import databaseInspection.BaseFactoryImpl;
import databaseInspection.Column;
import databaseInspection.Table;

public class DialogInitNewProject extends JDialog{
	JDialog thisDiag = this;
	MainFrame currentFrame;

	JTextField newProjectTextArea = new JTextField(16);
	JTextField dataBaseTextArea = new JTextField(16);
	JTextField idTextArea = new JTextField(12);
	JPasswordField pwTextArea = new JPasswordField(12);

	JLabel errorProjectName = new JLabel("Nom de scenario incorrect");

	public DialogInitNewProject(MainFrame mf, final PanelHomeAdmin prev){
		this.currentFrame = mf;
		this.setTitle("Creation d'un nouveau projet");
		this.setResizable(false);
		this.setModal(true);
		this.setLocationRelativeTo(mf);

		JPanel overGlobal = new JPanel(new BorderLayout());
		JPanel centerPane = new JPanel(new BorderLayout());

		JPanel centSub = new JPanel(new FlowLayout(FlowLayout.CENTER));

		JPanel subGlobalPane = new JPanel();
		subGlobalPane.setLayout(new BoxLayout(subGlobalPane, BoxLayout.Y_AXIS));

		JPanel newProjectLabelPanel = 
				new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel newProjectLabel = new JLabel("Nom du nouveau projet :");
		newProjectLabelPanel.add(newProjectLabel);

		JPanel newProjectTextAreaPanel = new JPanel(
				new FlowLayout(FlowLayout.LEFT));
		this.newProjectTextArea.getDocument().addDocumentListener(
				new DocumentListener(){

					@Override
					public void changedUpdate(DocumentEvent arg0){
						errorProjectName.setVisible(false);
					}

					@Override
					public void insertUpdate(DocumentEvent e){
						errorProjectName.setVisible(false);
					}

					@Override
					public void removeUpdate(DocumentEvent e){
						errorProjectName.setVisible(false);
					}
				});

		this.newProjectTextArea.setBorder(
				BorderFactory.createLoweredBevelBorder());
		newProjectTextAreaPanel.add(this.newProjectTextArea);

		JPanel dataBasePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel dataBaseLabel = new JLabel("Base de donnees :");
		dataBasePanel.add(dataBaseLabel);

		JPanel dataBaseTextAreaPanel = 
				new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.dataBaseTextArea.setBorder(
				BorderFactory.createLoweredBevelBorder());
		dataBaseTextAreaPanel.add(this.dataBaseTextArea);

		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel idLabel = new JLabel("Identifiant :");
		idPanel.add(idLabel);

		JPanel idTextAreaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.idTextArea.setBorder(BorderFactory.createLoweredBevelBorder());
		idTextAreaPanel.add(this.idTextArea);

		JPanel pwPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel pwLabel = new JLabel("Mot de passe :");
		pwPanel.add(pwLabel);

		JPanel pwTextAreaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.pwTextArea.setBorder(BorderFactory.createLoweredBevelBorder());
		pwTextAreaPanel.add(this.pwTextArea);

		this.errorProjectName.setForeground(Color.RED);
		this.errorProjectName.setVisible(false);
		JPanel errorProjectPanel = 
				new JPanel(new FlowLayout(FlowLayout.CENTER));
		errorProjectPanel.add(this.errorProjectName);

		subGlobalPane.add(newProjectLabelPanel);
		subGlobalPane.add(newProjectTextAreaPanel);
		subGlobalPane.add(errorProjectPanel);
		subGlobalPane.add(dataBasePanel);
		subGlobalPane.add(dataBaseTextAreaPanel);
		subGlobalPane.add(idPanel);
		subGlobalPane.add(idTextAreaPanel);
		subGlobalPane.add(pwPanel);
		subGlobalPane.add(pwTextAreaPanel);

		centSub.add(subGlobalPane);

		JPanel buttons = new JPanel();

		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));

		JPanel coucoulol = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension buttSize = new Dimension(100,20);

		JPanel retPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton ret = new JButton("Retour");
		ret.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				thisDiag.dispose();
			}
		});
		
		ret.setPreferredSize(buttSize);
		retPanel.add(ret);
		JPanel okPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton ok = new JButton("Valider");
		ok.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				String projectName = newProjectTextArea.getText();
				String id = idTextArea.getText();
				String pwd = pwTextArea.getText();
				String dataBase = dataBaseTextArea.getText();

				if(projectName.length() != 0){
					
					boolean errorDB = false;
					PanelInitProject pip = 
							new PanelInitProject(currentFrame, prev);
					currentFrame.getCore().setProject(new Project(
							new InfoDb(dataBase, "mySQL", id, pwd), projectName));
					if(id.length() !=0 && 
							pwd.length() !=0 && 
							dataBase.length() != 0)
					{
						try {
							initProjectFromBD(pip);
						} catch (SQLException e1) {
							e1.printStackTrace();
							errorDB = true;
						}
					}	
					if(errorDB == false)
						currentFrame.setPane(pip);
					thisDiag.dispose();
				}
				else{
					errorProjectName.setVisible(true);
					thisDiag.pack();
					thisDiag.invalidate();
				}
			}
		});
		
		ok.setPreferredSize(buttSize);
		okPanel.add(ok);

		coucoulol.add(retPanel);
		coucoulol.add(okPanel);
		southPanel.add(coucoulol);
		centerPane.add(centSub, BorderLayout.CENTER);

		overGlobal.add(southPanel, BorderLayout.SOUTH);
		overGlobal.add(centerPane,BorderLayout.CENTER);
		this.add(overGlobal);
		this.pack();
		Point loc = this.currentFrame.getLocationOnScreen();
		this.setLocation(loc.x+mf.getWidth()/2-this.getWidth()/2, 
				loc.y+mf.getHeight()/2-this.getHeight()/2);
	}


	private void initProjectFromBD(PanelInitProject pip) throws SQLException{
		
		DBConnection tmp = this.currentFrame.getCore().getProject().
				getInfoDb().getDBCfromInfoDB();

		if(tmp.connection())
		{
			Base tmpBase = BaseFactoryImpl.getInstance().extractBase(tmp);
			for(Table t : tmpBase.getListTable().values())
			{
				pip.getTypesCol().addTypeGraphic(
						new TypeGraphic(pip, t.getName()));
				for(Column c : t.getColumn().values())
				{
					TypeGraphic tg = new TypeGraphic(
							pip, t.getName() + "." + c.getName());
					pip.getTypesCol().addTypeGraphic(tg);
				}
			}
			tmp.disconnection();
		}
	}
}
