
import java.awt.Color;
import java.awt.Graphics;

public class GameTile {

    public static final int TILE_SIZE = 100;


    private int row;
    private int col;



    public GameTile(int row, int col) {
        this.row = row;
        this.col = col;

    }

    public void render(Graphics g) {
        int tileX = this.col * this.TILE_SIZE;
        int tileY = this.row * this.TILE_SIZE;
        g.setColor(Color.BLACK);
        g.drawRect(100, 100, 500, 500);
        g.drawRect(100, 300, 500, 100);
        g.drawRect(100, 200, 500, 300);
        g.drawRect(200, 100, 300, 500);
        g.drawRect(300, 100, 100, 500);
        if (this.row == 1 || this.row == 5 || this.row == 3) {
            g.setColor(new Color(68,68,68));
        } else {
            g.setColor(new Color(170,170,170));
        }
        if (this.row == 5 && this.col == 2 || this.row == 5 && this.col == 4 || this.row == 1 && this.col == 1 || this.row == 1 && this.col == 5) {
            g.setColor(new Color(255,99,71));
        }
        if (this.row == 3 ||  this.col == 3) {
            g.setColor(Color.WHITE);
        }


        g.fillRect(tileX, tileY, this.TILE_SIZE, this.TILE_SIZE);
    }
}