package com.tinkeracademy.projects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class FlipText implements ActionListener {

	// 1
	public static JButton flipTextButton;
	public static JTextArea inputTextArea;
	public static JTextArea outputTextArea;

	public static void main(String[] args) {
		System.out.println("Hello World");
		FlipText flipText = new FlipText();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				flipText.createAndShowGUI();
			}
		});
	}

	public void createAndShowGUI() {
		Window.show();
		Window.addLabel("Flip Text Application Developed By: Tinker Academy v1.0");
		inputTextArea = Window.addTextArea("<Type in text to flip>", 10, 10, true);
		flipTextButton = Window.addButton("Flip Text");
		flipTextButton.addActionListener(this);
		outputTextArea = Window.addTextArea("", 10, 10, false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("Button clicked!");
//		System.out.println("Generating upside down text...");
		String inputText = inputTextArea.getText();
//		System.out.println(inputText);
		String outputText = "";
		for (int i = 0; i < inputText.length(); i++) {
			char ch = inputText.charAt(i);
			String fch = flipText(ch);
			outputText = fch + outputText;
		}
		outputTextArea.setText(outputText);
	}
	
	public String flipText(char ch) {
		String input = String.valueOf(ch);	
		String output = FlipTextLookupTable.getFlippedSymbol(input);
		return output;
	}

}
