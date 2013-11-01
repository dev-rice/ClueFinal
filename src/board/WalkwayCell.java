package board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WalkwayCell extends BoardCell {
	private static BufferedImage image;
	
	public WalkwayCell(int row, int column) {
		this.row = row;
		this.column = column;
		try {
			image = ImageIO.read(new File("wood3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void draw(Graphics g){
		int size = BoardCell.TILE_SIZE;
		
		g.drawImage(image, column*size, row*size, null);
		if (is_highlighted) {
			g.setColor(Color.RED);
			g.fillRect(column*size, row*size, size, size);
		} else {
			g.setColor(Color.BLACK);
			g.drawRect(column*size, row*size, size, size);
		}
		
		
		
	}
	
	@Override
	public boolean isWalkway(){
		return true;
	}

	@Override
	public String toString() {
		return "WalkwayCell [row=" + row + ", column=" + column + "]";
	}

}
