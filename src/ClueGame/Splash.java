package ClueGame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import player.Player;

public class Splash extends JDialog {
 public Splash(Player human) {
	// TODO Auto-generated constructor stub
	 setSize(500,150);
	 
	 JLabel label = new JLabel("You are " + human.getName() + ". Press 'Next Player' to begin play.");
	 add(label);
	 
	 JButton ok = new JButton("Ok");
	 ok.addActionListener(new ActionListener() {
	     public void actionPerformed(ActionEvent e)
	     {
	        setVisible(false);
	     }
	});
	 add(ok,BorderLayout.SOUTH);
}
}
