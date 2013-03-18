package src.ihm.user;

import src.ihm.tools.PanelColumnScenario;
import src.ihm.tools.PanelSubColumnScenario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import src.linguistic.Scenario;
import src.linguistic.types_gestion.LinguisticFactory;

public class PanelMiller extends JPanel{
	
	JPanel thisPane;
	JPanel colPane;
	
	Scenario scenario;
	LinguisticFactory lf;
	
	private Dimension columnSize;
	
	public PanelMiller(Scenario s/*, LinguisticFactory lf*/)
	{
		this.setLayout(new BorderLayout());
		this.thisPane = this;
		this.scenario = s;
		//this.lf = lf;
		this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		JPanel leftPane = new JPanel(new BorderLayout());
		
		JPanel columnPanel = new JPanel();
		columnPanel.setLayout(new BoxLayout(columnPanel, BoxLayout.X_AXIS));
		this.colPane = columnPanel;
		leftPane.add(this.colPane, BorderLayout.WEST);
		
		
		JPanel panelContent = new JPanel(new BorderLayout());
		
		
		panelContent.setBackground(Color.ORANGE);
		
		
		JScrollPane scrollPane = new JScrollPane(panelContent);
		scrollPane.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener(){

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				
				thisPane.repaint();
				
			}
			
		});
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.columnSize = new Dimension(200, panelContent.getHeight());
		panelContent.add(leftPane,BorderLayout.CENTER);
		panelContent.add(new PanelColumnScenario(this.columnSize, this, this.scenario), BorderLayout.WEST);
		this.add(scrollPane, BorderLayout.CENTER);
	}
	
	public void addColumn(PanelSubColumnScenario col)
	{
		this.colPane.add(col);
		this.revalidate();
	}

	public LinguisticFactory getLf() {
		return lf;
	}
	
	
}
