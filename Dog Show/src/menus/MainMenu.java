package menus;

import javax.swing.JFrame;

import core.Status;
import graphics.Renderer;
import listeners.GraphicsListener;
import popups.Login;

public class MainMenu implements GraphicsListener
{
	private final Renderer renderer;
	
	public MainMenu(Renderer renderer)
	{
		this.renderer = renderer;
		checkStatus();
	}
	
	private void checkStatus()
	{
		if(Status.loggedIn == false)
		{
			Login login = new Login(renderer);
		}
	}

	@Override
	public void graphicsCall(JFrame jFrame)
	{
		// TODO Auto-generated method stub
		
	}
}
