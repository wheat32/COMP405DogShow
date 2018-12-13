package menus;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;

import graphics.Renderer;

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
