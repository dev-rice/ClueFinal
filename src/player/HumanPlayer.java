package player;


public class HumanPlayer extends Player{

	public boolean is_my_turn;
	
	public HumanPlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Human: " + name;
	}
	
	public void startTurn(){
		is_my_turn = true;
	}
	public void endTurn(){
		is_my_turn = false;
	}
	
	

}
