package ihm.user;

import ihm.tools.PanelColumnScenario;
import ihm.tools.PanelSubColumnScenario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import linguistic.Scenario;
import linguistic.typesGestion.LinguisticFactory;

public class PanelMiller extends JPanel{
	
	private static final long serialVersionUID = 1L;
	JPanel thisPane;
	JPanel colPane;
	PanelHomeUser currentHome;
	Scenario scenario;
	LinguisticFactory lf;
	
	private Dimension columnSize;
	
	public PanelMiller(Scenario s, PanelHomeUser p, 
			PanelNewScenario scenarioPane){
		this.setLayout(new BorderLayout());
		this.thisPane = this;
		this.currentHome = p;
		this.scenario = s;
		this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		JPanel leftPane = new JPanel(new BorderLayout());
		
		JPanel columnPanel = new JPanel();
		columnPanel.setLayout(new BoxLayout(columnPanel, BoxLayout.X_AXIS));
		this.colPane = columnPanel;
		leftPane.add(this.colPane, BorderLayout.WEST);
		
		JPanel panelContent = new JPanel(new BorderLayout());
		
		panelContent.setBackground(Color.ORANGE);
		
		JScrollPane scrollPane = new JScrollPane(panelContent);
		scrollPane.getHorizontalScrollBar().addAdjustmentListener(
				new AdjustmentListener(){

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e){
				thisPane.repaint();
			}
			
		});
		scrollPane.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.columnSize = new Dimension(200, panelContent.getHeight());
		panelContent.add(leftPane,BorderLayout.CENTER);
		PanelColumnScenario tmp = new PanelColumnScenario(
				this.columnSize, this, this.scenario, this.currentHome);
		scenarioPane.setScenarioRaw(tmp);
		panelContent.add(tmp, BorderLayout.WEST);
		this.add(scrollPane, BorderLayout.CENTER);
	}
	
	public void addColumn(PanelSubColumnScenario col){
		this.colPane.add(col);
		this.invalidate();
		this.validate();
	}

	public LinguisticFactory getLf(){
		return lf;
	}
}
