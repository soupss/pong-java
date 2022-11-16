import javafx.stage.Stage;
import javafx.application.Platform;
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
    private Stage stage;
    private Group root;
    private Scene scene;
    private Canvas canvas;
    private GraphicsContext gc;

    private Paddle player;
    private Paddle enemy;

    private ArrayList<String> input = new ArrayList<String>();

    public Game(Stage stage) {
        this.stage = stage;
        this.root = new Group();
        this.scene = new Scene(this.root);
        this.canvas = new Canvas(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
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

        this.player = new Paddle(Settings.PADDLE_OFFSET, Settings.SCREEN_HEIGHT/2 - Settings.PADDLE_HEIGHT/2);
        this.enemy = new Paddle(Settings.SCREEN_WIDTH - Settings.PADDLE_WIDTH - Settings.PADDLE_OFFSET, Settings.SCREEN_HEIGHT/2 - Settings.PADDLE_HEIGHT/2);
    }


    public void update() {
        this.gc.setFill(Settings.COLOR_BACKGROUND);
        this.handleInput();
        this.gc.fillRect(0,0, Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
    }


    private void handleInput() {
        if(!input.isEmpty()) System.out.println(input);
        if(input.contains("ESCAPE")) Platform.exit();
        // movement
        if(input.contains("D")) this.player.moveDown();
        if(input.contains("F")) this.player.moveUp();
        if(input.contains("J")) this.enemy.moveDown();
        if(input.contains("K")) this.enemy.moveUp();
    }


    public void render() {
        this.stage.show();
        this.player.render(this.gc);
        this.enemy.render(this.gc);
    }
}
