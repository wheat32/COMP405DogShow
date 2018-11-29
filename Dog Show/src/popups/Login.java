package popups;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import graphics.Renderer;
import listeners.GraphicsListener;

public class Login implements GraphicsListener
{
	private final Renderer renderer;

	public Login(Renderer renderer)
	{
		this.renderer = renderer;
		renderer.addGraphicsListener(this);
		renderer.makeGraphicsCalls();
	}

	@Override
	public String toString()
	{
		return "login prompt";
	}

	@Override
	public void graphicsCall(JFrame jFrame)
	{
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;

		JLabel lbUsername = new JLabel("Username: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbUsername, cs);

		JTextField tfUsername = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfUsername, cs);

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

		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(tfUsername.getText().trim());
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                //dispose();
            }
        });
        
        JPanel bp = new JPanel();
        bp.add(btnLogin);
        bp.add(btnCancel);
        
        jFrame.add(panel, BorderLayout.CENTER);
        jFrame.add(bp, BorderLayout.PAGE_END);
        
        panel.setVisible(true);
        bp.setVisible(true);
	}
}
