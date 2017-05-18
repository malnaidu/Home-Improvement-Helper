import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HIH_UI {
	
	private static final Dimension INITIAL_SIZE = new Dimension(400, 600);

	private static final Dimension MIN_SIZE = new Dimension(150, 300);

	private final JFrame myFrame;

	private final JMenuBar myMenuBar;

	private final JMenu myMenu;
	
	private final JMenu optionsMenu;
	
	private final JMenu myMenu3;

	private final JMenuItem aboutMenu;
	
	private final JButton newProjectButton;
	
	private final JPanel homePanel;

	public HIH_UI() {
		myFrame = new JFrame();
		myMenuBar = new JMenuBar();
		myMenu = new JMenu("Home");
		optionsMenu = new JMenu("Options");
		aboutMenu = new JMenuItem("About");
		myMenu3 = new JMenu("Compare Projects");
		homePanel = new JPanel();
        homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));
        homePanel.add(Box.createRigidArea(new Dimension(125, 200)));
		newProjectButton = new JButton("New Project + ");		
	}

	public void start() {
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(INITIAL_SIZE);
		myFrame.setMinimumSize(MIN_SIZE);
		myFrame.setLocationRelativeTo(null);
		myFrame.add(homePanel);
		homePanel.add(newProjectButton);
		myMenuBar.add(myMenu);
		myMenuBar.add(optionsMenu);
		myMenuBar.add(myMenu3);
		optionsMenu.add(aboutMenu);
		setupAbout();
		myFrame.setJMenuBar(myMenuBar);
		myFrame.setVisible(true);
	}

	private void setupAbout() {
    	aboutMenu.addActionListener(new ActionListener() {
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
