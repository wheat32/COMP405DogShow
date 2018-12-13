package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import core.Renderer;

public class DogsPage extends Menu 
{
	private int buttonWidth = 300;
	private int buttonHeight = 80;

	public DogsPage(Renderer renderer) 
	{
		super(renderer);
		renderer.setBackground("src/images/hipdoggo.jpeg");
		addComponents();
	}

	@Override
	protected void addComponents()
	{		
		JLabel competitionPageLabel = new JLabel("dognamePageLabel", SwingConstants.CENTER);
		competitionPageLabel.setBounds(0, renderer.getHeight()/16-buttonHeight/2, renderer.getWidth(), buttonHeight);
		competitionPageLabel.setFont(new Font("Helvetica", Font.BOLD, 64));
		competitionPageLabel.setText("Dog Names");
		competitionPageLabel.setForeground(Color.BLACK);
		competitionPageLabel.setOpaque(true);
		competitionPageLabel.setBackground(new Color(1, 1, 1, 0.3f));
		components.add(competitionPageLabel);

		String names = "This is a simple placeholder for the dog names.";
		JTextField tfCompName = new JTextField(32);
		tfCompName.setBounds((renderer.getWidth())-400, 200, 300, 450);
		tfCompName.setText(names);
		tfCompName.setEditable(false);
		
		components.add(tfCompName);
		
		JButton quitBtn = new JButton("goBackBtn");
		quitBtn.setBounds(renderer.getWidth()/2-buttonWidth/2, renderer.getHeight()/8*7-buttonHeight/2, buttonWidth, buttonHeight);
		quitBtn.setFont(new Font("Helvetica", Font.BOLD, 32));
		quitBtn.setText("Go Back");
		quitBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				renderer.setMenu(new ReviewScorePage(renderer));
			}
		});
		components.add(quitBtn);
		
		renderer.addComponents(components);
	}
}
