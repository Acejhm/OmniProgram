package applications.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import utility.MathExtended;

/**
 * @author Jackson Murrell on Jul 16, 2016
 */
public class Summations extends FormulaPanelTemplate implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private static final byte TEXT_COLUMNS = 5;
	
	JTextField startPoint, endPoint, function, interval;
	JLabel startPointLabel, endPointLabel, functionLabel, intervalLabel, errorLabel;
	JRadioButton left, right, midpoint, trapezoid, simpsons;
	JCheckBox errorChecking;
	JPanel selectionPanel, inputPanel;
	ButtonGroup group;

	public Summations()
	{
		selectionPanel = new JPanel();
		inputPanel = new JPanel();
		
		startPoint = new JTextField(TEXT_COLUMNS);
		endPoint = new JTextField(TEXT_COLUMNS);
		function = new JTextField(TEXT_COLUMNS);
		interval = new JTextField(TEXT_COLUMNS);
		
		errorChecking = new JCheckBox("Find Error?");
		
		left = new JRadioButton("Left Riemann Summation");
		left.addActionListener(this);
		
		right = new JRadioButton("Right Riemann Summation");
		right.addActionListener(this);
		
		midpoint = new JRadioButton("Midpoint Riemann Summation");
		midpoint.addActionListener(this);
		
		trapezoid = new JRadioButton("Trapezoid Summation");
		trapezoid.addActionListener(this);
		
		simpsons = new JRadioButton("Simpson's Summation");
		simpsons.addActionListener(this);
		
		group = new ButtonGroup();
		group.add(left);
		group.add(midpoint);
		group.add(right);
		group.add(simpsons);
		group.add(trapezoid);
		
		startPointLabel = new JLabel("Start Point (a):");
		endPointLabel = new JLabel("End Point (b):");
		functionLabel = new JLabel("Function with x as the variable:");
		intervalLabel = new JLabel("Number of Intervals (n):");
		errorLabel = new JLabel("Theoretical Error:");
		
		selectionPanel.add(left);
		selectionPanel.add(midpoint);
		selectionPanel.add(right);
		selectionPanel.add(simpsons);
		selectionPanel.add(trapezoid);
		selectionPanel.add(errorChecking);
		
		inputPanel.add(startPointLabel);
		inputPanel.add(startPoint);
		inputPanel.add(endPointLabel);
		inputPanel.add(endPoint);
		inputPanel.add(functionLabel);
		inputPanel.add(function);
		inputPanel.add(intervalLabel);
		inputPanel.add(interval);
			
		add(selectionPanel);
		add(inputPanel);
		add(errorLabel);
	}
	@Override
	public double calculate()
	{
		double answer = 0;
		try
		{
			String formula = function.getText();
			double a = Double.parseDouble(startPoint.getText());
			double b = Double.parseDouble(endPoint.getText());
			int n = Integer.parseInt(interval.getText());
			
			MathExtended.setEquation(formula);
			
			if(left.isSelected())
				answer = MathExtended.leftRiemannSum(a,b,n);
			else if(right.isSelected())
				answer = MathExtended.rightRiemannSum(a, b, n);
			else if(midpoint.isSelected())
				answer = MathExtended.midPointRiemannSum(a, b, n);
			else if(trapezoid.isSelected())
			{
				answer = MathExtended.trapezoidSum(a, b, n);
				//if(errorChecking.isSelected())
					//errorLabel.setText("Theoretical Error: " + MathExtended.trapezoidErrorCheck(a,b,n, formula));
			}
			else if(simpsons.isSelected())
			{
				answer = MathExtended.simpsonsSum(a, b, n);
				//if(errorChecking.isSelected())
					//errorLabel.setText("Theoretical Error: " + MathExtended.simpsonsErrorCheck(a,b,n));
			}
		}
		catch(NumberFormatException exception)
		{
			JOptionPane.showMessageDialog(null, "One of your inputs was not valid.  Please make sure,\n" + 
										"if you are using Simpson's Method, that the interval countis even.", 
										"Input Error", JOptionPane.ERROR_MESSAGE);
		}
		return answer;
		
		
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}
