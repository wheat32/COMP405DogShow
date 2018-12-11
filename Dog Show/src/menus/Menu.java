package menus;

import java.awt.Component;
import java.util.ArrayList;

import graphics.Renderer;

public abstract class Menu
{
	protected final Renderer renderer;
	protected ArrayList<Component> components = new ArrayList<>();
	
	public Menu(Renderer renderer)
	{
		this.renderer = renderer;
	}
	
	protected abstract void addComponents();
	
	public ArrayList<Component> getComponents()
	{
		return components;
	}
}
