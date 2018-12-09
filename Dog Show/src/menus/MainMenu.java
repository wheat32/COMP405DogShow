package menus;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import core.Status;
import graphics.Renderer;
import listeners.GraphicsListener;
import popups.Login;

public class MainMenu implements GraphicsListener
{
	private final Renderer renderer;
	private Image dog = null;
	
	public MainMenu(Renderer renderer)
	{
		this.renderer = renderer;
		
		try
		{
			URL url = this.getClass().getClassLoader().getResource("images/dogDoingWorkOnControlSticksWhichAreRedAndRound.jpg");
			if(url == null)
			{
				System.err.println("Image not found.");
			}
			dog = ImageIO.read(url);
		}
		catch(IOException e)
		{
			System.err.println("Failed to load sprite.");
		}
		
		checkStatus();
		addButtons();
		renderer.makeGraphicsCalls(this);
	}
	
	private void checkStatus()
	{
		if(Status.loggedIn == false && false)
		{	
			Runnable runnable = new Runnable()
			{
				
				@Override
				public void run()
				{
					new Login(renderer);
				}
			};
			Thread thread = new Thread(runnable);
			thread.start();
		}
	}
	
	private void addButtons()
	{
		JButton button = new JButton("Register");
		button.setBounds(0, 0, 400, 320);
		button.setText("test");
		renderer.addComponent(button);
	}

	@Override
	public void graphicsCall(Renderer renderer)
	{
		int i = 0;
		while(i++ < 13)
		{
			BufferStrategy strategy = renderer.getCanvas().getBufferStrategy();
			Graphics2D gfx = (Graphics2D) strategy.getDrawGraphics();
			
			gfx.clearRect(0, 0, renderer.getWidth(), renderer.getHeight());
			
			gfx.drawImage(dog, 0, 0, renderer.getCanvas().getWidth(), renderer.getCanvas().getHeight(), 
					0, 0, dog.getWidth(null), dog.getHeight(null), null);
			
			gfx.dispose();
			strategy.show();
		}
	}
}
