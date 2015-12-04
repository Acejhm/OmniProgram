package launcher;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author Jackson Murrell onClock Nov 7, 2015
 */
public class Menu extends JMenuBar implements ActionListener
{
	private static final String MOTIF_LOOK_AND_FEEL = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	private static final String GTK_LOOK_AND_FEEL = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
	private static final String NIMBUS_LOOK_AND_FEEL = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
	
	private LauncherGUI launcherGUI;
	private ButtonGroup group;
	private JMenuItem exit, onClock, offClock, onLabel, offLabel;
	
	private JMenu file, settings, appearance, widgets, clock, text;
	private JRadioButtonMenuItem javaDefault, systemDefault, motif, gtk, nimbus;
	
	public Menu(LauncherGUI gui, boolean widgetOn)
	{
		launcherGUI = gui;
		group = new ButtonGroup();
		
		exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		onClock = new JMenuItem("On");
		onClock.addActionListener(this);
		offClock = new JMenuItem("Off");
		offClock.addActionListener(this);
		onLabel = new JMenuItem("On");
		onLabel.addActionListener(this);
		offLabel = new JMenuItem("Off");
		offLabel.addActionListener(this);
		
		if(widgetOn)
		{
			onClock.setEnabled(false);
			offClock.setEnabled(true);
			onLabel.setEnabled(false);
			offLabel.setEnabled(true);
		}
		else
		{
			offClock.setEnabled(true);
			onClock.setEnabled(false);
			onLabel.setEnabled(true);
			offLabel.setEnabled(false);
		}
		appearance = new JMenu("Appearance");
		file = new JMenu("File");
		settings= new JMenu("Settings");
		widgets = new JMenu("Widgets");
		clock = new JMenu("Clock");
		text = new JMenu("Text");
		
		javaDefault = new JRadioButtonMenuItem("Java Default (\"Metal\")");
		javaDefault.setSelected(true);
		systemDefault = new JRadioButtonMenuItem("System Default (\"" + System.getProperty("os.name") + "\")");
		motif = new JRadioButtonMenuItem("Motif");
		gtk = new JRadioButtonMenuItem("GTK+");
		nimbus = new JRadioButtonMenuItem("Nimbus");
		
		group.add(javaDefault);
		group.add(systemDefault);
		group.add(gtk);
		group.add(motif);
		group.add(nimbus);
		
		javaDefault.addActionListener(this);
		systemDefault.addActionListener(this);;
		motif.addActionListener(this);
		gtk.addActionListener(this);
		nimbus.addActionListener(this);
		
		appearance.add(javaDefault);
		appearance.add(systemDefault);
		appearance.addSeparator();
		appearance.add(gtk);
		appearance.add(motif);
		appearance.add(nimbus);
		
		widgets.add(clock);
		widgets.add(text);
		text.add(onLabel);
		text.add(offLabel);
		clock.add(onClock);
		clock.add(offClock);
		file.add(exit);
		settings.add(appearance);
		settings.add(widgets);
		
		add(file);
		add(settings);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent action)
	{
		if(action.getSource() == javaDefault)
		{
			try 
			{
		        UIManager.setLookAndFeel(
		        		UIManager.getCrossPlatformLookAndFeelClassName());
		        SwingUtilities.updateComponentTreeUI(launcherGUI);
		        launcherGUI.repaint();
		    } 
		    catch (UnsupportedLookAndFeelException e) 
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" is not supported for your operating system.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
		    	e.printStackTrace();
		    } catch (ClassNotFoundException e)
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" was not found in the Java Library.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (InstantiationException e)
			{
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		else if(action.getSource() == systemDefault)
		{
			try 
			{
		        UIManager.setLookAndFeel(
		        		UIManager.getSystemLookAndFeelClassName());
		        SwingUtilities.updateComponentTreeUI(launcherGUI);
		        launcherGUI.repaint();
		    } 
		    catch (UnsupportedLookAndFeelException e) 
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" is not supported for your operating system.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
		    	e.printStackTrace();
		    } catch (ClassNotFoundException e)
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" was not found in the Java Library.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (InstantiationException e)
			{
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		else if(action.getSource() == motif)
		{
			try 
			{
		        UIManager.setLookAndFeel(MOTIF_LOOK_AND_FEEL);
		        SwingUtilities.updateComponentTreeUI(launcherGUI);
		        launcherGUI.repaint();
		    } 
		    catch (UnsupportedLookAndFeelException e) 
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" is not supported for your operating system.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
		    	e.printStackTrace();
		    } catch (ClassNotFoundException e)
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" was not found in the Java Library.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (InstantiationException e)
			{
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		else if(action.getSource() == gtk)
		{
			try 
			{
		        UIManager.setLookAndFeel(GTK_LOOK_AND_FEEL);
		        SwingUtilities.updateComponentTreeUI(launcherGUI);
		        launcherGUI.repaint();
		    } 
		    catch (UnsupportedLookAndFeelException e) 
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" is not supported for your operating system.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
		    	e.printStackTrace();
		    } catch (ClassNotFoundException e)
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" was not found in the Java Library.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (InstantiationException e)
			{
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		else if(action.getSource() == nimbus)
		{
			try 
			{
		        UIManager.setLookAndFeel(NIMBUS_LOOK_AND_FEEL);
		        SwingUtilities.updateComponentTreeUI(launcherGUI);
		        launcherGUI.repaint();
		    } 
		    catch (UnsupportedLookAndFeelException e) 
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" is not supported for your operating system.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
		    	e.printStackTrace();
		    } catch (ClassNotFoundException e)
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" was not found in the Java Library.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (InstantiationException e)
			{
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		else if(action.getSource() == exit)
		{
			byte option = (byte)JOptionPane.showConfirmDialog(this, "Exit all programs?", "Exit Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
			
			if(option == JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
			else if(option == JOptionPane.NO_OPTION)
			{
				launcherGUI.dispose();
			}
		}
		else if(action.getSource() == onClock)
		{
			launcherGUI.addClock();
			onClock.setEnabled(false);
			offClock.setEnabled(true);
		}
		else if(action.getSource() == offClock)
		{
			launcherGUI.removeClock();
			offClock.setEnabled(false);
			onClock.setEnabled(true);
		}
		else if(action.getSource() == onLabel)
		{
			launcherGUI.addLabel();
			offLabel.setEnabled(false);
			onLabel.setEnabled(true);
		}
		else if(action.getSource() == offLabel)
		{
			launcherGUI.removeLabel();
			offLabel.setEnabled(false);
			onLabel.setEnabled(true);
		}
	}
}