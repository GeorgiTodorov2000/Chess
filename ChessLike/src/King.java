import java.awt.Color;
import java.awt.Graphics;

public class King {
    private int row;
    private int col;
    private String color;
    private int tileSize;

    public King(int row, int col) {
        this.row = row;
        this.col = col;
        this.tileSize = 100;
    }

    public void render(Graphics g) {
        int tileX = this.col * this.tileSize;
        int tileY = this.row * this.tileSize;
        if(this.row == 1 && this.col == 5) {
            g.setColor(Color.YELLOW);
            g.fillRect(tileX + 25, tileY + 25, 50, 50);

        }
        if(this.row == 5 && this.col == 1) {
            g.setColor(Color.GREEN);
            g.fillRect(tileX + 25, tileY + 25, 50, 50);
        }

    }
    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }
}