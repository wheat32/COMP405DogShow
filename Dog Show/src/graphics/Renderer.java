package graphics;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import listeners.GraphicsListener;

public final class Renderer extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private Canvas canvas;
	
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
	
	public void makeGraphicsCalls(GraphicsListener listener)
	{
		listener.graphicsCall(this);
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
}
