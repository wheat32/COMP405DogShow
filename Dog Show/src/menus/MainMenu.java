package menus;

import javax.swing.JButton;

import core.Status;
import graphics.Renderer;
import popups.Login;

public class MainMenu extends Menu
{	
	public MainMenu(Renderer renderer)
	{
		super(renderer, "images/dogDoingWorkOnControlSticksWhichAreRedAndRound.jpg");
		
		checkStatus();
		addButtons();
		super.startTimer(50);
	}
	
	private void checkStatus()
	{
		if(Status.loggedIn == false)
		{	
			Thread thread = new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					new Login(renderer);
				}
			});
			thread.start();
		}
	}
	
	@Override
	protected void addButtons()
	{
		JButton button = new JButton("Register");
		button.setBounds(0, 0, 400, 320);
		button.setText("test");
		renderer.addComponent(button);
	}
}
