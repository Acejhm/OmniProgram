package utility;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import launcher.LauncherGUI;

/**
 * @author Jackson Murrell on May 11, 2016
 */
@SuppressWarnings("serial")
public class BaseMenu extends JMenuBar implements ActionListener
{
	protected static final String MOTIF_LOOK_AND_FEEL = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	protected static final String GTK_LOOK_AND_FEEL = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
	protected static final String NIMBUS_LOOK_AND_FEEL = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
	
	protected JFrame parentFrame;
	protected ButtonGroup group;
	protected JMenuItem exit, info;
	
	protected JMenu file, settings, appearance, help;
	protected JRadioButtonMenuItem javaDefault, systemDefault, motif, gtk, nimbus;
	
	public BaseMenu(JFrame frame)
	{
		this.parentFrame = frame;
		group = new ButtonGroup();
		
		exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		
		info = new JMenuItem("Info");
		info.addActionListener(this);
		
		help = new JMenu("Help");
		help.addActionListener(this);
		
		appearance = new JMenu("Appearance");
		file = new JMenu("File");
		settings= new JMenu("Settings");
		
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
		
		file.add(exit);
		settings.add(appearance);
		help.add(info);
		
		add(file);
		add(settings);
		add(help);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent action)
	{
		System.out.println("Inside baseMenu ActionListener");
		if(action.getSource() == javaDefault)
		{
			try 
			{
		        UIManager.setLookAndFeel(
		        		UIManager.getCrossPlatformLookAndFeelClassName());
		        SwingUtilities.updateComponentTreeUI(parentFrame);
		        parentFrame.repaint();
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
		        SwingUtilities.updateComponentTreeUI(parentFrame);
		        parentFrame.repaint();
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
		        SwingUtilities.updateComponentTreeUI(parentFrame);
		        parentFrame.repaint();
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
		        SwingUtilities.updateComponentTreeUI(parentFrame);
		        parentFrame.repaint();
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
		        SwingUtilities.updateComponentTreeUI(parentFrame);
		        parentFrame.repaint();
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
				parentFrame.dispose();
			}
		}
		else if(action.getSource() == info)
		{
			showHelpMenu();
		}
		else
			//Call any sub-class actions.
			customActions(action);
	}
	/**
	 * Child menu's should override this to add class-specific implementation.
	 * @return void
	 */
	public void showHelpMenu()
	{
		JOptionPane.showMessageDialog(parentFrame, "Default help message.\nJava version: " + System.getProperty("java.version"));
	}
	/**
	 * Child menu's should override this to add class-specific implementation.
	 * @return void
	 */
	public void customActions(ActionEvent action)
	{}
}