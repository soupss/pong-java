import javafx.scene.canvas.GraphicsContext;


class Ball {
    private int x, y;
    private int size;
    private int dirX, dirY;

    public int getX() { return this.x;}
    public int getY() { return this.y;}


    public Ball(int x,int  y) {
        this.x = x;
        this.y = y;
        this.size = Settings.BALL_SIZE;
        //TODO: randomize dir
        this.dirX = this.dirY = 1;
    }


    public void update() {
        this.x += this.dirX * Settings.BALL_SPEED;
        this.y += this.dirY * Settings.BALL_SPEED;
    }


    public void setDirX(int dir) {
        this.dirX = dir;
    }


    public void setDirY(int dir) {
        this.dirY = dir;
    }


    public void render(GraphicsContext gc) {
        gc.setFill(Settings.COLOR_FOREGROUND);
        gc.fillRect(this.x, this.y, this.size, this.size);
    }
}
