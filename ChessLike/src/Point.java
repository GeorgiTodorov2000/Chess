

import java.awt.Color;
import java.awt.Graphics;

public class Point {
    private int row;
    private int col;
    private int tileSize;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
        this.tileSize = 100;
    }

    public void render(Graphics g) {
        int tileX = this.col * this.tileSize;
        int tileY = this.row * this.tileSize;
        g.setColor(new Color(119,119,119));
        g.fillOval(tileX+35, tileY+35, 30, 30);
    }
}
