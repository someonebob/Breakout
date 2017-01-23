package breakout;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class EndScreen {
	private StackPane layout1, layout2;
	private Scene gameover, youwin;
	private int textseparation;

	public EndScreen(int width, int height) {
		layout1 = new StackPane();
		gameover = new Scene(layout1, width, height);

		layout2 = new StackPane();
		youwin = new Scene(layout2, width, height);
	}

	public Scene getGameOver(Text score) {
		VBox vbox = new VBox(textseparation);
		Text GameOver = new Text("GAME OVER");
		vbox.getChildren().addAll(GameOver, score);
		layout1.getChildren().add(GameOver);

		return gameover;
	}

	public Scene getYouWin(Text score) {
		VBox vbox = new VBox(textseparation);
		Text YouWin = new Text("YOU WIN!");
		vbox.getChildren().addAll(YouWin, score);
		layout2.getChildren().add(vbox);
		return youwin;
	}

}
