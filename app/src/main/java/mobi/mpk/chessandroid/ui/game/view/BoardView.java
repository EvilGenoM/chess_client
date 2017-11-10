package mobi.mpk.chessandroid.ui.game.view;

import java.util.List;

public class BoardView {

    private int AMOUNT_CELL = 8;

    private int top;
    private int left;
    private int lengthSide;

    private CellView[][] cellView;
    private List<String> listCoordinateCells;

    public BoardView(int lengthSide) {
        this(0, 0, lengthSide);
    }

    public BoardView(int left, int top, int lengthSide) {
        this.top = top;
        this.left = left;
        this.lengthSide = lengthSide;
        update();
    }

    private void initBoard() {

        cellView = new CellView[AMOUNT_CELL][AMOUNT_CELL];

        int x = 0;
        int y = 0;
        int size = lengthSide / 8;

        for (int i = 0; i < AMOUNT_CELL; i++) {

            for (int j = 0; j < AMOUNT_CELL; j++) {
                cellView[i][j] = new CellView(x, y, size);
                x += size;
            }

            x = 0;
            y += size;

        }

    }

    public void onDrawBoard(boolean coordinateBoard) {

        for (int i = 0; i < AMOUNT_CELL; i++) {

            for (int j = 0; j < AMOUNT_CELL; j++) {
                cellView[i][j].onDrawCell();
            }

        }

        for (int i = 0; i < AMOUNT_CELL; i++) {

            for (int j = 0; j < AMOUNT_CELL; j++) {
                cellView[i][j].onDrawFigure();
            }

        }

        if(coordinateBoard){

            char a = 'a';

            for (int i = 0; i < AMOUNT_CELL; i++) {

                cellView[7][i].onDrawChar(a);

                a++;

            }

            for (int i = 0; i < AMOUNT_CELL; i++) {

                cellView[i][7].onDrawNumber(8-i);

            }

        }

    }

    public String getCoordinateCell(int x, int y) {
        String coordinateCell = "";
        for (int i = 0; i < AMOUNT_CELL; i++) {

            for (int j = 0; j < AMOUNT_CELL; j++) {
                if (cellView[i][j].belongsCell(x, y)) {
                    coordinateCell = cellView[i][j].getCoordinateCell();
                }
            }

        }

        return coordinateCell;
    }

    public String highlightFigure(int x, int y) {
        String coordinateCell = "";
        for (int i = 0; i < AMOUNT_CELL; i++) {

            for (int j = 0; j < AMOUNT_CELL; j++) {
                if (cellView[i][j].belongsCell(x, y)) {
                    cellView[i][j].onDrawFigure(x, y);
                }
            }

        }

        return coordinateCell;
    }

    public void setListCoordinateCells(List<String> listCoordinateCells) {
        this.listCoordinateCells = listCoordinateCells;
    }

    public void update() {

        initBoard();

    }

    public void setHighLightCell(String coordinateCell) {

        for (int i = 0; i < AMOUNT_CELL; i++) {

            for (int j = 0; j < AMOUNT_CELL; j++) {
                String coordCell = cellView[i][j].getCoordinateCell();

                if(coordCell.equals(coordinateCell)){

                    cellView[i][j].setHeighLight();

                }

            }

        }

    }

    public void moveFigure(int onTouchX, int onTouchY, int x, int y) {

        for (int i = 0; i < AMOUNT_CELL; i++) {

            for (int j = 0; j < AMOUNT_CELL; j++) {
                if (cellView[i][j].belongsCell(onTouchX, onTouchY)) {
                    y = y - 70;
                    cellView[i][j].onDrawFigureThisCoordinate(x-40, y-70);
                    String coord = getCoordinateCell(x, y);
                    setHighLightCell(coord);
                }
            }

        }

    }

}