package Application.Swing.java_application_3;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AppPanel extends JPanel {

	BufferedImage carImage;
	ImageIcon roadImage;
	Timer timer;
	int xAxis = 225;  // Car starting position
	int yAxis = 350;  // Centered vertically
	int backgroundY = 0;  // Road background scrolling position
	int speed = 0;  // Initial speed of the car
	int friction = -2;

	AppPanel() {
		setSize(500, 500);
		loadImages();
		setupKeyboard();
		setupTimer();
		setFocusable(true);
	}

	void loadImages() {
		try {
			carImage = ImageIO.read(AppPanel.class.getResource("Car2.png"));  // Load car image
			roadImage = new ImageIcon(AppPanel.class.getResource("road2.png"));  // Load road background
		} catch (IOException e) {
			System.out.println("No Image Found");
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics brush) {
		super.paintComponent(brush);

		// Draw a looping road background
//		brush.drawImage(roadImage.getImage(), 0, backgroundY + 500, 500, 500, null);
		brush.drawImage(roadImage.getImage(), 0, backgroundY, 500, 500, null);
		brush.drawImage(roadImage.getImage(), 0, backgroundY -500, 500, 500, null); // Next segment
		// Draw the car image
		brush.drawImage(carImage, xAxis, yAxis, 100, 100, null);
	}

	void setupTimer() {
		timer = new Timer(16, e -> {
			// Apply friction only when no key is pressed to reduce the speed gradually
			if (speed > 0) {
				speed += friction;  // Reduce speed by the friction value
				if (speed < 0) speed = 0;  // Ensure speed doesn't go below zero
			}
			// Move the background downwards to create movement illusion
			backgroundY += speed;
			if (backgroundY >= getWidth()) {
				backgroundY = 0;  // Reset for a looping effect
			}

			// Keep car within the frame boundaries
			if (xAxis < 30) xAxis = 30;
			if (xAxis > getWidth() - 110) xAxis = getWidth() - 110;

			repaint();
		});
		timer.start();
	}

	void setupKeyboard() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_UP -> speed = Math.min(speed + 4, 100);  // Increase speed up to a max
					case KeyEvent.VK_DOWN -> speed = Math.max(speed - 2, 0);  // Decrease speed, minimum 0
					case KeyEvent.VK_LEFT -> xAxis -= 30;  // Move left
					case KeyEvent.VK_RIGHT -> xAxis += 30;  // Move right
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					friction = -1; // Set friction to gradually reduce speed when UP is released
				}

				}
		});
	}
}
