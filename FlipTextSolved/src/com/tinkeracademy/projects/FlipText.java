package com.tinkeracademy.projects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class FlipText implements MouseListener, ActionListener {

	public static JTextArea inputTextArea;
	
	public static JTextArea outputTextArea;
	
	public static JButton flipTextButton;
	
	public static void main(String[] args) {
		FlipText flipText = new FlipText();
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                flipText.createAndShowGUI();
	            }
	        });
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		onButtonPressed(e);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			inputTextArea.selectAll();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	public void createAndShowGUI() {
		Window.show();
		Window.addLabel("Flip Text Application Developed By: Tinker Academy v1.0");
		inputTextArea = Window.addTextArea("<Type in text to flip>", 10, 10, true);
		inputTextArea.addMouseListener(this);
		flipTextButton = Window.addButton("Flip Text");
		flipTextButton.addActionListener(this);
		outputTextArea = Window.addTextArea("", 10, 10, false);
		outputTextArea.addMouseListener(this);
	}
	
	public static void onButtonPressed(ActionEvent e) {
		String inputText = inputTextArea.getText();
		String outputText = flipText(inputText);
		outputTextArea.setText(outputText);
	}
	
	public static String flipText(String inputText) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < inputText.length(); i++) {
			String s = FlipTextLookupTable.getFlippedSymbol(String.valueOf(inputText.charAt(i)));
			builder.append(s);
		}
		builder = builder.reverse();
		return builder.toString();
	}
}
