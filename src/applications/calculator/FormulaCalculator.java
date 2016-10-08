package applications.calculator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import applications.menus.FormulaMenu;

/**
 * @author Jackson Murrell on Jul 12, 2016
 */
public class FormulaCalculator extends JFrame implements ActionListener
{
	private static final short	WINDOW_LENGTH	= 400;
	private static final short	WINDOW_WIDTH	= 1200;
	private static final String	TITLE			= "Formula Calculator";
	private static final String DEFAULT_LABEL = "Summations";
	private static final FormulaPanelTemplate DEFAULT_PANEL = new Summations();
	
	private JLabel formulaLabel, answerLabel;
	private JPanel mainPanel, buttonPanel;
	private FormulaPanelTemplate formulaPanel;
	private JButton calculate, exit;
	
	public FormulaCalculator()
	{
		super(TITLE);
		setLocationRelativeTo(null);
		setSize(WINDOW_WIDTH, WINDOW_LENGTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		formulaPanel = DEFAULT_PANEL;
		
		answerLabel = new JLabel("Answer: ");
		formulaLabel = new JLabel(DEFAULT_LABEL);
		
		calculate = new JButton("Calculate");
		calculate.addActionListener(this);
		
		exit = new JButton("Exit");
		exit.addActionListener(this);
		
		buttonPanel.add(calculate);
		buttonPanel.add(exit);
		
		mainPanel.add(formulaLabel);
		mainPanel.add(formulaPanel);
		mainPanel.add(answerLabel);
		mainPanel.add(buttonPanel);
		mainPanel.setLayout(new GridLayout(4,1));
		
		add(mainPanel);
		
		setJMenuBar(new FormulaMenu(this));
		
		setVisible(true);
	}
	/**
	 * 
	 * @return void
	 */
	public void arclength()
	{
		
	}
	/**
	 * 
	 * @return void
	 */
	public void summations()
	{
		formulaPanel = new Summations();
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent action)
	{
		if(action.getSource() == calculate)
		{
			answerLabel.setText("Asnwer: " + formulaPanel.calculate());
		}
		else if(action.getSource() == exit)
		{
			this.dispose();
		}
		
	}
}
