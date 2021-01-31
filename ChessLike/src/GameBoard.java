import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class GameBoard extends JFrame implements MouseListener {
    public static final int TILE_SIDE_COUNT = 7;
    private Object[][] pieceCollection;
    private Object selectedPiece;
    public GameBoard() {

        this.pieceCollection = new Object[TILE_SIDE_COUNT][TILE_SIDE_COUNT];
        Random random = new Random();

        int turtleCount = 0;
        while (turtleCount != 2) {
            int i = random.nextInt(5);
            i++;
            if(this.hasBoardPiece(3, i) && i != 5) {
                i++;
            } else if (this.hasBoardPiece(3, i) && i == 5) {
                i = random.nextInt(5);
                i++;
            }

            if (i == 3) {
                this.pieceCollection[3][++i] = (new Turtle(3, ++i, Color.RED, Color.WHITE, 3));
            } else {
                this.pieceCollection[3][i] = (new Turtle(3, i, Color.RED, Color.WHITE, 3));
            }
            System.out.println(3 + "" + i);
            ++turtleCount;

        }


        this.pieceCollection[1][1]=(new Guard(1, 1, Color.GREEN, Color.YELLOW, 1));
        this.pieceCollection[1][2]=(new Guard(1, 2, Color.GREEN, Color.YELLOW,1));
        this.pieceCollection[1][3]=(new Guard(1, 3, Color.GREEN, Color.YELLOW,1));
        this.pieceCollection[1][4]=(new Guard(1, 4, Color.GREEN, Color.YELLOW,1));
        this.pieceCollection[1][5]=(new King(1, 5,Color.YELLOW, null, 2));
        this.pieceCollection[5][1]=(new King(5, 1,Color.GREEN, null, 2));
        this.pieceCollection[5][2]=(new Guard(5, 2, Color.YELLOW, Color.GREEN,1));
        this.pieceCollection[5][3]=(new Guard(5, 3, Color.YELLOW, Color.GREEN,1));
        this.pieceCollection[5][4]=(new Guard(5, 4, Color.YELLOW, Color.GREEN,1));
        this.pieceCollection[5][5]=(new Guard(5, 5, Color.YELLOW, Color.GREEN,1));
        this.setSize(700, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);


    }



    @Override
    public void mouseClicked(MouseEvent e) {
        Figure figure = (Figure) this.selectedPiece;

        int row = this.getBoardDimensionBasedOnCoordinates(e.getY());
        int col = this.getBoardDimensionBasedOnCoordinates(e.getX());

        if (this.selectedPiece != null) {

            //Записва новите координати на фигурата, но фигурата оставя избрана.
            //Не успях да разбера, защо се бъгва така.
            int initialRow = figure.getRow();
            int initialCol = figure.getCol();

            figure.move(row, col);

            this.pieceCollection[figure.getRow()][figure.getCol()] = this.selectedPiece;
            if (this.selectedPiece != null) {
                System.out.println("Piece was dropped");
                this.selectedPiece = null;
            }
            this.pieceCollection[initialRow][initialCol] = null;

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


                //Прави проверка дали има фигура и я render
                if(this.hasBoardPiece(row, col)) {
                    Figure figure = (Figure) this.getBoardPiece(row, col);
                    figure.render(g);
               }


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

