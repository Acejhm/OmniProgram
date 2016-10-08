package applications.menus;

import java.awt.event.ActionEvent;
import javax.swing.*;

import applications.calculator.FormulaCalculator;
import utility.BaseMenu;

/**
 * @author Jackson Murrell on Jul 12, 2016
 */
public class FormulaMenu extends BaseMenu
{
	FormulaCalculator parent;
	JMenu formulas, conversions;
	JMenuItem arclength, summations;
	
	public FormulaMenu(FormulaCalculator parent)
	{
		super(parent);
		this.parent = parent;
		formulas = new JMenu("Formulas");
		conversions = new JMenu("Conversions");
		arclength = new JMenuItem("Arc Length");
		
		summations = new JMenuItem("Summations");
		
		formulas.add(summations);
		formulas.addSeparator();
		formulas.add(arclength);
		
		add(new JSeparator(JSeparator.VERTICAL));
		add(conversions);
		add(formulas);
	}
	@Override
	public void customActions(ActionEvent event)
	{
		if(event.getSource() == arclength)
		{
			parent.arclength();
		}
		else if(event.getSource() == summations)
		{
			parent.summations();
		}
	}
}
