package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import graphics.Renderer;

public class ScoringPage extends Menu 
{
	private int buttonWidth = 300;
	private int buttonHeight = 50;
	

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
		
		String[] competitionNames = new String[]   //select competitoon, select dog, submit scores
		{
				"Select Competiton","Being Cute", "Being Small", "Attacking innocents"
		};
		
		String[] dogChoice = new String[]
		{
				"Select Dog", "Dog1", "Dog2", "Dog3", "Dog4", "Dog5"		
		};
		
		String[] dogScore = new String[]
		{
			"Select Score", "1" , "2", "3" , "4", "5"			
		};
		
		JComboBox<String> competitionList = new JComboBox<>(competitionNames);
		competitionList.setLocation((renderer.getWidth()/3+75), ((renderer.getHeight()/4)));
		competitionList.setSize(200, 30);
		competitionList.setName("Competitions");
		components.add(competitionList);
		
		JComboBox<String> dogList = new JComboBox<>(dogChoice);
		dogList.setLocation((renderer.getWidth()/3+75), ((renderer.getHeight()/4+50)));
		dogList.setSize(200, 30);
		
		dogList.setName("Competitions");
		components.add(dogList);
		
		JComboBox<String> scoreList = new JComboBox<>(dogScore);
		scoreList.setLocation((renderer.getWidth()/3+75), ((renderer.getHeight()/4+100)));
		scoreList.setSize(200, 30);
		scoreList.setName("Competitions");
		components.add(scoreList);
		
		
		
		JButton submitBtn = new JButton("submitbtn"); 
		submitBtn.setBounds(renderer.getWidth()/2-buttonWidth/2, renderer.getHeight()/9*7-buttonHeight, buttonWidth, buttonHeight);
		submitBtn.setFont(new Font("Helvetica", Font.BOLD, 32));
		submitBtn.setText("Submit Score");
		submitBtn.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				scoreList.setSelectedIndex(0);
				competitionList.setSelectedIndex(0);
				dogList.setSelectedIndex(0);
				JOptionPane.showMessageDialog(renderer, "Submitted Scores");
				//TODO add functionality to sumbit scores into database
				
			}
		});
		
	
		components.add(submitBtn);
		
		
		
		JButton quitBtn = new JButton("MainMenuBtn"); 
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
