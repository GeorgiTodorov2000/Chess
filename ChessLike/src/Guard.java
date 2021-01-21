

import java.awt.Color;
import java.awt.Graphics;


public class Guard {
    private int row;
    private int col;
    private int tileSize;
    private Color Color1;
    private Color Color2;

    public Guard(int row, int col, Color Color1, Color Color2) {
        this.row = row;
        this.col = col;
        this.tileSize = 100;
        this.Color1  = Color1;
        this.Color2 = Color2;
    }



    public void render(Graphics g) {
        int tileX = this.col * this.tileSize;
        int tileY = this.row * this.tileSize;


        g.setColor(this.Color1);
        g.fillOval(tileX + 20, tileY + 20, 60, 60);
        g.setColor(this.Color2);
        g.fillOval(tileX + 25, tileY + 25, 50, 50);


    }
    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }
}