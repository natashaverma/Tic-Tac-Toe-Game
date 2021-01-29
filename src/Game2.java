package ticTacToe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Game2 extends JPanel {
	JButton buttons[] = new JButton[9];
	int alternate = 0;// if this number is a even, then put a X. If it's odd, then put an O so that we
						// can alternate the turns

	public Game2() {
		setLayout(new GridLayout(3, 3)); // making the layout of the game in the form of a grid
		initializebuttons();
	}

	public void initializebuttons() {
		for (int i = 0; i <= 8; i++) {
			buttons[i] = new JButton();
			buttons[i].setText(""); // initialize the buttons blank by default
			buttons[i].addActionListener(new buttonListener());

			add(buttons[i]); // adds this button to JPanel
								// this whole class is a JPanel already
		}
	}

	public void resetButtons() // to start a new game
	{
		for (int i = 0; i <= 8; i++) {
			buttons[i].setText("");
			//alternate= 0;
		}
	}

	// whenever a button is clicked, ActionEvent is generated. So,each button has an
	// action listener.
	// On clicking the button listener class is called and actionPerformed method is
	// called.
	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JButton buttonClicked = (JButton) e.getSource(); // get the particular button that was clicked
			if (alternate % 2 == 0)
				buttonClicked.setText("O");
			else
				buttonClicked.setText("X");

			// checking true condition and every 2 adjacent cells to decide the winner.
			if (checkForWin() == true && buttons[0].getText().equals("X") && buttons[3].getText().equals("X")) {
				JOptionPane.showMessageDialog(null, "Player 2 won");
				resetButtons();
			} else if (checkForWin() == true && buttons[0].getText().equals("O") && buttons[3].getText().equals("O")) {
				JOptionPane.showMessageDialog(null, "Player 1 won");
				resetButtons();
			} else if (checkForWin() == true && buttons[3].getText().equals("O") && buttons[4].getText().equals("X")) {
				JOptionPane.showMessageDialog(null, "Player 1 won");
				resetButtons();
			} else if (checkForWin() == true && buttons[3].getText().equals("O") && buttons[4].getText().equals("O")) {
				JOptionPane.showMessageDialog(null, "Player 1 won");
				resetButtons();
			} else if (checkForWin() == true && buttons[6].getText().equals("X") && buttons[7].getText().equals("X")) {
				JOptionPane.showMessageDialog(null, "Player 2 won");
				resetButtons();
			} else if (checkForWin() == true && buttons[6].getText().equals("O") && buttons[7].getText().equals("O")) {
				JOptionPane.showMessageDialog(null, "Player 1 won");
				resetButtons();
			} else if (checkForWin() == true && buttons[1].getText().equals("X") && buttons[4].getText().equals("X")) {
				JOptionPane.showMessageDialog(null, "Player 2 won");
				resetButtons();
			} else if (checkForWin() == true && buttons[1].getText().equals("O") && buttons[4].getText().equals("O")) {
				JOptionPane.showMessageDialog(null, "Player 1 won");
				resetButtons();
			} else if (checkForWin() == true && buttons[0].getText().equals("X") && buttons[1].getText().equals("X")) {
				JOptionPane.showMessageDialog(null, "Player 2 won");
				resetButtons();
			} else if (checkForWin() == true && buttons[0].getText().equals("O") && buttons[1].getText().equals("O")) {
				JOptionPane.showMessageDialog(null, "Player 1 won");
				resetButtons();
			} else if (checkForWin() == true && buttons[2].getText().equals("X") && buttons[5].getText().equals("X")) {
				JOptionPane.showMessageDialog(null, "Player 2 won");
				resetButtons();
			} else if (checkForWin() == true && buttons[2].getText().equals("O") && buttons[5].getText().equals("O")) {
				JOptionPane.showMessageDialog(null, "Player 1 won");
				resetButtons();
			} else if (checkForWin() == true && buttons[0].getText().equals("X") && buttons[4].getText().equals("X")) {
				JOptionPane.showMessageDialog(null, "Player 2 won");
				resetButtons();
			} else if (checkForWin() == true && buttons[0].getText().equals("O") && buttons[4].getText().equals("O")) {
				JOptionPane.showMessageDialog(null, "Player 1 won");
				resetButtons();
			} else if (checkForWin() == true && buttons[2].getText().equals("X") && buttons[4].getText().equals("X")) {
				JOptionPane.showMessageDialog(null, "Player 2 won");
				resetButtons();
			} else if (checkForWin() == true && buttons[2].getText().equals("O") && buttons[4].getText().equals("O")) {
				JOptionPane.showMessageDialog(null, "Player 1 won");
				resetButtons();
			}

			alternate++;

		}

		public boolean checkForWin() {
			/**
			 * Reference: the button array is arranged like this as the board 
			 * 0 | 1 | 2
			 * 3 | 4 | 5
			 * 6 | 7 | 8
			 */
			// horizontal win check
			if (checkAdjacent(0, 1) && checkAdjacent(1, 2) && buttons[1].getText().equals("X")) {
				// no need to put " == true" because the default check is for true
				// p2 wins
				return true;
			} else if (checkAdjacent(3, 4) && checkAdjacent(4, 5) && buttons[3].getText().equals("X")) {
				// p2 wins
				return true;
			} else if (checkAdjacent(6, 7) && checkAdjacent(7, 8) && buttons[6].getText().equals("X")) {
				// p2 wins
				return true;
			}
			// vertical win check
			else if (checkAdjacent(0, 3) && checkAdjacent(3, 6) && buttons[0].getText().equals("X"))
				return true;
			else if (checkAdjacent(1, 4) && checkAdjacent(4, 7) && buttons[1].getText().equals("X"))
				return true;
			else if (checkAdjacent(2, 5) && checkAdjacent(5, 8) && buttons[2].getText().equals("X"))
				return true;

			// diagonal win check
			else if (checkAdjacent(0, 4) && checkAdjacent(4, 8) && buttons[0].getText().equals("X"))
				return true;
			else if (checkAdjacent(2, 4) && checkAdjacent(4, 6) && buttons[2].getText().equals("X"))
				return true;

			// for player 1
			// horizontal win
			if (checkAdjacent(0, 1) && checkAdjacent(1, 2) && buttons[1].getText().equals("O")) {
				// no need to put " == true" because the default check is for true

				return true;
			} else if (checkAdjacent(3, 4) && checkAdjacent(4, 5) && buttons[3].getText().equals("O")) {

				return true;
			} else if (checkAdjacent(6, 7) && checkAdjacent(7, 8) && buttons[6].getText().equals("O")) {

				return true;
			}
			// vertical win check
			else if (checkAdjacent(0, 3) && checkAdjacent(3, 6) && buttons[0].getText().equals("O"))
				return true;
			else if (checkAdjacent(1, 4) && checkAdjacent(4, 7) && buttons[1].getText().equals("O"))
				return true;
			else if (checkAdjacent(2, 5) && checkAdjacent(5, 8) && buttons[2].getText().equals("O"))
				return true;

			// diagonal win check
			else if (checkAdjacent(0, 4) && checkAdjacent(4, 8) && buttons[0].getText().equals("O"))
				return true;
			else if (checkAdjacent(2, 4) && checkAdjacent(4, 6) && buttons[2].getText().equals("O"))
				return true;
			else
				return false;

		}

		public boolean checkAdjacent(int a, int b) {
			if (buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals(""))
				return true;
			else {
				return false;
			}
		}

	}

	public static void main(String[] args) {
		JFrame window = new JFrame("Tic-Tac-Toe"); // name displayed on the window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // action of cross displayed on top right corner of game
		window.getContentPane().add(new Game2());	// display the entire layout and content within JPanel box
		window.setBounds(300, 200, 300, 300); // gives x,y,width,height..x and y are coordinates of the game frame;width,height are the size of the box
		window.setVisible(true); // making the complete interface visible
	}
}
