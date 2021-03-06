package ihm.user;

import ihm.MainFrame;
import ihm.tools.PanelCenteredButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import syntox.SyntoxConnection;

import linguistic.Scenario;
import linguistic.graphConceptsGestion.GraphConcepts;

public class PanelExistingScenario extends JPanel{

	private static final long serialVersionUID = 1L;
	MainFrame currentFrame;
	PanelHomeUser previous;
	JPanel thisPane;
	JTextArea descrTArea;
	JList scenarioList;

	public PanelExistingScenario(MainFrame mf, PanelHomeUser prev){
		
		this.currentFrame = mf;
		this.previous = prev;
		this.thisPane = this;
		
		this.setLayout(new BorderLayout());
		setSouthPanel();
		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.add(setEastPanel(),BorderLayout.WEST);
		centerPanel.add(setWestPanel(),BorderLayout.EAST);
		this.add(centerPanel, BorderLayout.CENTER);
	}
	
	private void setSouthPanel()
	{
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
		
		JPanel returnPanel = new PanelCenteredButton(
				"Retour", new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.setPane(previous);
			}
		});
		
		JPanel modPanel  = new PanelCenteredButton("Modifier Scenario", 
				new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{	
				PanelNewScenario pr = new PanelNewScenario(currentFrame, 
						(Scenario) scenarioList.getSelectedValue(), previous);
				currentFrame.setPane(pr);
			}
		});
		
		JPanel validate = new PanelCenteredButton("Valider", 
				new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				Scenario sc = (Scenario) scenarioList.getSelectedValue();
				String result = "";
				for(GraphConcepts gc : sc.getGraphList())
					result += gc.generateSyntox()+"\n";
				SyntoxConnection syntox = new SyntoxConnection(result);
				syntox.requestSyntox();
				PanelResult pr = new PanelResult(currentFrame, thisPane, 
						previous, result);
				currentFrame.setPane(pr);
			}
		});
		
		southPanel.add(returnPanel);
		southPanel.add(modPanel);
		southPanel.add(validate);
		
		southPanel.setPreferredSize(new Dimension(currentFrame.getWidth(), 
				currentFrame.getHeight()/100*13));
		
		this.thisPane.add(southPanel, BorderLayout.SOUTH);
	}
	
	private JPanel setWestPanel(){
		JPanel leftPanel = new JPanel(new BorderLayout());
		leftPanel.setPreferredSize(new Dimension((
				currentFrame.getWidth()/100)*55,
				currentFrame.getHeight()/100*87));
		leftPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		
		JPanel northSubLeftP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		northSubLeftP.add(new JLabel("Description :"));
		
		JPanel centerSubLeftP = new JPanel(new BorderLayout());
		this.descrTArea = new JTextArea();
		this.descrTArea.setText("");
		this.descrTArea.setLineWrap(true);
		this.descrTArea.setEditable(false);
		JScrollPane descrScroll = new JScrollPane(this.descrTArea);
		descrScroll.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		descrScroll.setSize(centerSubLeftP.getWidth(),
				centerSubLeftP.getHeight());
		centerSubLeftP.add(descrScroll, BorderLayout.CENTER);
		
		leftPanel.add(northSubLeftP, BorderLayout.NORTH);
		leftPanel.add(centerSubLeftP, BorderLayout.CENTER);
		
		JPanel containsLeftPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		containsLeftPanel.add(leftPanel);
		
		return containsLeftPanel;
	}
	
	private JPanel setEastPanel(){
		
		JPanel rightPanel = new JPanel(new BorderLayout());
		rightPanel.setPreferredSize(new Dimension((
				currentFrame.getWidth()/100)*45,
				currentFrame.getHeight()/100*87));
		rightPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		
		JPanel northSubRightP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		northSubRightP.add(new JLabel("Scenario :"));
		
		JPanel centerSubRightP = new JPanel(new BorderLayout());
		
		this.scenarioList = new JList(this.currentFrame.getCore().getProject().
				getListScenario().toArray());
		scenarioList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scenarioList.addListSelectionListener(new ListSelectionListener(){
			
			@Override
			public void valueChanged(ListSelectionEvent arg0){
				if(arg0.getValueIsAdjusting())
			      {
					int index = scenarioList.getSelectedIndex();
					descrTArea.setText(currentFrame.getCore().getProject().
							getListScenario().get(index).getDescription());
					thisPane.invalidate();
					thisPane.validate();
			      }
			}
		});
		
		final JPopupMenu popup_desktop = new JPopupMenu("Desktop Menu : ");
		JMenuItem suppr = new JMenuItem("Supprimer Scenario");
		suppr.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){
				ArrayList<Scenario> tmp =currentFrame.getCore().getProject().
						getListScenario();
				tmp.remove(scenarioList.getSelectedIndex());
				currentFrame.getCore().getProject().setListScenario(tmp);
				refreshScenarioList();
			}
		});
		
		popup_desktop.add(suppr);
  	  	
		scenarioList.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
		              if (e.getButton() == 3)
		              {
		            	  scenarioList.setSelectedIndex(scenarioList.
		            			  locationToIndex(e.getPoint()));
		            	  popup_desktop.show(scenarioList, e.getX(), e.getY());
		              }
		        }
		});
		
		JScrollPane scrollPane = new JScrollPane(scenarioList);
		scrollPane.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setSize(centerSubRightP.getWidth(),
				centerSubRightP.getHeight());
		centerSubRightP.add(scrollPane, BorderLayout.CENTER);
		
		rightPanel.add(northSubRightP, BorderLayout.NORTH);
		rightPanel.add(centerSubRightP, BorderLayout.CENTER);
		
		JPanel containsRightPanel = new JPanel(
				new FlowLayout(FlowLayout.CENTER));
		containsRightPanel.add(rightPanel);
		
		return containsRightPanel;
	}
	
	private void refreshScenarioList()
	{
		this.scenarioList.setModel(new DefaultListModel());
		this.scenarioList.setListData(currentFrame.getCore().getProject().
				getListScenario().toArray());
		this.thisPane.invalidate();
		this.thisPane.validate();
	}
}
