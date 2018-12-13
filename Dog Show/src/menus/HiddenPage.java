package menus;

import graphics.Renderer;

public class HiddenPage extends Menu 
{

	public HiddenPage(Renderer renderer) 
	{
		super(renderer);
		renderer.setBackground("src/images/hidden.jpg");
		addComponents();
	}

	@Override
	protected void addComponents()
	{
		
	}

}
