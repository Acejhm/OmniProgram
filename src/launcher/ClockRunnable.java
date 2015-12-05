package launcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.Timer;

import javax.swing.JLabel;

/**
 * @author Jackson Murrell on Nov 26, 2015
 */
public class ClockRunnable implements Runnable
{
	private JLabel clock;
	private Calendar calendar;
	private Timer timer;
	boolean running = true;
	
	public ClockRunnable(JLabel clock)
	{
		this.clock = clock;
		timer = new Timer(500, new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						calendar = calendar.getInstance();
						clock.setText("" + calendar.getTime());
						clock.repaint();
					}
				});
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		while(!Thread.currentThread().isInterrupted())
			timer.start();
	}
}
