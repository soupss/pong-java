import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

public class Main extends Application {
    private Game game;


    public static void main(String[] args) {
        //calls init(), start(), and stop()
        launch(args);
    }


    @Override
    public void start(Stage stage) {
        game = new Game(stage);

        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                game.update();
                game.render();
            }
        }.start();
    }


    @Override
    public void stop() {
        System.out.println("Closing...");
    }
}
