package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import core.Renderer;

public class ReviewScorePage extends Menu 
{
	private int buttonWidth = 300;
	private int buttonHeight = 80;

	public ReviewScorePage(Renderer renderer) 
	{
		super(renderer);
		renderer.setBackground("src/images/simplename.jpg");
		addComponents();
	}

	@Override
	protected void addComponents()
	{
		JLabel reviewPageLabel = new JLabel("ReviewPageLabel", SwingConstants.CENTER);
		reviewPageLabel.setBounds(0, renderer.getHeight()/16-buttonHeight/2, renderer.getWidth(), buttonHeight);
		reviewPageLabel.setFont(new Font("Helvetica", Font.BOLD, 64));
		reviewPageLabel.setText("Review Page");
		reviewPageLabel.setForeground(Color.BLACK);
		reviewPageLabel.setOpaque(true);
		reviewPageLabel.setBackground(new Color(1, 1, 1, 0.5f));
		components.add(reviewPageLabel);
		
		JButton showDogBtn = new JButton("Show List of Dogs");
		showDogBtn.setBounds(renderer.getWidth()/8*6-buttonWidth/2, renderer.getHeight()/8*4, buttonWidth, buttonHeight);
		showDogBtn.setFont(new Font("Helvetica", Font.BOLD, 20));
		showDogBtn.setText("Show Dogs");
		components.add(showDogBtn);
		showDogBtn.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//TODO show list of dogs 
			}
		});
		
		JButton showCompBtn = new JButton("Show List of Comp.");
		showCompBtn.setBounds(renderer.getWidth()/8*6-buttonWidth/2, renderer.getHeight()/8*5, buttonWidth, buttonHeight);
		showCompBtn.setFont(new Font("Helvetica", Font.BOLD, 20));
		showCompBtn.setText("Show Competitions");
		components.add(showCompBtn);
		showCompBtn.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				renderer.setMenu(new CompetitionPage(renderer));
			}
		});
		
		JButton hiddenBtn = new JButton("Hidden Page");
		hiddenBtn.setBounds(0, 20, buttonHeight/14, buttonHeight/14);
		hiddenBtn.setFont(new Font("Helvetica", Font.BOLD, 20));
		hiddenBtn.setText("Hidden Page");
		hiddenBtn.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				renderer.setMenu(new HiddenPage(renderer));
			}
		});
		components.add(hiddenBtn);
		
		JButton quitBtn = new JButton("MainMenuBtn"); //TODO maybe set this to go back to main menu 
		quitBtn.setBounds(renderer.getWidth()/2-buttonWidth/2, renderer.getHeight()/8*7-buttonHeight/2, buttonWidth, buttonHeight);
		quitBtn.setFont(new Font("Helvetica", Font.BOLD, 32));
		quitBtn.setText("Main Menu");
		quitBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				renderer.setMenu(new MainMenu(renderer));
			}
		});
		components.add(quitBtn);
		
		renderer.addComponents(components);
	}

}
