import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameBoard extends JFrame {
    private ArrayList<Object> pieceCollection = new ArrayList();

    public GameBoard() {

        this.pieceCollection.add(new Guard(1, 0));
        this.pieceCollection.add(new Guard(1, 1));
        this.pieceCollection.add(new Guard(1, 2));
        this.pieceCollection.add(new Guard(1, 3));
        this.pieceCollection.add(new King(1, 4));
        this.pieceCollection.add(new King(5, 0));
        this.pieceCollection.add(new Guard(5, 1));
        this.pieceCollection.add(new Guard(5, 2));
        this.pieceCollection.add(new Guard(5, 3));
        this.pieceCollection.add(new Guard(5, 4));
        this.setSize(700, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }

    public void paint(Graphics g) {
        super.paint(g);

        for(int row = 1; row < 6; ++row) {
            for(int col = 1; col < 6; ++col) {
                GameTile tile = new GameTile(row, col);
                tile.render(g);

                Guard p1 = new Guard(row, col);
                p1.render(g);

                King p2 = new King(row, col);
                p2.render(g);
            }
        }
        Point p = new Point(3, 3);
        p.render(g);
    }
}

