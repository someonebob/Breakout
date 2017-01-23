package breakout;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SplashScreen {
	private StackPane layout;
	private Scene title;
	private Levels levels;
	private VBox menu;
	private HBox buttons;

	public SplashScreen(Stage window, int width, int height) {
		layout = new StackPane();
		title = new Scene(layout, width, height);

		levels = new Levels(window, width, height);

		menu = new VBox(80); // magic number for the spacing I liked
		Text gametitle = new Text("BREAKOUT");
		Text instructions = new Text("Use A/<- and D/-> to move");
		Text rules = new Text("Use the paddle to keep the ball alive, clear all blocks to progress");

		buttons = new HBox(200);
		Button start = new Button("START");
		start.setOnMouseClicked(e -> {
			window.setScene(levels.getLevelOne());
			levels.animate1();
		});

		Button quit = new Button("QUIT");
		quit.setOnAction(e -> System.exit(0));

		buttons.getChildren().addAll(start, quit);
		buttons.setAlignment(Pos.CENTER);

		menu.getChildren().addAll(gametitle, instructions, rules, buttons);
		menu.setAlignment(Pos.CENTER);

		layout.getChildren().addAll(menu);
	}

	public Scene getScene() {
		return title;
	}
}
