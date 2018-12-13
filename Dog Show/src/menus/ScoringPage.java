package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import graphics.Renderer;

public class ScoringPage extends Menu 
{
	private int panelWidth = -1;
	private int panelHeight = -1;
	private int buttonWidth = 300;
	private int buttonHeight = 80;
	

	public ScoringPage(Renderer renderer) 
	{
		super(renderer);
		panelWidth = renderer.getWidth()/12*4;
		panelHeight = renderer.getHeight()/3;
		renderer.setBackground("src/images/shibeDoingARealCookWhileWearingAnApronOnTwoLegs.jpg");
		addComponents();
	}

	@Override
	protected void addComponents()
	{
		JLabel scoringPagePageLabel = new JLabel("ScoringPageLabel", SwingConstants.CENTER);
		scoringPagePageLabel.setBounds(0, renderer.getHeight()/16-buttonHeight/2, renderer.getWidth(), buttonHeight);
		scoringPagePageLabel.setFont(new Font("Helvetica", Font.BOLD, 64));
		scoringPagePageLabel.setText("Scoring Page");
		scoringPagePageLabel.setForeground(Color.BLACK);
		scoringPagePageLabel.setOpaque(true);
		scoringPagePageLabel.setBackground(new Color(1, 1, 1, 0.25f));
		components.add(scoringPagePageLabel);
		
		JPanel fieldPanel = new JPanel(new GridBagLayout());
		fieldPanel.setBounds(renderer.getWidth()/10*6, renderer.getHeight()/10*2, panelWidth, panelHeight);
		fieldPanel.setBackground(new Color(1, 1, 1, 0.7f));
		GridBagConstraints cs  = new GridBagConstraints();	
		cs.fill = GridBagConstraints.HORIZONTAL;
		cs.insets = new Insets(16,3,16,3);
		
		String[] competitionNames = new String[]   //select competition, select dog, submit scores
		{
				"Select Competiton","Being Cute", "Being Small", "Attacking innocents", "Voting"
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
		competitionList.addPopupMenuListener(new PopupMenuListener()
		{
			
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e)
			{
				renderer.repaint();
			}
			
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
			{
				renderer.repaint();
			}
			
			@Override
			public void popupMenuCanceled(PopupMenuEvent e)
			{
				renderer.repaint();
			}
		});
		cs.gridx = 0;
		cs.gridy = 0;
		fieldPanel.add(competitionList, cs);
		
		JComboBox<String> dogList = new JComboBox<>(dogChoice);
		dogList.setLocation((renderer.getWidth()/3+75), ((renderer.getHeight()/4+50)));
		dogList.setSize(200, 30);
		dogList.setName("Competitions");
		cs.gridx = 0;
		cs.gridy = 1;
		dogList.addPopupMenuListener(new PopupMenuListener()
		{
			
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e)
			{
				renderer.repaint();
			}
			
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
			{
				renderer.repaint();
			}
			
			@Override
			public void popupMenuCanceled(PopupMenuEvent e)
			{
				renderer.repaint();
			}
		});
		fieldPanel.add(dogList, cs);
		
		JComboBox<String> scoreList = new JComboBox<>(dogScore);
		scoreList.setLocation((renderer.getWidth()/3+75), ((renderer.getHeight()/4+100)));
		scoreList.setSize(200, 30);
		scoreList.setName("Competitions");
		scoreList.addPopupMenuListener(new PopupMenuListener()
		{
			
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e)
			{
				renderer.repaint();
			}
			
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
			{
				renderer.repaint();
			}
			
			@Override
			public void popupMenuCanceled(PopupMenuEvent e)
			{
				renderer.repaint();
			}
		});
		cs.gridx = 0;
		cs.gridy = 2;
		fieldPanel.add(scoreList, cs);
		
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
				submitScoresToDB();
			}
		});
		cs.gridx = 0;
		cs.gridy = 3;
		fieldPanel.add(submitBtn, cs);
		
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
		fieldPanel.setVisible(true);
		components.add(fieldPanel);
		
		renderer.addComponents(components);
	}
	
	private void submitScoresToDB()
	{
		//TODO Add code to submit the scores to the DB
		return;
	}
}
