package applications.calculator;

import javax.swing.JPanel;

/**
 * @author Jackson Murrell on Jul 16, 2016
 */
public class FormulaPanelTemplate extends JPanel
{
	private static final long serialVersionUID = -4482532282464952713L;

	public FormulaPanelTemplate()
	{
		setVisible(true);
	}
	/**
	 * This should be overwritten by the child class.
	 * @return double
	 */
	public double calculate()
	{
		return 0;
	}
}
