package ClueGame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import player.Player;
import player.Suggestion;
import board.RoomCell;
import card.Card;

public class PromptDialog extends JDialog  {
	private JComboBox rooms;
	private JComboBox people;
	private JComboBox weapons;

	private JButton submit;
	private JButton cancel;

	private ClueGame clue_game;
	
	public PromptDialog(ClueGame game) {
		// TODO Auto-generated constructor stub
		setSize(300,300);
		setLayout(new GridLayout(4,2));

		clue_game = game;
		
		people = new JComboBox();
		rooms = new JComboBox();
		weapons = new JComboBox();

		submit = new JButton("Submit");
		cancel = new JButton("Cancel");

		Stack<Card> deck = clue_game.loadDeck();
		
		while(!deck.isEmpty()){
			Card card = deck.pop();

			if (card.getType() == Card.CardType.PERSON){
				people.addItem(card);
			} else if (card.getType() == Card.CardType.WEAPON) {
				weapons.addItem(card);
			} else if (card.getType() == Card.CardType.ROOM && !card.getName().equals("Walkway")) {
				rooms.addItem(card);
			}

		}
		setModal(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		add(new JLabel("Your room"));
		add(rooms);
		add(new JLabel("Person"));
		add(people);
		add(new JLabel("Weapon"));
		add(weapons);
		add(submit);
		add(cancel);
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("you clicked submit");
				
				Card disprove_card = null;
				
				for ( Player p : clue_game.getPlayers()) {
					disprove_card = p.disproveSuggestion(getPerson().getName(), getWeapon().getName(), getRoom().getName());
				}
				Suggestion s = new Suggestion(getPerson(), getWeapon(), getRoom());
				clue_game.getControl_panel().setGuess(s.toString());
				
				if (disprove_card != null) {
					clue_game.getControl_panel().setResult(disprove_card.getName());
				} else {
					clue_game.getControl_panel().setResult("No new clue");
				}
				
				clue_game.endHumanTurn();
				setVisible(false);
			}
		});


	}

	public void setRoom(RoomCell room){
		rooms.setSelectedItem(room.getRoomName());
		rooms.setEditable(false);
		rooms.setEnabled(false);
		cancel.setEnabled(false);
	}
	public JButton getSubmitButton(){
		System.out.println("Giving you my button.");
		return submit;
	}

	public Card getRoom(){

		return (Card) rooms.getSelectedItem();
	}
	public Card getPerson(){

		return (Card) people.getSelectedItem();
	}
	public Card getWeapon(){

		return (Card) weapons.getSelectedItem();
	}
}
