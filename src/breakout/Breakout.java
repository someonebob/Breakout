package breakout;

import javafx.application.Application;
import javafx.stage.Stage;

public class Breakout extends Application {
	private Stage window;
	private SplashScreen splashscreen;
	private int width = 640;
	private int height = 480;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		splashscreen = new SplashScreen(window, width, height);
		window.setScene(splashscreen.getScene());
		window.setTitle("BREAKOUT");
		window.show();
	}

}
