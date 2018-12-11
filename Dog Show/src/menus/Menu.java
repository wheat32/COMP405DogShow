package menus;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import graphics.Renderer;

public abstract class Menu
{
	protected final Renderer renderer;
	private Image background;
	private Timer timer = new Timer();
	protected ArrayList<Component> components = new ArrayList<>();
	
	public Menu(Renderer renderer, String addr)
	{
		this.renderer = renderer;
		
		try
		{
			URL url = this.getClass().getClassLoader().getResource(addr);
			if(url == null)
			{
				System.err.println("Image not found.");
			}
			background = ImageIO.read(url);
		}
		catch(IOException e)
		{
			System.err.println("Failed to load sprite.");
		}
	}
	
	public void startTimer(int delay)
	{
		timer.schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				graphicsCall();
			}
		}, 0, delay);
	}
	
	public void stopTimer()
	{
		timer.cancel();
	}
	
	public void graphicsCall()
	{
		BufferStrategy strategy = renderer.getCanvas().getBufferStrategy();
		Graphics gfx = strategy.getDrawGraphics();

		gfx.setColor(Color.BLACK);
		gfx.setFont(new Font("Helvetica", Font.BOLD, 32));
		gfx.clearRect(0, 0, renderer.getWidth(), renderer.getHeight());
		gfx.drawImage(background, 0, 0, renderer.getCanvas().getWidth(), renderer.getCanvas().getHeight(), 
				0, 0, background.getWidth(null), background.getHeight(null), null);
		
		strategy.show();
		gfx.dispose();
	}
	
	protected abstract void addComponents();
	
	public ArrayList<Component> getComponents()
	{
		return components;
	}
}
