package graphics;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import menus.Menu;

public final class Renderer extends JFrame implements Cloneable
{
	private static final long serialVersionUID = 1L;

	private Menu currMenu;
	private JLabel background;
	private int width = 1000;
	private int height = 800;

	public Renderer()
	{
		// Initial JFrame setup
		super("Dog Show Admin Tool");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setIgnoreRepaint(true);
		super.setResizable(false);

		super.pack();
		super.setSize(width, height);
		super.setLocationRelativeTo(null);
		super.setVisible(true);
		super.repaint();
	}

	public void addComponents(ArrayList<Component> components)
	{
		for (Component component : components)
		{
			super.add(component);
			component.repaint();
		}

		super.revalidate();
		super.repaint();
	}

	public void setMenu(Menu menu)
	{
		if (currMenu != null)
		{
			for (Component component : currMenu.getComponents())
			{
				super.remove(component);
			}
		}

		currMenu = menu;
		super.revalidate();
		super.repaint();
	}

	public Menu getCurrMenu()
	{
		return currMenu;
	}
	
	public void setBackground(String addr)
	{
		// Load the background image
		Image img = null;
		try
		{
			img = ImageIO.read(new File(addr));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(img, 0, 0, width, height, null);
	    g2.dispose();
		
		background = new JLabel(new ImageIcon(resizedImg));
		background.setSize(width, height);
		super.setContentPane(background);
	}
}
