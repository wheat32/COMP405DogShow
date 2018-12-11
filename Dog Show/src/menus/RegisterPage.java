package menus;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import graphics.Renderer;

public class RegisterPage extends Menu
{
	private int buttonWidth = 300;
	private int buttonHeight = 80;

	public RegisterPage(Renderer renderer, String addr) 
	{
		
		
		super(renderer, "cutie.jpg");
		
		addButtons();
		super.startTimer(50);
		
	}

	@Override
	protected void addButtons() //TODO add a dog pictures upload method? 
	{
		JLabel registerPageLabel = new JLabel("RegisterPageLabel", SwingConstants.CENTER);
		registerPageLabel.setBounds(renderer.getWidth()/2-buttonWidth/2, renderer.getHeight()/8*2-buttonHeight/2, buttonWidth, buttonHeight);
		registerPageLabel.setFont(new Font("Helvetica", Font.BOLD, 32));
		registerPageLabel.setText("Register Page");
		registerPageLabel.setOpaque(false);
		renderer.addComponent(registerPageLabel);
		JDialog dname = new JDialog(renderer, "Dog Details", true);  //need a way to input fields, using jdialog?
		JPanel fieldPanel = new JPanel(new GridBagLayout());
		GridBagConstraints cs  = new GridBagConstraints();
		
		cs.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel lbDogName = new JLabel("Dog Name: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		fieldPanel.add(lbDogName, cs);

		JTextField tfDogName = new JTextField(32);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		fieldPanel.add(tfDogName, cs);
		
		JLabel lbDogType = new JLabel("Dog Type: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		fieldPanel.add(lbDogType, cs);

		JTextField tfDogType = new JTextField(32);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		fieldPanel.add(tfDogType, cs);
		
		JLabel lbRegiNum = new JLabel("Registration Number: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		fieldPanel.add(lbRegiNum, cs);

		JTextField tfRegiNum = new JTextField(32);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		fieldPanel.add(tfRegiNum, cs);
		
		JLabel lbDogCol = new JLabel("Color of Dog: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		fieldPanel.add(lbDogCol, cs);

		JTextField tfDogCol = new JTextField(32);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		fieldPanel.add(tfDogCol, cs);
		
		JLabel lbDogMark= new JLabel("dogs Markings: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		fieldPanel.add(lbDogMark, cs);

		JTextField tfDogMark= new JTextField(32);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		fieldPanel.add(tfDogMark, cs);
		
		JLabel lbDogBreed = new JLabel("Dog Breed: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		fieldPanel.add(lbDogBreed, cs);

		JTextField tfDogBreed = new JTextField(32);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		fieldPanel.add(tfDogBreed, cs);






		
		
		
		
		JButton quitBtn = new JButton("QuitBtn"); //TODO maybe set this to go back to main menu 
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
		renderer.addComponent(quitBtn);
	

	}

}
