package ClueGame;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import card.Card;

import player.Player;

public class CardsPanel extends JPanel{
	public CardsPanel(Player human) {
		// TODO Auto-generated constructor stub
		ArrayList<Card> cards = human.getCards();
		
		setLayout(new GridLayout(cards.size(),1));
		
		for (Card card : cards){
			add(cardField(card));
		}
		
	}
	
	public JTextField cardField(Card card) {
		
		String name = null;
		
		if (card.getType() == Card.CardType.PERSON) {
			name = "People";
		} else if (card.getType() == Card.CardType.ROOM) {
			name = "Room";
		} else if (card.getType() == Card.CardType.WEAPON) {
			name = "Weapon";
		}
		
		JTextField textField = new JTextField();
		textField.setBorder(new TitledBorder (new EtchedBorder(), name));
		textField.setText(card.getName());
		textField.setEditable(false);
		
		return textField;
	}
	
}
