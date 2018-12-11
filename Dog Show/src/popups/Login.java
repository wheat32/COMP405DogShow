package popups;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import core.Status;
import graphics.Renderer;

public class Login
{
	//private transient final String adminEmail = "admin";
	//private transient final String adminPassword = "password";
	
	public Login(Renderer renderer)
	{
		graphicsCall(renderer);
	}

	@Override
	public String toString()
	{
		return "login prompt";
	}

	public void graphicsCall(Renderer renderer)
	{
		JDialog dialog = new JDialog(renderer, "Login", true);
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;

		JLabel lbEmail = new JLabel("Email: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbEmail, cs);

		JTextField tfEmail = new JTextField(32);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfEmail, cs);

		JLabel lbPassword = new JLabel("Password: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbPassword, cs);

		JPasswordField pfPassword = new JPasswordField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(pfPassword, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		JButton btnLogin = new JButton("Login");
		btnLogin.setMnemonic(KeyEvent.VK_ENTER);

		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(isUser(tfEmail.getText(), String.valueOf(pfPassword.getPassword())) == true)
				{
					dialog.dispose();
					Status.loggedIn = true;
					Status.email = tfEmail.getText();
					Status.fName = "AdminFName";
					Status.lName = "AdminLName";
				}
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	dialog.dispose();
            	renderer.dispose();
            }
        });
        
        JPanel bp = new JPanel();
        bp.add(btnLogin);
        bp.add(btnCancel);
        
        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(bp, BorderLayout.PAGE_END);
        
        dialog.pack();
        dialog.setResizable(false);
        
        dialog.setLocationRelativeTo(renderer);
        dialog.setLocation(renderer.getWidth()/2, renderer.getHeight()/2);
        dialog.setVisible(true);
	}
	
	private boolean isUser(String username, String password)
	{
		connectToDB();
		//TODO get the connection
		return true;//TODO for now, just return true
	}
	
	private Connection connectToDB()
	{
		//TODO implement getting database connection
		Connection connection = null;
		return connection;
	}
}
