import javafx.scene.canvas.GraphicsContext;


class Paddle {
    private int x, y;
    private int width, height;


    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = Settings.PADDLE_WIDTH;
        this.height = Settings.PADDLE_HEIGHT;
    }


    public void render(GraphicsContext gc) {
        gc.setFill(Settings.COLOR_FOREGROUND);
        gc.fillRect(this.x, this.y, this.width, this.height);
    }


    public void moveUp() {
        if(this.y > 0) {
            this.y -= Settings.PADDLE_SPEED;
        }
    }


    public void moveDown() {
        if(this.y + this.height < Settings.SCREEN_HEIGHT) {
            this.y += Settings.PADDLE_SPEED;
        }
    }
}
