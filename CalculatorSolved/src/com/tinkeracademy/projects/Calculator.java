package com.tinkeracademy.projects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Calculator implements ActionListener {
	
	public Stack<String> inputs = new Stack<String>();
	
	public JTextArea output;
	
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
		output = Window.addTextArea("0", 2, 10, false);
		String[][] controls = {
				{"7", "8", "9", "AC"},
				{"4", "5", "6", "-"},
				{"1", "2", "3", "+"},
				{"0", "\u00F7", "*", "="}
		};
		JButton[][] buttons = Window.addGridButtons(controls);
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				JButton button = buttons[i][j];
				button.addActionListener(this);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		switch (actionCommand) {
			case "=":
				calculate();
				break;
			case "AC":
				allClearAction();
				break;
			default:
				inputAction(actionCommand);
				break;
		}
	}
	
	public void inputAction(String input) {
		if (inputs.isEmpty()) {
			output.setText(input);
		} else {
			output.setText(output.getText() + input);
		}
		handleInput(input);
	}
	
	public void handleInput(String input) {
		inputs.push(input);
	}
	
	public void allClearAction() {
		output.setText("0");
		inputs.clear();
	}
	
	public void calculate() {
		ArithmeticParser parser = new ArithmeticParser("+", "-", "*", "\u00F7");
		Double result = parser.evaluate(inputs);
		if (result == null) {
			output.setText("ERROR");
		} else {
			if (result.intValue() == result) {
				output.setText(Integer.toString(result.intValue()));
			} else {
				output.setText(Double.toString(result));
			}
		}
		inputs.clear();
	}
}
