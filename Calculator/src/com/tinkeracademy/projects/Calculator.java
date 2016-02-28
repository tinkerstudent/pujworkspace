package com.tinkeracademy.projects;

import javax.swing.JButton;

public class Calculator {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				calculator.createAndShowGUI();
			}
		});
	}

	public void createAndShowGUI() {
		Window.show();
		Window.addLabel("Calculator Application Developed By: Tinker Academy v1.0");
		Window.addTextArea("0", 2, 10, false);
		String[][] controls = {
				{ "7", "8", "9", "\u00F7" },
				{ "4", "5", "6", "-" }, 
				{ "1", "2", "3", "+" },
				{ "0", ".", "*", "=" } 
		};
		JButton[][] buttons = Window.addGridButtons(controls);
	}
}
