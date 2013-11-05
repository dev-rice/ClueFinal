package board;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashSet;

import card.Card;

public abstract class BoardCell {
	protected int row;
	protected int column;
	public static final int TILE_SIZE = 16;

	protected boolean is_highlighted;
	
	public boolean containsClick(int x, int y) {
		//System.out.println("X: "  + x + " Y: " + y);
		return (x >= column * TILE_SIZE) && (x <= (column * TILE_SIZE) + TILE_SIZE)
				&& (y >= row * TILE_SIZE) && ( y <= (row * TILE_SIZE) + TILE_SIZE);
	}
	
	public boolean isWalkway(){
		return false;
	}
	
	public boolean isRoom(){
		return false;
	}
	
	public boolean isDoorWay(){
		return false;
	}
	
	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
	
	public abstract void draw(Graphics g);
	
	public void makeHighlighted() {
		is_highlighted = true;
		//highlight_color = new Color(255,0,0)
		//g.setColor(Color.RED);
		//g.drawRect(getColumn()*TILE_SIZE, getRow()*TILE_SIZE, TILE_SIZE, TILE_SIZE);
	}

	public void revertHighlighted() {
		is_highlighted = false;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        BoardCell cell = (BoardCell) obj;
        return (row == cell.getRow() && column == cell.getColumn());
                
    }

}
