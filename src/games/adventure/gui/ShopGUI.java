package games.adventure.gui;

import javax.swing.JFrame;

/**
 * @author Jackson Murrell on Nov 22, 2015
 */
public class ShopGUI extends JFrame
{
	private static final short	WINDOW_LENGTH	= 400;
	private static final short	WINDOW_WIDTH	= 400;
	private static final String	TITLE			= "";

	public ShopGUI()
	{
		super(TITLE);
		setLocationRelativeTo(null);
		setSize(WINDOW_WIDTH, WINDOW_LENGTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setVisible(true);
	}
}
