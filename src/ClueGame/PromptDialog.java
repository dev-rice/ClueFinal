package ClueGame;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import board.RoomCell;

import card.Card;

public class PromptDialog extends JDialog  {
	private JComboBox rooms;
	private JComboBox people;
	private JComboBox weapons;

	private JButton submit;
	private JButton cancel;

	public PromptDialog(Stack<Card> deck) {
		// TODO Auto-generated constructor stub
		setSize(300,300);
		setLayout(new GridLayout(4,2));

		people = new JComboBox();
		rooms = new JComboBox();
		weapons = new JComboBox();

		submit = new JButton("Submit");
		cancel = new JButton("Cancel");



		while(!deck.isEmpty()){
			Card card = deck.pop();

			if (card.getType() == Card.CardType.PERSON){
				people.addItem(card.getName());
			} else if (card.getType() == Card.CardType.WEAPON) {
				weapons.addItem(card.getName());
			} else if (card.getType() == Card.CardType.ROOM && !card.getName().equals("Walkway")) {
				rooms.addItem(card.getName());
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

	public String getRoom(){

		return (String) rooms.getSelectedItem();
	}
	public String getPerson(){

		return (String) people.getSelectedItem();
	}
	public String getWeapon(){

		return (String) weapons.getSelectedItem();
	}
}
