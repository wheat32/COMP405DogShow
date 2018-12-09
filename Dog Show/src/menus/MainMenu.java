package menus;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

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

	@Override
	public void graphicsCall(Renderer renderer)
	{
		BufferStrategy strategy = renderer.getCanvas().getBufferStrategy();
		Graphics2D gfx = (Graphics2D) strategy.getDrawGraphics();
		
		gfx.clearRect(0, 0, renderer.getWidth(), renderer.getHeight());
		
		gfx.drawImage(dog, 0, 0, renderer.getCanvas().getWidth(), renderer.getCanvas().getHeight(), 
				0, 0, dog.getWidth(null), dog.getHeight(null), null);
		
		JPanel buttonPanel = new JPanel();
		JButton registerPageBtn = new JButton("heck");
		registerPageBtn.setBounds(20, 20, 200, 60);
		registerPageBtn.setLocation(200, 200);
		registerPageBtn.setVerticalTextPosition(AbstractButton.CENTER);
		registerPageBtn.setHorizontalTextPosition(AbstractButton.LEADING);
		registerPageBtn.setText("fuck");
		renderer.add(registerPageBtn);
		registerPageBtn.setVisible(true);
		//registerPageBtn.paint(gfx);
		buttonPanel.setVisible(true);
		renderer.add(buttonPanel);
		
		gfx.dispose();
		strategy.show();
	}
}
