package com.tinkeracademy.projects;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Window {

	public static JFrame frame;
	
	public static void show() {
		frame = new JFrame("Tinker Academy");
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        frame.pack();
        frame.setVisible(true);
	}
	
	public static JLabel addLabel(String labelText) {
		JLabel label = new JLabel(labelText);
		label.setOpaque(true);
		label.setBackground(Color.ORANGE);
        frame.getContentPane().add(label);
        return label;
	}
	
	public static JTextArea addTextArea(String text, int rows, int columns, boolean editable) {
		JTextArea textArea = new JTextArea(text, rows, columns);
		textArea.setEditable(editable);
		textArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane( textArea );
		Border border = BorderFactory.createLineBorder(Color.ORANGE, 5);
		textArea.setBorder(border);
		frame.getContentPane().add(scrollPane);
		return textArea;
	}
	
	public static JButton addButton(String buttonName) {
		JButton button = new JButton(buttonName);
		frame.getContentPane().add(button);
		return button;
	}
	
}
