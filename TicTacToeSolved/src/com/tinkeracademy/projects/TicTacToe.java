package com.tinkeracademy.projects;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class TicTacToe implements ActionListener {

	public static enum Move {
		X, 
		O, 
		NONE;
		
		@Override
		public String toString() {
			switch(this) {
		      case X: return "X";
		      case O: return "O";
		      case NONE: return "";
		      default: throw new IllegalArgumentException();
		    }
		}
	}

	public Move nextMove = Move.X;

	public List<JButton> buttonsList;

	public Move[][] moves = { { Move.NONE, Move.NONE, Move.NONE }, { Move.NONE, Move.NONE, Move.NONE },
			{ Move.NONE, Move.NONE, Move.NONE }, };

	public static void main(String[] args) {
		TicTacToe ticTacToe = new TicTacToe();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ticTacToe.createAndShowGUI();
			}
		});
	}

	public void createAndShowGUI() {
		Window.show();
		Window.addLabel("TicTacToe Application Developed By: Tinker Academy v1.0");
		String[][] controls = { { "", "", "" }, { "", "", "" }, { "", "", "" } };
		buttonsList = new ArrayList<JButton>();
		JButton[][] buttons = Window.addGridButtons(controls);
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				JButton button = buttons[i][j];
				Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 32);
				button.setFont(font);
				button.addActionListener(this);
				buttonsList.add(button);
			}
		}
		prepareNextGame();
		nextMove = Move.X;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			if (isValidMove(button)) {
				Move move = nextMove;
				switchMove();
				markMove(button, move);
				int index = buttonsList.indexOf(button);
				int row = index / 3;
				int col = index % 3;
				boolean isGameWon = checkGameOver(row, col, move);
				boolean isLastMove = checkLastMove();
				if (isGameWon) {
					markGameWon(move);
				} else if (isLastMove) {
					markGameDraw();
				}
			}
		}
	}

	public void switchMove() {
		if (nextMove == Move.X) {
			nextMove = Move.O;
		} else if (nextMove == Move.O) {
			nextMove = Move.X;
		}
	}

	public boolean isValidMove(JButton button) {
		String text = button.getText();
		if (text != null) {
			text = text.trim();
			if (text.length() > 0) {
				return false;
			}
		}
		return true;
	}

	public void markMove(JButton button, Move move) {
		button.setText(move.toString());
	}

	public boolean checkGameOver(int row, int col, Move move) {
		moves[row][col] = move;
		boolean complete = checkRowComplete();
		complete = complete || checkColumnsComplete();
		complete = complete || checkTopLeftDiagonalComplete();
		complete = complete || checkBottomLeftDiagonalComplete();
		return complete;
	}
	
	public boolean checkLastMove() {
		for (int i = 0; i < buttonsList.size(); i++) {
			JButton button = buttonsList.get(i);
			if (isValidMove(button)) {
				return false;
			}
		}
		return true;
	}

	public boolean checkRowComplete() {
		boolean isComplete = false;
		int score = 0;
		for (int i = 0; i < 3; i++) {
			score = 0;
			for (int j = 0; j < 3; j++) {
				int index = i * 3 + j;
				score = updateScore(score, index);
			}
			if (isGameOverScore(score)) {
				isComplete = true;
				break;
			}
		}
		return isComplete;
	}

	public boolean checkColumnsComplete() {
		boolean isComplete = false;
		int score = 0;
		for (int i = 0; i < 3; i++) {
			score = 0;
			for (int j = 0; j < 3; j++) {
				int index = j * 3 + i;
				score = updateScore(score, index);
			}
			if (isGameOverScore(score)) {
				isComplete = true;
				break;
			}
		}
		return isComplete;
	}

	public boolean checkTopLeftDiagonalComplete() {
		boolean isComplete = false;
		int score = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) {
					int index = i * 3 + j;
					score = updateScore(score, index);
				}
			}
			if (isGameOverScore(score)) {
				isComplete = true;
				break;
			}
		}
		return isComplete;
	}

	public boolean checkBottomLeftDiagonalComplete() {
		boolean isComplete = false;
		int score = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) {
					int index = (2 - i) * 3 + j;
					if (buttonsList.get(index).getText() == Move.X.toString()) {
						score = score + 1;
					} else if (buttonsList.get(index).getText() == Move.O.toString()) {
						score = score - 1;
					}
				}
			}
			if (isGameOverScore(score)) {
				isComplete = true;
				break;
			}
		}
		return isComplete;
	}

	public void markGameWon(Move move) {
		JOptionPane.showMessageDialog(Window.frame, "Game Over '" + move.toString() + "' won!");
		prepareNextGame();
	}
	
	public void markGameDraw() {
		JOptionPane.showMessageDialog(Window.frame, "Game Over - Draw!");
		prepareNextGame();
	}

	public int updateScore(int score, int index) {
		if (isMoveButton(buttonsList, index, Move.X)) {
			score = score + 1;
		} else if (isMoveButton(buttonsList, index, Move.O)) {
			score = score - 1;
		}
		return score;
	}

	public boolean isMoveButton(List<JButton> list, int index, Move move) {
		if (list.get(index).getText() == move.toString()) {
			return true;
		}
		return false;
	}

	public boolean isGameOverScore(int score) {
		return score == 3 || score == -3;
	}
	
	public void prepareNextGame() {
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < moves[i].length; j++) {
				moves[i][j] = Move.NONE;
			}
		}
		for (int i = 0; i < buttonsList.size(); i++) {
			JButton button  =buttonsList.get(i);
			button.setText(Move.NONE.toString());
		}
	}

}
