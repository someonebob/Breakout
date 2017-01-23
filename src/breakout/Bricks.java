package breakout;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bricks {
	private Rectangle brick;
	private ArrayList<Rectangle> bricks;
	private int width = 640;
	private int height = 480;
	private int brickwidth = width / 9;
	private int brickheight = height / 15;
	private HashMap<Rectangle, Integer> stonemap, ironmap;

	public Bricks() {
		bricks = new ArrayList<Rectangle>();
		stonemap = new HashMap<Rectangle, Integer>();
		ironmap = new HashMap<Rectangle, Integer>();
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

		stonemap.put(brick, 0);

		bricks.add(brick);
		return brick;
	}

	public Rectangle getIron(int xposition, int yposition) {
		brick = new Rectangle(brickwidth * xposition, brickheight * yposition, brickwidth, brickheight);
		brick.setFill(Color.SILVER);
		brick.setStroke(Color.BLACK);

		ironmap.put(brick, 0);

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
		stonemap.put(brick, stonemap.get(brick) + 1);
	}

	public void ironHit(Rectangle brick) {
		ironmap.put(brick, ironmap.get(brick) + 1);
	}

	public int getStoneHits(Rectangle brick) {
		return stonemap.get(brick);
	}

	public int getIronHits(Rectangle brick) {
		return ironmap.get(brick);
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

	public Bounds getBoundsInParent() {
		return brick.getBoundsInParent();
	}

	public void setBrickColor(int i) {
		if (i == 2) {
			brick.setFill(Color.RED);
		} else if (i == 3) {
			brick.setFill(Color.ORANGE);
		} else if (i == 4) {
			brick.setFill(Color.YELLOW);
		} else if (i == 5) {
			brick.setFill(Color.GREEN);
		} else if (i == 6) {
			brick.setFill(Color.BLUE);
		} else if (i == 7) {
			brick.setFill(Color.INDIGO);
		} else if (i == 8) {
			brick.setFill(Color.VIOLET);
		}
	}

}
