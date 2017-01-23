package breakout;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Ball {
	private Circle ball;
	private double ballspeedx = 150;
	private double ballspeedy = 150;
	private double defaultsize = 5;

	public Ball() {
		ball = new Circle();
		ball.setFill(Color.DARKGREY);
		ball.setRadius(defaultsize);

	}

	public void setPosition() {
		ball.setCenterX(320); // just a nice position near the middle of screen
		ball.setCenterY(300);
	}

	public Circle getBall() {
		return ball;
	}

	public void setXSpeed(double newspeed) {
		ballspeedx = newspeed;
	}

	public void setYSpeed(double newspeed) {
		ballspeedy = newspeed;
	}

	public double getXSpeed() {
		return ballspeedx;
	}

	public double getYSpeed() {
		return ballspeedy;
	}

	public double getXYSpeed() {
		return Math.sqrt(ballspeedx * ballspeedx + ballspeedy * ballspeedy);
	}

	public void reverseBallX() {
		ballspeedx *= -1;
	}

	public void reverseBallY() {
		ballspeedy *= -1;
	}

	public void setRadius(double radius) {
		ball.setRadius(radius);
	}

	public double getRadius() {
		return ball.getRadius();
	}

	public void resetRadius() {
		ball.setRadius(defaultsize);
	}

	public double getCenterX() {
		return ball.getCenterX();
	}

	public double getCenterY() {
		return ball.getCenterY();
	}

	public void setCenterX(double xcenter) {
		ball.setCenterX(xcenter);
	}

	public void setCenterY(double ycenter) {
		ball.setCenterY(ycenter);
	}

	public Bounds getBoundsInParent() {
		return ball.getBoundsInParent();
	}

	public void setFill(Color color) {
		ball.setFill(color);
	}

	public Paint getFill() {
		return ball.getFill();
	}

	public void resetFill() {
		ball.setFill(Color.DARKGRAY);
	}
}
