package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import graphics.Renderer;

public class ScoringPage extends Menu 
{
	private int buttonWidth = 300;
	private int buttonHeight = 80;
	

	public ScoringPage(Renderer renderer) 
	{
		super(renderer);
		renderer.setBackground("src/images/shibeDoingARealCookWhileWearingAnApronOnTwoLegs.jpg");
		addComponents();
	}

	@Override
	protected void addComponents()
	{
		
		JLabel ScoringPagePageLabel = new JLabel("ScoringPageLabel", SwingConstants.CENTER);
		//registerPageLabel.setSize(400, 100);
		ScoringPagePageLabel.setBounds((renderer.getWidth()/4), ((renderer.getHeight()/10)), ((renderer.getWidth()/2)), (renderer.getHeight()/8));
		ScoringPagePageLabel.setFont(new Font("Helvetica", Font.BOLD, 32));
		ScoringPagePageLabel.setText("Scoring Page");
		ScoringPagePageLabel.setForeground(Color.BLUE);
		ScoringPagePageLabel.setBackground(Color.YELLOW);
		ScoringPagePageLabel.setOpaque(false);
		components.add(ScoringPagePageLabel);
		
		String[] competitionNames = new String[]
		{
				"Being Cute", "Being Small", "Attacking innocents"
		};
		
		JComboBox<String> competitionList = new JComboBox<>(competitionNames);
		competitionList.setLocation((renderer.getWidth()/3+75), ((renderer.getHeight()/4)));
		competitionList.setSize(200, 30);
		//competitionList.setBounds((renderer.getWidth()/8), ((renderer.getHeight()/6)), ((renderer.getWidth()/4)), (renderer.getHeight()/8));
		competitionList.setName("Competitions");
		components.add(competitionList);
		
		
		
		
		
		
		
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
		//fieldPanel.setVisible(true);
		//components.add(fieldPanel);
		
		renderer.addComponents(components);
		

	}

}
