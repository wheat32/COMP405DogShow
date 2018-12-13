package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import graphics.Renderer;

public class RegisterPage extends Menu
{
	private int panelWidth = -1;
	private int panelHeight = -1;
	private int buttonWidth = 300;
	private int buttonHeight = 80;

	public RegisterPage(Renderer renderer) 
	{
		super(renderer);
		panelWidth = renderer.getWidth()/12*3;
		panelHeight = renderer.getHeight()/2;
		renderer.setBackground("src/images/cutie.jpeg");
		addComponents();
	}

	@Override
	protected void addComponents() //TODO add a dog pictures upload method? 
	{
		JLabel registerPageLabel = new JLabel("RegisterPageLabel", SwingConstants.CENTER);
		registerPageLabel.setBounds(0, renderer.getHeight()/8-buttonHeight/2, renderer.getWidth(), buttonHeight);
		registerPageLabel.setFont(new Font("Helvetica", Font.BOLD, 64));
		registerPageLabel.setText("Register Page");
		registerPageLabel.setForeground(Color.BLACK);
		components.add(registerPageLabel);
		
		JPanel fieldPanel = new JPanel(new GridBagLayout());
		fieldPanel.setBounds(renderer.getWidth()/10*6, renderer.getHeight()/10*2, panelWidth, panelHeight);
		GridBagConstraints cs  = new GridBagConstraints();	
		cs.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel lbDogName = new JLabel("Dog Name: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		fieldPanel.add(lbDogName, cs);

		JTextField tfDogName = new JTextField(32);
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 2;
		fieldPanel.add(tfDogName, cs);
		
		JLabel lbDogType = new JLabel("Dog Type: ");
		cs.gridx = 0;
		cs.gridy = 2;
		cs.gridwidth = 1;
		fieldPanel.add(lbDogType, cs);

		JTextField tfDogType = new JTextField(32);
		cs.gridx = 0;
		cs.gridy = 3;
		cs.gridwidth = 2;
		fieldPanel.add(tfDogType, cs);
		
		JLabel lbRegiNum = new JLabel("Registration Number: ");
		cs.gridx = 0;
		cs.gridy = 4;
		cs.gridwidth = 1;
		fieldPanel.add(lbRegiNum, cs);

		JTextField tfRegiNum = new JTextField(32);
		cs.gridx = 0;
		cs.gridy = 5;
		cs.gridwidth = 2;
		fieldPanel.add(tfRegiNum, cs);
		
		JLabel lbDogCol = new JLabel("Color of Dog: ");
		cs.gridx = 0;
		cs.gridy = 6;
		cs.gridwidth = 1;
		fieldPanel.add(lbDogCol, cs);

		JTextField tfDogCol = new JTextField(32);
		cs.gridx = 0;
		cs.gridy = 7;
		cs.gridwidth = 2;
		fieldPanel.add(tfDogCol, cs);
		
		JLabel lbDogMark = new JLabel("Dogs Markings: ");
		cs.gridx = 0;
		cs.gridy = 8;
		cs.gridwidth = 1;
		fieldPanel.add(lbDogMark, cs);

		JTextField tfDogMark = new JTextField(32);
		cs.gridx = 0;
		cs.gridy = 9;
		cs.gridwidth = 2;
		fieldPanel.add(tfDogMark, cs);
		
		JLabel lbDogBreed = new JLabel("Dog Breed: ");
		cs.gridx = 0;
		cs.gridy = 10;
		cs.gridwidth = 1;
		fieldPanel.add(lbDogBreed, cs);

		JTextField tfDogBreed = new JTextField(32);
		cs.gridx = 0;
		cs.gridy = 11;
		cs.gridwidth = 2;
		fieldPanel.add(tfDogBreed, cs);
		
		JButton submitBtn = new JButton("SubmitButton");
		cs.gridx = 0;
		cs.gridy = 12;
		cs.gridwidth = 1;
		submitBtn.setText("Submit Button");
		submitBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				submitInformation();
				tfDogName.setText("");
				tfDogType.setText("");
				tfRegiNum.setText("");
				tfDogCol.setText("");
				tfDogMark.setText("");
				tfDogBreed.setText("");
				JOptionPane.showMessageDialog(renderer, "Dog submitted.");
			}
		});
		fieldPanel.add(submitBtn, cs);
		
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
		fieldPanel.setVisible(true);
		components.add(fieldPanel);
		
		renderer.addComponents(components);
	}

	private void submitInformation()
	{
		//TODO add code to submit the information
	}
}
