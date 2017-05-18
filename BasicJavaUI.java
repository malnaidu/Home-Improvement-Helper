import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class BasicJavaUI
{

	private static final Dimension INITIAL_SIZE = new Dimension(300, 400);

	private static final Dimension MIN_SIZE = new Dimension(150, 300);

	private final JFrame myFrame;

	private final JMenuBar myMenuBar;

	private final JMenu myMenu;

	private final JMenuItem myMenuItem;

	private final JPanel myLogin;
	
	private int successCount = 0;

	public BasicJavaUI()
	{
		myFrame = new JFrame();
		myMenuBar = new JMenuBar();
		myMenu = new JMenu("Options");
		myMenuItem = new JMenuItem("About");
		myLogin = new JPanel();

	}

	public void start()
	{
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(INITIAL_SIZE);
		myFrame.setMinimumSize(MIN_SIZE);
		myFrame.setLocationRelativeTo(null);
		myFrame.add(myLogin);
		myLogin.setLayout(new BoxLayout(myLogin, BoxLayout.Y_AXIS));
		myMenuBar.add(myMenu);
		myMenu.add(myMenuItem);
		setupAbout();
		myFrame.setJMenuBar(myMenuBar);
		login();
		myFrame.setVisible(true);
	}

	public void dataStore(String name, String email)
	{
		List<Data> dataList = new ArrayList<Data>();
		Data newEntry = new Data(name, email);
		dataList.add(newEntry);
	}

	public void login()
	{
		JTextField name = new JTextField("");
		JTextField email = new JTextField("");
		JButton submit = new JButton("Submit");
		JLabel nameLabel = new JLabel("Name");
		JLabel emailLabel = new JLabel("Email");

		myLogin.add(Box.createRigidArea(new Dimension(100, 70)));
		myLogin.add(nameLabel);
		myLogin.add(name);
		myLogin.add(Box.createRigidArea(new Dimension(0, 70)));
		myLogin.add(emailLabel);
		myLogin.add(email);
		myLogin.add(Box.createRigidArea(new Dimension(0, 90)));
		myLogin.add(submit);
		myLogin.add(Box.createRigidArea(new Dimension(0, 90)));

		// button listener
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (name.getText().equals("") || email.getText().equals(""))
				{
					// error "One or more fields are empty.
					JOptionPane.showMessageDialog(myFrame, "Please enter a name and email.", "Error!",
							JOptionPane.WARNING_MESSAGE);	
				} else if (!email.getText().contains("@") || !email.getText().contains("."))
				{
					// error "Please enter a valid email address
					JOptionPane.showMessageDialog(myFrame, "Please enter a valid email.", "Error!",
							JOptionPane.WARNING_MESSAGE);
				} else
				{
					dataStore(name.getText(), email.getText());
					JOptionPane.showMessageDialog(myFrame, "Name and email successfully added.", "Success!",
							JOptionPane.INFORMATION_MESSAGE);
					successCount++;
				}
			}
		});
	}

	// Inner class Data stores names and emails
	class Data
	{
		private String name;
		private String email;

		// constructor
		public Data(String name, String email)
		{
			this.name = name;
			this.email = email;
		}

		// getter
		public String getName()
		{
			return name;
		}

		public String getEmail()
		{
			return email;
		}
		// setter

		public void setName(String name)
		{
			this.name = name;
		}

		public void setEmail(String email)
		{
			this.email = email;
		}
	}

	private void setupAbout() {
    	myMenuItem.addActionListener(new ActionListener() {
    		public void actionPerformed(final ActionEvent theEvent) {
    			JOptionPane.showMessageDialog(myFrame, "We are "
    					+ "team Light Olive Green\nTravis Bain \"Tora\"\n"
    					+ "Brendan Kim \"Blubberflub\"\nMalini Naidu \"MalNaidu\"\n"
    					+ "Brian Wolk \"Bwolkster\"\n"
    					+ "Alisher Baimenov \"Aleke\"",
    					"About", JOptionPane.INFORMATION_MESSAGE);
    		}
    	});
    }
}