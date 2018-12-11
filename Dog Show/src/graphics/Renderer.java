package graphics;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import menus.Menu;

public final class Renderer extends JFrame implements Cloneable
{
	private static final long serialVersionUID = 1L;
	
	private Canvas canvas;
	private Menu currMenu;
	
	public Renderer()
	{
		//Initial JFrame setup
		super("Dog Show Admin Tool");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setIgnoreRepaint(true);
		super.setResizable(false);
		
		//Initial Canvas setup
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(1000, 800));
		
		//Final setup
		super.add(canvas);
		super.pack();
		canvas.createBufferStrategy(2);
		super.setVisible(true);
	}
	
	public void addComponents(ArrayList<Component> components)
	{
		for(Component component : components)
		{
			super.add(component);
			component.repaint();
		}
		
		super.add(canvas);
		super.pack();
		canvas.createBufferStrategy(2);
		super.revalidate();
		super.repaint();
	}
	
	public void setMenu(Menu menu)
	{
		if(currMenu != null)
		{
			for(Component component : currMenu.getComponents())
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
	
	public Canvas getCanvas()
	{
		return canvas;
	}
}
