import java.awt.Color;
import java.awt.Graphics;

public class King extends Figure{

    public King(int row, int col, Color color1, Color color2, int id) {
        super(row, col, color1, color2, id);
    }


    public void render(Graphics g) {
        int tileX = this.col * this.tileSize;
        int tileY = this.row * this.tileSize;
            g.setColor(Color.YELLOW);
            g.fillRect(tileX + 25, tileY + 25, 50, 50);


    }



    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }
}