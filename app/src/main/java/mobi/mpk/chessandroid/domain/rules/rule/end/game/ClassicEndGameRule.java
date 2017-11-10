package mobi.mpk.chessandroid.domain.rules.rule.end.game;


import mobi.mpk.chessandroid.domain.Board;
import mobi.mpk.chessandroid.domain.figure.King;
import mobi.mpk.chessandroid.type.Color;

public class ClassicEndGameRule implements EndGameRule {

    private Color colorWinner;

    @Override
    public boolean checkRule(Board board) {

        if (!board.existFigure(new King(Color.white))) {

            colorWinner = Color.black;
            return true;

        } else if (!board.existFigure(new King(Color.black))) {

            colorWinner = Color.white;
            return true;

        } else {
            return false;
        }

    }

    @Override
    public Color getColorWinner() {
        return colorWinner;
    }
}