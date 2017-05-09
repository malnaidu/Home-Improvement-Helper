import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	private final JMenu myMenu2;
	
	private final JMenu myMenu3;

	private final JMenuItem myMenuItem;
	
	private final JButton newProject;
	
	private final JPanel myPanel;

	public HIH_UI() {
		myFrame = new JFrame();
		myMenuBar = new JMenuBar();
		myMenu = new JMenu("Home");
		myMenu2 = new JMenu("Options");
		myMenuItem = new JMenuItem("About");
		myMenu3 = new JMenu("Compare Projects");
		myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
		newProject = new JButton("New Project + ");
		

	}

	public void start() {
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(INITIAL_SIZE);
		myFrame.setMinimumSize(MIN_SIZE);
		myFrame.setLocationRelativeTo(null);
		myFrame.add(myPanel);
		myPanel.add(newProject);
		myMenuBar.add(myMenu);
		myMenuBar.add(myMenu2);
		myMenuBar.add(myMenu3);
		myMenu2.add(myMenuItem);
		setupAbout();
		myFrame.setJMenuBar(myMenuBar);
		myFrame.setVisible(true);
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
