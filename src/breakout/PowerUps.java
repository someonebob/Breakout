package breakout;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PowerUps {
	private Image fireball, increaseballsize, increasepaddlesize;
	private ImageView powerup;
	private String FIRE_IMAGE = "fireball.png";
	private String INCREASE_IMAGE = "increasesize.png";
	private String INCREASE_PADDLE_IMAGE = "increasepaddle.png";
	private Random random;
	private int randomnumber;

	public PowerUps() {
		random = new Random();
		randomnumber = random.nextInt(3);

		fireball = new Image(getClass().getClassLoader().getResourceAsStream(FIRE_IMAGE));
		increaseballsize = new Image(getClass().getClassLoader().getResourceAsStream(INCREASE_IMAGE));
		increasepaddlesize = new Image(getClass().getClassLoader().getResourceAsStream(INCREASE_PADDLE_IMAGE));

		if (randomnumber == 0) {
			powerup = new ImageView(fireball);
		} else if (randomnumber == 1) {
			powerup = new ImageView(increaseballsize);
		} else {
			powerup = new ImageView(increasepaddlesize);
		}
	}

	public ImageView getPowerUp() {
		return powerup;
	}

	public boolean isFireBall() {
		return powerup.getImage() == fireball;
	}

	public boolean isIncreaseBall() {
		return powerup.getImage() == increaseballsize;
	}

	public boolean isIncreasePaddle() {
		return powerup.getImage() == increasepaddlesize;
	}

	public void setPosition(double x, double y) {
		powerup.setLayoutX(x);
		powerup.setLayoutY(y);
	}

	public double getPositionX() {
		return powerup.getLayoutX();
	}

	public double getPositionY() {
		return powerup.getLayoutY();
	}

	public double getWidth() {
		return powerup.getFitWidth();
	}

	public double getHeight() {
		return powerup.getFitHeight();
	}
}
