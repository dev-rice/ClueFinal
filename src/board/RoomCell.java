package board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RoomCell extends BoardCell {
	public enum DoorDirection {UP, DOWN, LEFT, RIGHT, NONE};

	private DoorDirection doorDirection;
	private char character;
	private String room;
	private String room_name;
	
	private static BufferedImage floor;
	private static BufferedImage door;

	public RoomCell(int row, int column, String room, String room_name) {
		this.row = row;
		this.column = column;
		this.room = room;
		this.room_name = room_name;
		character = room.charAt(0);
		if (room.length() == 1) {
			doorDirection = DoorDirection.NONE;
		} else if (room.charAt(1) == 'U') {
			doorDirection = DoorDirection.UP;
		} else if (room.charAt(1) == 'D') {
			doorDirection = DoorDirection.DOWN;
		} else if (room.charAt(1) == 'L') {
			doorDirection = DoorDirection.LEFT;
		} else if (room.charAt(1) == 'R') {
			doorDirection = DoorDirection.RIGHT;
		} else {
			doorDirection = DoorDirection.NONE;
		}
		
		try {
			floor = ImageIO.read(new File("floor2.png"));
			door = ImageIO.read(new File("floor.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*switch(character) {
			case 'C':
				room_name = "Conservatory";
				break;
			case 'B':
				room_name = "Ballroom";
				break;
			case 'K':
				room_name = "Kitchen";
				break;
			case 'T':
				room_name = "Bathroom";
				break;
			case 'Y':
				room_name = "Bowling Alley";
				break;
			case 'P':
				
				break;
			case 'G':
				
				break;
			case 'A':
				
				break;
			case 'X':
				
				break;
			case 'W':
				
				break;
			case 'L':
				
				break;
		}*/
		
	}

	@Override
	public void draw(Graphics g){
		int size = BoardCell.TILE_SIZE;
		
		if (this.isDoorWay()){

			g.drawImage(door, column*size, row*size, null);
			
			if (is_highlighted) {
				g.setColor(Color.RED);
				g.fillRect(column*size, row*size, size, size);
			} else {
				g.setColor(Color.BLACK);
				g.drawRect(column*size, row*size, size, size);
			}
		} else {
			g.drawImage(floor, column*size, row*size, null);
		}
		 
		
//		g.setColor(new Color(200,160,0));
//		g.drawRect(column*size, row*size, size, size);
		
	}
	
	@Override
	public boolean isRoom(){
		return true;
	}

	@Override
	public boolean isDoorWay() {
		if(doorDirection == DoorDirection.NONE) {
			return false;
		} else {
			return true;
		}
	}

	public DoorDirection getDoorDirection() {
		return doorDirection;
	}

	public char getCellData() {
		return character;
	}

	public String getRoom() {
		return room;
	}
	
	public String getRoomName(){
		return room_name;
	}

	@Override
	public String toString() {
		return "RoomCell [doorDirection=" + doorDirection + ", character="
				+ character + ", room=" + room + ", row=" + row + ", column="
				+ column + "]";
	}

	
}
