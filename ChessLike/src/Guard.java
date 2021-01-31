

import java.awt.Color;
import java.awt.Graphics;


public class Guard extends Figure{

    public Guard(int row, int col, Color color1, Color color2, int id) {
        super(row, col, color1, color2, id);
    }



    public void render(Graphics g) {


        int tileX = this.col * this.tileSize;
        int tileY = this.row * this.tileSize;


        g.setColor(this.color1);
        g.fillOval(tileX + 20, tileY + 20, 60, 60);
        g.setColor(this.color2);
        g.fillOval(tileX + 25, tileY + 25, 50, 50);


    }


    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }
}