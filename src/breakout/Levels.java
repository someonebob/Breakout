package breakout;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Levels {
	private Pane layout1, layout2, layout3, layout4;
	private Scene level1, level2, level3, bosslevel;
	private Bricks level1bricks, level2bricks, level3bricks, bosslevelbricks;
	private Boss boss;
	private int width, height;
	private Stage window;
	private Text Score1, Score2, Score3, Score4, Lives1, Lives2, Lives3, Lives4, Level;
	private int score = 0;
	private int lives = 5;
	private int HBoxseparation = 100;
	private EndScreen end;
	private Ball ball1, ball2, ball3, ball4;
	private Paddle paddle1, paddle2, paddle3, paddle4;
	private double level1paddlesize = 2;
	private double level2paddlesize = 1.5;
	private double level3paddlesize = 1.2;
	private double powerpaddlesize = 3;
	private Timeline animation;
	private boolean isPlaying = true;

	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;

	public Levels(Stage window, int width, int height) {

		this.window = window;

		this.width = width;
		this.height = height;

		layout1 = new Pane();
		level1 = new Scene(layout1, width, height);

		layout2 = new Pane();
		level2 = new Scene(layout2, width, height);

		layout3 = new Pane();
		level3 = new Scene(layout3, width, height);

		layout4 = new Pane();
		bosslevel = new Scene(layout4, width, height);

		end = new EndScreen(width, height);
	}

	public Scene getLevelOne() {
		Score1 = new Text("SCORE: " + score);
		Level = new Text("Level 1");
		Lives1 = new Text("LIVES: " + lives);

		HBox statusbar = new HBox(HBoxseparation);
		statusbar.getChildren().addAll(Score1, Level, Lives1);
		statusbar.setLayoutX(150); // 150 is just what I found to be a good
									// center point

		ball1 = new Ball();
		ball1.setPosition();

		level1bricks = new Bricks();

		placeBricks(layout1, level1bricks, 0, 7, 0, 9); // numbers are just for
														// locations of bricks

		paddle1 = new Paddle();
		paddle1.setSize(level1paddlesize);
		paddle1.setPosition(width, height);

		level1.setOnKeyPressed(e -> {
			paddle1.handleKeyInput(e.getCode(), width);
			cheatCodes(e.getCode(), layout1, ball1, paddle1);
		});

		layout1.getChildren().addAll(ball1.getBall(), paddle1.getPaddle(), statusbar);

		return level1;
	}

	public void animate1() {
		startAnimation(ball1, paddle1, level1bricks, layout1, getLevelTwo());
	}

	private Scene getLevelTwo() {
		Score2 = new Text("SCORE: " + score);
		Level = new Text("Level 2");
		Lives2 = new Text("LIVES: " + lives);

		HBox statusbar = new HBox(HBoxseparation);
		statusbar.getChildren().addAll(Score2, Level, Lives2);
		statusbar.setLayoutX(150);

		ball2 = new Ball();
		ball2.setPosition();

		level2bricks = new Bricks();

		placeStoneBricks(layout2, level2bricks, 0, 1, 0, 3);
		placeStoneBricks(layout2, level2bricks, 0, 1, 6, 9);
		placeBricks(layout2, level2bricks, 1, 3, 0, 3);
		placeBricks(layout2, level2bricks, 1, 3, 6, 9);
		placePowerUps(layout2, level2bricks, 3, 4, 1, 2);
		placePowerUps(layout2, level2bricks, 3, 4, 7, 8);
		placeBricks(layout2, level2bricks, 4, 6, 0, 3);
		placeBricks(layout2, level2bricks, 4, 6, 6, 9);

		paddle2 = new Paddle();
		paddle2.setSize(level2paddlesize);
		paddle2.setPosition(width, height);

		level2.setOnKeyPressed(e -> {
			paddle2.handleKeyInput(e.getCode(), width);
			cheatCodes(e.getCode(), layout2, ball2, paddle2);
		});

		layout2.getChildren().addAll(ball2.getBall(), paddle2.getPaddle(), statusbar);

		return level2;
	}

	private void animate2() {
		startAnimation(ball2, paddle2, level2bricks, layout2, getLevelThree());
	}

	private Scene getLevelThree() {
		Score3 = new Text("SCORE: " + score);
		Level = new Text("Level 3");
		Lives3 = new Text("LIVES: " + lives);

		HBox statusbar = new HBox(HBoxseparation);
		statusbar.getChildren().addAll(Score3, Level, Lives3);
		statusbar.setLayoutX(150);

		ball3 = new Ball();
		ball3.setPosition();

		level3bricks = new Bricks();

		placeIronBricks(layout3, level3bricks, 0, 1, 3, 6);
		placeIronBricks(layout3, level3bricks, 1, 2, 2, 3);
		placeIronBricks(layout3, level3bricks, 1, 2, 6, 7);
		placeIronBricks(layout3, level3bricks, 2, 5, 1, 2);
		placeIronBricks(layout3, level3bricks, 2, 5, 7, 8);
		placeIronBricks(layout3, level3bricks, 5, 6, 2, 3);
		placeIronBricks(layout3, level3bricks, 5, 6, 6, 7);
		placeIronBricks(layout3, level3bricks, 6, 7, 3, 6);
		placePowerUps(layout3, level3bricks, 3, 4, 4, 5);

		paddle3 = new Paddle();
		paddle3.setSize(level3paddlesize);
		paddle3.setPosition(width, height);

		level3.setOnKeyPressed(e -> {
			paddle3.handleKeyInput(e.getCode(), width);
			cheatCodes(e.getCode(), layout3, ball3, paddle3);
		});
		layout3.getChildren().addAll(ball3.getBall(), paddle3.getPaddle(), statusbar);

		return level3;
	}

	private void animate3() {
		startAnimation(ball3, paddle3, level3bricks, layout3, getBossLevel());
	}

	private Scene getBossLevel() {
		Score4 = new Text("SCORE: " + score);
		Level = new Text("FINAL LEVEL");
		Lives4 = new Text("LIVES: " + lives);

		HBox statusbar = new HBox(HBoxseparation);
		statusbar.getChildren().addAll(Score4, Level, Lives4);
		statusbar.setLayoutX(150);

		ball4 = new Ball();
		ball4.setPosition();

		bosslevelbricks = new Bricks();

		placePowerUps(layout4, bosslevelbricks, 6, 7, 4, 5);
		placePowerUps(layout4, bosslevelbricks, 5, 6, 1, 2);
		placePowerUps(layout4, bosslevelbricks, 5, 6, 7, 8);

		boss = new Boss(width, height);

		paddle4 = new Paddle();
		paddle4.setPosition(width, height);

		bosslevel.setOnKeyPressed(e -> {
			paddle4.handleKeyInput(e.getCode(), width);
			cheatCodes(e.getCode(), layout4, ball4, paddle4);
		});

		layout4.getChildren().addAll(ball4.getBall(), paddle4.getPaddle(), statusbar, boss.getBoss());

		return bosslevel;
	}

	private void animate4() {
		Pane extra = new Pane();
		Scene extrascene = new Scene(extra);
		startAnimation(ball4, paddle4, bosslevelbricks, layout4, extrascene);
	}

	private void step(double elapsedTime, Ball ball, Paddle paddle, Bricks bricks, Pane currentlayout, Scene nextscene,
			Timeline animation) {
		ball.setCenterX(ball.getCenterX() + ball.getXSpeed() * elapsedTime);
		ball.setCenterY(ball.getCenterY() + ball.getYSpeed() * elapsedTime);

		wallCollision(currentlayout, ball, paddle);

		if (paddle.getBoundsInParent().intersects(ball.getBoundsInParent())) {
			paddleCollision(paddle.getPaddle(), ball);
		}
		for (int i = 0; i < bricks.getBricks().size(); i++) {

			if (bricks.getBricks().get(i).getBoundsInParent().intersects(ball.getBoundsInParent())) {

				if (ball.getFill() == Color.DARKGRAY) {
					brickCollision(bricks.getBricks().get(i), ball);
				}

				if (bricks.isStone(bricks.getBricks().get(i))) {
					bricks.stoneHit(bricks.getBricks().get(i));
					bricks.changeStoneOpacity(bricks.getBricks().get(i),
							bricks.getStoneHits(bricks.getBricks().get(i)));

					if (bricks.getStoneHits(bricks.getBricks().get(i)) == 2) { // number
																				// of
																				// times
																				// hit
																				// before
																				// brick
																				// disappears
						currentlayout.getChildren().remove(bricks.getBricks().get(i));
						bricks.getBricks().remove(i);
					}
				} else if (bricks.isIron(bricks.getBricks().get(i))) {
					bricks.ironHit(bricks.getBricks().get(i));
					bricks.changeIronOpacity(bricks.getBricks().get(i), bricks.getIronHits(bricks.getBricks().get(i)));

					if (bricks.getIronHits(bricks.getBricks().get(i)) == 3) { // number
																				// of
																				// times
																				// hit
																				// before
																				// brick
																				// disappears
						currentlayout.getChildren().remove(bricks.getBricks().get(i));
						bricks.getBricks().remove(i);
					}
				} else if (bricks.isPowerUp(bricks.getBricks().get(i))) {
					PowerUps powerup = new PowerUps();
					powerup.setPosition(0, 0); // position of powerup icon
					currentlayout.getChildren().remove(bricks.getBricks().get(i));

					bricks.getBricks().remove(i);

					currentlayout.getChildren().add(powerup.getPowerUp());

					if (powerup.isFireBall()) {
						ball.setFill(Color.RED);
					} else if (powerup.isIncreaseBall()) {
						ball.setRadius(2 * ball.getRadius());
					} else if (powerup.isIncreasePaddle()) {
						paddle.setSize(powerpaddlesize);
					}
				} else {
					currentlayout.getChildren().remove(bricks.getBricks().get(i));
					bricks.getBricks().remove(i);
				}

				score += 10;
				updateScore(currentlayout);
			}
		}

		if (bricks.getBricks().isEmpty()) {
			if (currentlayout == layout1) {
				window.setScene(nextscene);
				animation.stop(); // stop the current animation and start new
									// one for next level
				animate2();
			}
			if (currentlayout == layout2) {
				window.setScene(nextscene);
				animation.stop();
				animate3();
			}
			if (currentlayout == layout3) {
				window.setScene(nextscene);
				animation.stop();
				animate4();
			}
		}
		if (currentlayout == layout4) {
			if (boss.getBoss().getBoundsInParent().intersects(ball.getBoundsInParent())) {
				bossCollision(boss.getBoss(), ball);
				if (ball.getFill() == Color.RED) {
					boss.bossFireHit(); // make fireballs count for 5 hits
				} else {
					boss.bossHit();
				}

				score += 10;
				Score4.setText("SCORE: " + score);
			}
			if (boss.getBossHits() >= 50) {
				currentlayout.getChildren().remove(boss);
			}
			if (bricks.getBricks().isEmpty() && boss.getBossHits() >= 50) {
				window.setScene(end.getYouWin(Score4));
			}
		}

	}

	private void startAnimation(Ball ball, Paddle paddle, Bricks bricks, Pane currentlayout, Scene nextscene) {
		animation = new Timeline();

		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
				e -> step(SECOND_DELAY, ball, paddle, bricks, currentlayout, nextscene, animation));

		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}

	public void wallCollision(Pane pane, Ball ball, Paddle paddle) {
		Bounds bounds = pane.getBoundsInLocal();
		// at right or left wall
		if (ball.getCenterX() >= (bounds.getMaxX() - ball.getRadius())
				|| ball.getCenterX() <= (bounds.getMinX() + ball.getRadius())) {
			ball.reverseBallX();
		}
		// at top wall
		if (ball.getCenterY() <= (bounds.getMinY() + ball.getRadius())) {
			ball.reverseBallY();
		}
		// at bottom wall
		if (ball.getCenterY() >= (bounds.getMaxY() - ball.getRadius())) {
			lives += -1;
			updateLives(pane);
			ball.setPosition();
			ball.resetFill();
			ball.resetRadius();
			if (pane == layout1) {
				paddle.setSize(2);
			} else if (pane == layout2) {
				paddle.setSize(1.5);

			} else {
				paddle.setSize(1);
			}
		}
	}

	public void paddleCollision(ImageView paddle, Ball ball) {
		Bounds bounds = paddle.getBoundsInParent();
		// if ball is hitting the edge of the paddle in a direction towards the
		// paddle
		if ((ball.getCenterX() > bounds.getMaxX() && Math.signum(ball.getXSpeed()) == -1)
				|| (ball.getCenterX() < bounds.getMinX() && Math.signum(ball.getXSpeed()) == 1)) {
			ball.reverseBallX();
			ball.reverseBallY();
		} else {
			ball.reverseBallY();
		}
	}

	public void brickCollision(Rectangle brick, Ball ball) {
		Bounds bounds = brick.getBoundsInParent();
		// between left and right sides of brick
		if (ball.getCenterX() < bounds.getMaxX() && ball.getCenterX() > bounds.getMinX()) {
			ball.reverseBallY();
		}
		// between top and bottom sides of brick
		else if (ball.getCenterY() < bounds.getMaxY() && ball.getCenterY() > bounds.getMinY()) {
			ball.reverseBallX();
		}
		// default to switching y if in deadzones at corner
		else {
			ball.reverseBallY();
		}
	}

	public void bossCollision(ImageView boss, Ball ball) {
		Bounds bounds = boss.getBoundsInParent();

		if (ball.getCenterX() < bounds.getMaxX() && ball.getCenterX() > bounds.getMinX()) {
			ball.reverseBallY();
		} else if (ball.getCenterY() < bounds.getMaxY() && ball.getCenterY() > bounds.getMinY()) {
			ball.reverseBallX();
		}

		else {
			ball.reverseBallY();
		}
	}

	private void placeBricks(Pane layout, Bricks brick, int rowmin, int rowmax, int colmin, int colmax) {
		for (int i = rowmin; i < rowmax; i++) {
			for (int j = colmin; j < colmax; j++) {
				layout.getChildren().add(brick.getBrick(j, i + 2));
			}
		}
	}

	private void placeStoneBricks(Pane layout, Bricks brick, int rowmin, int rowmax, int colmin, int colmax) {
		for (int i = rowmin; i < rowmax; i++) {
			for (int j = colmin; j < colmax; j++) {
				layout.getChildren().add(brick.getStone(j, i + 2));
			}
		}
	}

	private void placeIronBricks(Pane layout, Bricks brick, int rowmin, int rowmax, int colmin, int colmax) {
		for (int i = rowmin; i < rowmax; i++) {
			for (int j = colmin; j < colmax; j++) {
				layout.getChildren().add(brick.getIron(j, i + 2));
			}
		}
	}

	private void placePowerUps(Pane layout, Bricks brick, int rowmin, int rowmax, int colmin, int colmax) {
		for (int i = rowmin; i < rowmax; i++) {
			for (int j = colmin; j < colmax; j++) {
				layout.getChildren().add(brick.getPowerUp(j, i + 2));
			}
		}
	}

	private void cheatCodes(KeyCode code, Pane layout, Ball ball, Paddle paddle) {

		if (code == KeyCode.S && layout == layout1) {
			window.setScene(level2);
			animation.stop();
			animate2();
		}
		if (code == KeyCode.S && layout == layout2) {
			window.setScene(level3);
			animation.stop();
			animate3();
		}
		if (code == KeyCode.S && layout == layout3) {
			window.setScene(bosslevel);
			animation.stop();
			animate4();
		}
		if (code == KeyCode.S && layout == layout4) {
			window.setScene(end.getYouWin(Score4));
			animation.stop();
		}
		if (code == KeyCode.L) {
			lives += 1000;
			updateLives(layout);
		}
		if (code == KeyCode.P) {
			if (isPlaying) {
				animation.stop();
				isPlaying = false;
			} else {
				animation.play();
				isPlaying = true;
			}
		}
		if (code == KeyCode.SPACE) {
			ball.setFill(Color.RED);
			ball.setRadius(2 * ball.getRadius());
			paddle.setSize(3);
		}
	}

	private void updateScore(Pane layout) {
		if (layout == layout1) {
			Score1.setText("SCORE: " + score);
		}
		if (layout == layout2) {
			Score2.setText("SCORE: " + score);
		}
		if (layout == layout3) {
			Score3.setText("SCORE: " + score);
		}
		if (layout == layout4) {
			Score4.setText("SCORE: " + score);
		}
	}

	private void updateLives(Pane layout) {
		if (layout == layout1) {
			Lives1.setText("LIVES: " + lives);
			if (lives == 0) {
				window.setScene(end.getGameOver(Score1));
			}
		}
		if (layout == layout2) {
			Lives2.setText("LIVES: " + lives);
			if (lives == 0) {
				window.setScene(end.getGameOver(Score2));
			}
		}
		if (layout == layout3) {
			Lives3.setText("LIVES: " + lives);
			if (lives == 0) {
				window.setScene(end.getGameOver(Score3));
			}
		}
		if (layout == layout4) {
			Lives4.setText("LIVES: " + lives);
			if (lives == 0) {
				window.setScene(end.getGameOver(Score4));
			}
		}
	}

}
