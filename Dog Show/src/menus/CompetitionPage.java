package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import core.Renderer;

public class CompetitionPage extends Menu 
{
	private int panelWidth = -1;
	private int panelHeight = -1;
	private int buttonWidth = 300;
	private int buttonHeight = 80;

	public CompetitionPage(Renderer renderer) 
	{
		super(renderer);
		panelWidth = renderer.getWidth()/12*3;
		panelHeight = renderer.getHeight()/2;
		renderer.setBackground("src/images/bakingdoggo.jpeg");
		addComponents();
	}

	@Override
	protected void addComponents()
	{		
		JLabel competitionPageLabel = new JLabel("competitionPageLabel", SwingConstants.CENTER);
		competitionPageLabel.setBounds(0, renderer.getHeight()/8-buttonHeight/2, renderer.getWidth(), buttonHeight);
		competitionPageLabel.setFont(new Font("Helvetica", Font.BOLD, 64));
		competitionPageLabel.setText("Competitons");
		competitionPageLabel.setForeground(Color.BLACK);
		competitionPageLabel.setOpaque(true);
		competitionPageLabel.setBackground(new Color(1, 1, 1, 0.5f));
		components.add(competitionPageLabel);
		
		JTextField tfCompetition = new JTextField(32);
		
		
	
		String names = "this is a simple placeholder for the competition names";
		JTextField tfCompName = new JTextField(32);
		tfCompName.setLocation((renderer.getWidth()/3)-30, 200);
		tfCompName.setSize(400, 450);
		tfCompName.setText(names);
		tfCompName.setEditable(false);
		
		components.add(tfCompName);
		
		
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
