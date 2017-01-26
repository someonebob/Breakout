// This entire file is part of my masterpiece.
// Jesse Yue
/**
 * This codes purpose is to create all the different types of blocks used throughout the game (normal, stone, iron, powerup).
 * I think it is well designed because all the variable names and methods are well names and easy understand.
 * I refactored the code to change some of the variable names to be more readable and also included the inheritance of Rectangle to get rid of a method that just returned an existing method.
 */
package breakout;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bricks extends Rectangle {
	private Rectangle brick;
	private ArrayList<Rectangle> bricks;
	private int scenewidth = 640;
	private int sceneheight = 480;
	private int brickwidth = scenewidth / 9;
	private int brickheight = sceneheight / 15;
	private int hits = 0;
	private HashMap<Rectangle, Integer> stonehits, ironhits;

	public Bricks() {
		bricks = new ArrayList<Rectangle>();
		stonehits = new HashMap<Rectangle, Integer>();
		ironhits = new HashMap<Rectangle, Integer>();
	}

	public Rectangle getBrick(int xposition, int yposition) {
		brick = new Rectangle(brickwidth * xposition, brickheight * yposition, brickwidth, brickheight);
		setBrickColor(yposition);
		brick.setStroke(Color.BLACK);
		bricks.add(brick);
		return brick;
	}

	public Rectangle getStone(int xposition, int yposition) {
		brick = new Rectangle(brickwidth * xposition, brickheight * yposition, brickwidth, brickheight);
		brick.setFill(Color.DARKGRAY);
		brick.setStroke(Color.BLACK);

		stonehits.put(brick, hits);

		bricks.add(brick);
		return brick;
	}

	public Rectangle getIron(int xposition, int yposition) {
		brick = new Rectangle(brickwidth * xposition, brickheight * yposition, brickwidth, brickheight);
		brick.setFill(Color.SILVER);
		brick.setStroke(Color.BLACK);

		ironhits.put(brick, hits);

		bricks.add(brick);

		return brick;
	}

	public Rectangle getPowerUp(int xposition, int yposition) {
		brick = new Rectangle(brickwidth * xposition, brickheight * yposition, brickwidth, brickheight);
		brick.setFill(Color.GOLD);
		brick.setStroke(Color.BLACK);
		bricks.add(brick);

		return brick;
	}

	public boolean isStone(Rectangle brick) {
		return brick.getFill() == Color.DARKGRAY;

	}

	public boolean isIron(Rectangle brick) {
		return brick.getFill() == Color.SILVER;
	}

	public boolean isPowerUp(Rectangle brick) {
		return brick.getFill() == Color.GOLD;
	}

	public void stoneHit(Rectangle brick) {
		stonehits.put(brick, stonehits.get(brick) + 1);
	}

	public void ironHit(Rectangle brick) {
		ironhits.put(brick, ironhits.get(brick) + 1);
	}

	public int getStoneHits(Rectangle brick) {
		return stonehits.get(brick);
	}

	public int getIronHits(Rectangle brick) {
		return ironhits.get(brick);
	}

	public void changeStoneOpacity(Rectangle brick, int hits) {
		if (hits == 1) {
			brick.setOpacity(.5);
		}
	}

	public void changeIronOpacity(Rectangle brick, int hits) {
		if (hits == 1) {
			brick.setOpacity(.66);
		}
		if (hits == 2) {
			brick.setOpacity(.33);
		}
	}

	public ArrayList<Rectangle> getBricks() {
		return bricks;
	}

	public void setBrickColor(int row) {
		if (row == 2) {
			brick.setFill(Color.RED);
		} else if (row == 3) {
			brick.setFill(Color.ORANGE);
		} else if (row == 4) {
			brick.setFill(Color.YELLOW);
		} else if (row == 5) {
			brick.setFill(Color.GREEN);
		} else if (row == 6) {
			brick.setFill(Color.BLUE);
		} else if (row == 7) {
			brick.setFill(Color.INDIGO);
		} else if (row == 8) {
			brick.setFill(Color.VIOLET);
		}
	}
}
