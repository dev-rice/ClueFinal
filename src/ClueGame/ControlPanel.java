package ClueGame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.jws.Oneway;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import board.Board;

public class ControlPanel extends JPanel {

	private boolean next_turn = false;

	JButton nextPlayerButton;

	JTextField turn;
	JTextField dieRoll;
	JTextField guess;
	JTextField result;
	
	ControlPanel(){
		super();
		setSize(600, 300);


		add(turnPanel());
		add(buttonPanel(), BorderLayout.CENTER);
		add(otherPanel(), BorderLayout.SOUTH);
	}

	public void setTurn(String name){
		turn.setText(name);
	}
	
	public void setDieRoll(int roll){
		dieRoll.setText(Integer.toString(roll));
	}
	
	public void setGuess(String guess){
		this.guess.setText(guess);
	}
	
	public void setResult(String result){
		this.result.setText(result);
	}
	
	private Component turnPanel() {
		JPanel turnPanel = new JPanel();
		turn = new JTextField(15);
		JLabel turnLabel = new JLabel("Whose turn?");
		turn.setFont(new Font("SanSerif", Font.BOLD, 12));
		turn.setEditable(false);

		turnPanel.add(turnLabel);
		turnPanel.add(turn);

		return turnPanel;
	}


	public boolean isNextTurn(){
		return next_turn;
	}

	public void endTurn(){
		next_turn = false;
		nextPlayerButton.setEnabled(true);

	}
	
	public JButton getNextPlayerButton(){
		return nextPlayerButton;
	}

	public void setDisabled(){
		nextPlayerButton.setEnabled(false);
	}
	
	public void setButtonEnabled(){
		nextPlayerButton.setEnabled(true);
	}
	
	public JPanel buttonPanel(){
		nextPlayerButton = new JButton("Next Player");
		JButton accusationButton = new JButton("Make an Accusation");

//		nextPlayerButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e)
//			{
//				next_turn = true;
//				System.out.println("Setting the next_turn to true.");
//				nextPlayerButton.setEnabled(false);
//			}
//		});

		accusationButton.addActionListener(new accusationListener());

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0,2));
		
		buttonPanel.add(nextPlayerButton);
		buttonPanel.add(accusationButton);

		return buttonPanel;
	}

	public JPanel otherPanel(){
		dieRoll = new JTextField(3);
		dieRoll.setFont(new Font("SanSerif", Font.BOLD, 10));
		dieRoll.setEditable(false);
		JLabel guessLabel = new JLabel("Guess");
		guess = new JTextField(10);
		guess.setEditable(false);
		JLabel guessResult = new JLabel("Response");
		result = new JTextField(10);
		result.setEditable(false);
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();

		panel.setPreferredSize(new Dimension(650, 100));

		panel1.add(dieRoll);
		panel1.setBorder(new TitledBorder (new EtchedBorder(), "Die Roll"));
		panel1.setPreferredSize(new Dimension(75, 50));

		//panel2.add(guessLabel);
		panel2.add(guess);
		panel2.setBorder(new TitledBorder (new EtchedBorder(), "Guess"));
		panel2.setPreferredSize(new Dimension(200, 50));

		//panel3.add(guessResult);
		panel3.add(result);
		panel3.setBorder(new TitledBorder (new EtchedBorder(), "Guess Result"));
		panel3.setPreferredSize(new Dimension(200, 50));

		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		return panel;
	}
	
	private class accusationListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

}
