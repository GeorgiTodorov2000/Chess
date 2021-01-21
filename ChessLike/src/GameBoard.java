import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoard extends JFrame implements MouseListener {
    public static final int TILE_SIDE_COUNT = 7;
    private Object[][] pieceCollection;
    private Object selectedPiece;
    public int OriginalRow = 0;
    public int OriginalCol = 0;

    public GameBoard() {
    //TODO Намери решение за "лидера". Дава грешка защото се опитваш да го направиш Guard!!
        this.pieceCollection = new Object[TILE_SIDE_COUNT][TILE_SIDE_COUNT];
        this.pieceCollection[1][1]=(new Guard(1, 1, Color.GREEN, Color.YELLOW));
        this.pieceCollection[1][2]=(new Guard(1, 2, Color.GREEN, Color.YELLOW));
        this.pieceCollection[1][3]=(new Guard(1, 3, Color.GREEN, Color.YELLOW));
        this.pieceCollection[1][4]=(new Guard(1, 4, Color.GREEN, Color.YELLOW));
//        this.pieceCollection[1][5]=(new King(1, 5));
//        this.pieceCollection[5][1]=(new King(5, 1));
        this.pieceCollection[5][2]=(new Guard(5, 2, Color.YELLOW, Color.GREEN));
        this.pieceCollection[5][3]=(new Guard(5, 3, Color.YELLOW, Color.GREEN));
        this.pieceCollection[5][4]=(new Guard(5, 4, Color.YELLOW, Color.GREEN));
        this.pieceCollection[5][5]=(new Guard(5, 5, Color.YELLOW, Color.GREEN));
        this.setSize(700, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);


    }
    @Override
    public void mouseClicked(MouseEvent e) {

            if (this.selectedPiece == null) {
                OriginalRow = this.getBoardDimensionBasedOnCoordinates(e.getY());
                OriginalCol = this.getBoardDimensionBasedOnCoordinates(e.getX());
            }

            int row = this.getBoardDimensionBasedOnCoordinates(e.getY());
            int col = this.getBoardDimensionBasedOnCoordinates(e.getX());




            if (this.selectedPiece != null) {

                Guard guard = (Guard) this.selectedPiece;
                guard.move(row, col);
                //TODO Записва новите координати на фигурата, но не я пуска!? Разбери защо!!!

//                this.pieceCollection[row][col] = this.selectedPiece;
//                this.pieceCollection[OriginalRow][OriginalCol] = null;

                this.selectedPiece = null;
                this.repaint();
            }

            // check if piece is available
            if (this.hasBoardPiece(row, col)) {

                this.selectedPiece = this.getBoardPiece(row, col);
            }


    }
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    // Painting the game board
    public void paint(Graphics g) {
        super.paint(g);

        for(int row = 1; row < 6; ++row) {
            for(int col = 1; col < 6; ++col) {
                GameTile tile = new GameTile(row, col);
                tile.render(g);


                if(this.hasBoardPiece(row, col)) {

                    Guard guard = (Guard)this.getBoardPiece(row, col);
                    guard.render(g);


                }
                King king = new King(row, col);
                    king.render(g);


            }
        }
        Point point = new Point(3, 3);
        point.render(g);
    }


    private Object getBoardPiece(int row, int col) {
        return this.pieceCollection[row][col];
    }
    private boolean hasBoardPiece(int row, int col) {
        return this.getBoardPiece(row, col) != null;
    }
    private int getBoardDimensionBasedOnCoordinates(int coordinates) {
        return coordinates / 100;
    }
}

