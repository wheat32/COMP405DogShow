package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JButton;

import core.Status;
import graphics.Renderer;
import popups.Login;

public class MainMenu extends Menu
{	
	private int buttonWidth = 300;
	private int buttonHeight = 80;
	
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
		JButton registerBtn = new JButton("Register");
		registerBtn.setBounds(renderer.getWidth()/2-buttonWidth/2, renderer.getHeight()/8*4-buttonHeight/2, buttonWidth, buttonHeight);
		registerBtn.setFont(new Font("Helvetica", Font.BOLD, 32));
		registerBtn.setText("Register");
		renderer.addComponent(registerBtn);
		
		JButton scoringBtn = new JButton("Scoring");
		scoringBtn.setBounds(renderer.getWidth()/2-buttonWidth/2, renderer.getHeight()/8*5-buttonHeight/2, buttonWidth, buttonHeight);
		scoringBtn.setFont(new Font("Helvetica", Font.BOLD, 32));
		scoringBtn.setText("Scoring");
		renderer.addComponent(scoringBtn);
		
		JButton reviewScoresBtn = new JButton("ReviewScores");
		reviewScoresBtn.setBounds(renderer.getWidth()/2-buttonWidth/2, renderer.getHeight()/8*6-buttonHeight/2, buttonWidth, buttonHeight);
		reviewScoresBtn.setFont(new Font("Helvetica", Font.BOLD, 32));
		reviewScoresBtn.setText("Review Scores");
		renderer.addComponent(reviewScoresBtn);
		
		JButton quitBtn = new JButton("QuitBtn");
		quitBtn.setBounds(renderer.getWidth()/2-buttonWidth/2, renderer.getHeight()/8*7-buttonHeight/2, buttonWidth, buttonHeight);
		quitBtn.setFont(new Font("Helvetica", Font.BOLD, 32));
		quitBtn.setText("Quit");
		quitBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				renderer.dispose();
			}
		});
		renderer.addComponent(quitBtn);
	}
}
