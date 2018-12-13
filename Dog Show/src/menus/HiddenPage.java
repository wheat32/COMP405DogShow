package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import graphics.Renderer;

public class HiddenPage extends Menu 
{
	private int buttonWidth = 260;
	private int buttonHeight = 80;
	
	public HiddenPage(Renderer renderer) 
	{
		super(renderer);
		renderer.setBackground("src/images/hidden.jpeg");
		addComponents();
	}

	@Override
	protected void addComponents()
	{
		JLabel hiddenPageLabel = new JLabel("HiddenPageLabel", SwingConstants.CENTER);
		hiddenPageLabel.setBounds(0, renderer.getHeight()/16-buttonHeight/2, renderer.getWidth(), buttonHeight);
		hiddenPageLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 58));
		hiddenPageLabel.setText("I THINK DOGS SHOULD VOTE");
		hiddenPageLabel.setForeground(Color.GREEN);
		hiddenPageLabel.setOpaque(true);
		hiddenPageLabel.setBackground(new Color(0, 0, 0, 0.3f));
		components.add(hiddenPageLabel);
		
		JLabel hiddenPageQuestionLabel = new JLabel("HiddenPageLabel", SwingConstants.CENTER);
		hiddenPageQuestionLabel.setBounds(0, renderer.getHeight()/8*6-buttonHeight/2, renderer.getWidth(), buttonHeight);
		hiddenPageQuestionLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		hiddenPageQuestionLabel.setText("do you think dogs should vote?");
		hiddenPageQuestionLabel.setForeground(Color.GREEN);
		components.add(hiddenPageQuestionLabel);
		
		JButton dogsVoteYesBtn = new JButton("DogsVoteYes"); 
		dogsVoteYesBtn.setBounds(renderer.getWidth()/6*2-buttonWidth/2, renderer.getHeight()/8*7-buttonHeight/2, buttonWidth, buttonHeight);
		dogsVoteYesBtn.setFont(new Font("Helvetica", Font.BOLD, 32));
		dogsVoteYesBtn.setText("Yes");
		dogsVoteYesBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(renderer, "nice :)");
				renderer.setMenu(new MainMenu(renderer));
			}
		});
		components.add(dogsVoteYesBtn);
		
		JButton dogsVoteNoBtn = new JButton("DogsVoteNo"); 
		dogsVoteNoBtn.setBounds(renderer.getWidth()/6*4-buttonWidth/2, renderer.getHeight()/8*7-buttonHeight/2, buttonWidth, buttonHeight);
		dogsVoteNoBtn.setFont(new Font("Helvetica", Font.BOLD, 32));
		dogsVoteNoBtn.setText("No");
		dogsVoteNoBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(renderer, "bigot REEE");
				renderer.dispose();
				throw new RuntimeException("bigotry");
			}
		});
		components.add(dogsVoteNoBtn);
		
		renderer.addComponents(components);
	}
}
