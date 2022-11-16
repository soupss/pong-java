import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.event.EventHandler;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;

class Game {
    public Stage stage;
    public Group root;
    public Scene scene;
    public Canvas canvas;
    public GraphicsContext gc;
    final static int WINDOW_WIDTH = 800;
    final static int WINDOW_HEIGHT = 600;

    private ArrayList<String> input = new ArrayList<String>();

    public Game(Stage stage) {
        this.stage = stage;
        this.root = new Group();
        this.scene = new Scene(this.root);
        this.canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.gc = this.canvas.getGraphicsContext2D();

        this.stage.setTitle("Pong");
        this.stage.setScene(this.scene);
        this.root.getChildren().add(this.canvas);

        this.scene.setOnKeyPressed(
            new EventHandler<KeyEvent>() {
                public void handle(KeyEvent e) {
                    String code = e.getCode().toString();
                    if (!input.contains(code)) {
                        input.add(code);
                    }
                }
        });
        this.scene.setOnKeyReleased(
            new EventHandler<KeyEvent>() {
                public void handle(KeyEvent e) {
                    String code = e.getCode().toString();
                    input.remove(code);
                }
        });
    }


    public void update() {
        this.gc.setFill(Color.TEAL);
        this.handleInput();
        this.gc.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
    }


    public void render() {
        this.stage.show();
    }


    private void handleInput() {
        if(input.contains("G")) gc.setFill(Color.GREEN);
        if(input.contains("B")) gc.setFill(Color.BLUE);
        if(input.contains("R")) gc.setFill(Color.RED);
    }
}
