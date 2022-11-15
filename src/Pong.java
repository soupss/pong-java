import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Pong extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800,600);
        scene.setFill(Color.GREEN);
        stage.setScene(scene);
        stage.show();
    }
}
