package graphics;

import java.awt.Canvas;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import listeners.GraphicsListener;

public final class Renderer extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private Canvas canvas;
	
	private ArrayList<GraphicsListener> graphicsListeners = new ArrayList<>();
	
	public Renderer()
	{
		//Initial JFrame setup
		super("Dog Show Admin Tool");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setIgnoreRepaint(false);
		super.setMinimumSize(new Dimension(640, 480));
		
		//Initial Canvas setup
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(1000, 800));
		
		//Final setup
		super.add(canvas);
		super.pack();
		canvas.createBufferStrategy(2);
		super.setVisible(true);
	}

	public void addGraphicsListener(GraphicsListener listener)
	{
		if(graphicsListeners.contains(listener) == false)
		{
			graphicsListeners.add(listener);
			System.out.println("Added listener " + listener.toString() + " to graphic call list.");
		}
		else
		{
			System.err.println("Listener " + listener.toString() + " already exists in the graphics call list.");
		}
	}
	
	public void removeGraphicsListener(GraphicsListener listener)
	{
		if(graphicsListeners.contains(listener) == true)
		{
			graphicsListeners.remove(listener);
			System.out.println("Listener " + listener.toString() + " was removed from graphics call list.");
		}
		else
		{
			System.err.println("Listener " + listener.toString() + " does not exists in the graphics call list.");
		}
	}
	
	public void makeGraphicsCalls()
	{
		for(GraphicsListener listener : graphicsListeners)
		{
			listener.graphicsCall(this);
		}
	}
}
