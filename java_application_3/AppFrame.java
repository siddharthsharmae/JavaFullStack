package Application.Swing.java_application_3;

import javax.swing.*;

public class AppFrame extends JFrame {

	AppFrame() {
		initApp();
	}

	public void initApp() {
		setTitle("Car Game");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		AppPanel aPanel = new AppPanel();
		add(aPanel);
		setVisible(true);
	}
}
