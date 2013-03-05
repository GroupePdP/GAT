package ihm.user;

import ihm.MainFrame;
import ihm.tools.PanelCenteredButton;
import ihm.tools.PanelColumn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class PanelNewScenario extends JPanel{

	MainFrame currentFrame;
	JPanel thisPane=this;
	
	JPanel colcont;
	
	private Dimension columnSize;
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu test1 = new JMenu("Fichier");
	
	private JMenuItem item1 = new JMenuItem("Enregistrer Scénario en cours");
	private JMenuItem item2 = new JMenuItem("Enregistrer");
	private JMenuItem item3 = new JMenuItem("Quitter");
	
	public PanelNewScenario(MainFrame mf)
	{
		this.currentFrame = mf;
		
		this.setLayout(new BorderLayout());
		
		setMenuBar();
		setDescrPane();
		setMillerPane();
		
	}
	
	private void setMenuBar()
	{
		
		test1.add(item1);
		test1.add(item2);
		test1.add(item3);
		
		menuBar.add(test1);
		
		this.thisPane.add(menuBar, BorderLayout.NORTH);
	}
	
	private void setMillerPane()
	{
		final JPanel colSubContainer = new JPanel();
		colSubContainer.setLayout(new BoxLayout(colSubContainer, BoxLayout.X_AXIS));
		
		final JPanel columnContainer = new JPanel(new BorderLayout());
		columnContainer.setBackground(Color.orange);
		columnContainer.add(colSubContainer, BorderLayout.WEST);
		this.colcont= columnContainer;
		
		
		JPanel global = new JPanel();
		global.setLayout(new BorderLayout());
		global.setBackground(Color.green);
		global.add(columnContainer, BorderLayout.CENTER);
		
		final JScrollPane scrollPane = new JScrollPane(global);
		scrollPane.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener(){

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				
				columnContainer.repaint();
				
			}
			
		});
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JPanel millerGlobal = new JPanel(new BorderLayout());
		millerGlobal.setBackground(Color.blue);
		millerGlobal.add(scrollPane);
		
		JPanel left = new JPanel(new BorderLayout());
		left.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		this.columnSize=new Dimension(200, left.getHeight());
		
		
		
		left.add(millerGlobal,BorderLayout.CENTER);
		left.add(setBottMenu(colSubContainer), BorderLayout.SOUTH);
		
		this.add(left, BorderLayout.CENTER);
	}
	
	private void setDescrPane()
	{
		JPanel right = new JPanel(new BorderLayout());
		right.setPreferredSize(new Dimension(currentFrame.getWidth()/4,currentFrame.getHeight()));
		right.setBackground(Color.RED);
		this.thisPane.add(right, BorderLayout.EAST);
	}
	

	private JPanel setBottMenu(final JPanel colSubCont)
	{
		JPanel global= new JPanel();
		
		JPanel addColPane= new PanelCenteredButton("Add Column", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				colSubCont.add(new PanelColumn(columnSize));
				colSubCont.revalidate();
			}
			
		});
		
		JPanel removeColPane= new PanelCenteredButton("Remove Column", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				colSubCont.removeAll();
				colSubCont.revalidate();
			}
			
		});
		
		global.setLayout(new FlowLayout());
		
		global.add(addColPane);
		global.add(removeColPane);
		
		return global;
	}
}
