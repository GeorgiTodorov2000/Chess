

import java.awt.Color;
import java.awt.Graphics;


public class Turtle extends Figure {


    public Turtle(int row, int col, Color color, Color color1, int id) {
        super(row, col, color, color1, id);
    }


    public void render(Graphics g) {
        int tileX = this.col * this.tileSize;
        int tileY = this.row * this.tileSize;


        g.setColor(Color.WHITE);
        g.fillOval(tileX + 20, tileY + 20, 60, 60);
        g.setColor(Color.RED);
        g.fillOval(tileX + 25, tileY + 25, 50, 50);


    }
}