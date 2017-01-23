package breakout;

import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Boss {
	private Image image;
	private ImageView boss;
	private String BOSS_IMAGE = "spooky.gif";
	private int bosswidth = 122;
	private int bossspeed = 100;
	private HashMap<ImageView, Integer> bossmap;

	public Boss(double width, double height) {
		image = new Image(getClass().getClassLoader().getResourceAsStream(BOSS_IMAGE));
		boss = new ImageView(image);
		boss.setLayoutX(width / 2 - bosswidth / 2);
		boss.setLayoutY(height / 10);
		bossmap = new HashMap<ImageView, Integer>();
		bossmap.put(boss, 0);
	}

	public ImageView getBoss() {
		return boss;
	}

	public void setLayoutX(double position) {
		boss.setLayoutX(position);
	}

	public double getLayoutX() {
		return boss.getLayoutX();
	}

	public int getBossSpeed() {
		return bossspeed;
	}

	public void reverseBossSpeed() {
		bossspeed *= -1;
	}

	public void bossHit() {
		bossmap.put(boss, bossmap.get(boss) + 1);
	}

	public void bossFireHit() {
		bossmap.put(boss, bossmap.get(boss) + 5);
	}

	public int getBossHits() {
		return bossmap.get(boss);
	}

}
