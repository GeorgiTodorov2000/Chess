

import java.awt.*;

public abstract class Figure {

    protected int row;
    protected int col;
    protected Color color1;
    protected Color color2;
    protected int id;
    protected int tileSize = 100;

    public Figure(int row, int col, Color color1, Color color2, int id) {

        this.row = row;
        this.col = col;
        this.color1 = color1;
        this.color2 = color2;
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void render(Graphics g) {

        int tileX = this.col * GameTile.TILE_SIZE;
        int tileY = this.row * GameTile.TILE_SIZE;

        g.setColor(this.color1);
        g.fillRect(tileX, tileY, 50, 50);

        g.setColor(this.color2);
        g.fillOval(tileX + 25, tileY + 25, 50, 50);
    }



}