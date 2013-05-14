package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class View extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public View(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel emptyLabel = new JLabel("WW III");
		getContentPane().add(emptyLabel, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
}
