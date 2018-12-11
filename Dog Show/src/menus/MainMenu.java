package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
		addComponents();
		super.startTimer(100);
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
	protected void addComponents()
	{
		JLabel mainMenuLabel = new JLabel("MainMenuLabel", SwingConstants.CENTER);
		mainMenuLabel.setBounds(renderer.getWidth()/2-buttonWidth/2, renderer.getHeight()/8*2-buttonHeight/2, buttonWidth, buttonHeight);
		mainMenuLabel.setFont(new Font("Helvetica", Font.BOLD, 32));
		mainMenuLabel.setText("Main Menu");
		components.add(mainMenuLabel);
		
		JButton registerBtn = new JButton("Register");
		registerBtn.setBounds(renderer.getWidth()/2-buttonWidth/2, renderer.getHeight()/8*4-buttonHeight/2, buttonWidth, buttonHeight);
		registerBtn.setFont(new Font("Helvetica", Font.BOLD, 32));
		registerBtn.setText("Register");
		registerBtn.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				stopTimer();
				renderer.setMenu(new RegisterPage(renderer, "images/cutie.jpeg"));
			}
		});
		components.add(registerBtn);
		
		JButton scoringBtn = new JButton("Scoring");
		scoringBtn.setBounds(renderer.getWidth()/2-buttonWidth/2, renderer.getHeight()/8*5-buttonHeight/2, buttonWidth, buttonHeight);
		scoringBtn.setFont(new Font("Helvetica", Font.BOLD, 32));
		scoringBtn.setText("Scoring");
		scoringBtn.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				stopTimer();
				renderer.setMenu(new ScoringPage(renderer, "images/cutie.jpeg"));
				
			}
		});
		components.add(scoringBtn);
		
		JButton reviewScoresBtn = new JButton("ReviewScores");
		reviewScoresBtn.setBounds(renderer.getWidth()/2-buttonWidth/2, renderer.getHeight()/8*6-buttonHeight/2, buttonWidth, buttonHeight);
		reviewScoresBtn.setFont(new Font("Helvetica", Font.BOLD, 32));
		reviewScoresBtn.setText("Review Scores");
		components.add(reviewScoresBtn);
		
		JButton quitBtn = new JButton("QuitBtn");
		quitBtn.setBounds(renderer.getWidth()/2-buttonWidth/2, renderer.getHeight()/8*7-buttonHeight/2, buttonWidth, buttonHeight);
		quitBtn.setFont(new Font("Helvetica", Font.BOLD, 32));
		quitBtn.setText("Quit");
		quitBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				stopTimer();
				renderer.dispose();
			}
		});
		components.add(quitBtn);
		
		renderer.addComponents(components);
	}
}
