package breakout;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Paddle {
	private Image image;
	private ImageView paddle;
	private String PADDLE_IMAGE = "paddle.gif";
	public static final int KEY_INPUT_SPEED = 20;

	public Paddle() {
		image = new Image(getClass().getClassLoader().getResourceAsStream(PADDLE_IMAGE));
		paddle = new ImageView(image);

	}

	public void setPosition(double width, double height) {
		paddle.setLayoutX(width / 2 - paddle.getFitWidth() / 2);
		paddle.setLayoutY(height * .9);
	}

	public double getPosition() {
		return paddle.getLayoutX();
	}

	public double getSize() {
		return paddle.getFitWidth();
	}

	public void setSize(double size) {
		paddle.setFitWidth(size * 60);
	}

	public ImageView getPaddle() {
		return paddle;
	}

	public Bounds getBoundsInParent() {
		return paddle.getBoundsInParent();
	}

	public Bounds getBoundsInLocal() {
		return paddle.getBoundsInLocal();
	}

	public void handleKeyInput(KeyCode code, int width) {

		if (code == KeyCode.RIGHT || code == KeyCode.D) {
			if (paddle.getBoundsInParent().getMaxX() <= width) {
				paddle.setX(paddle.getX() + KEY_INPUT_SPEED);
			}

		} else if (code == KeyCode.LEFT || code == KeyCode.A) {
			if (paddle.getBoundsInParent().getMinX() >= width - width) {
				paddle.setX(paddle.getX() - KEY_INPUT_SPEED);
			}
		}

	}

}
