package mobi.mpk.chessandroid.domain.figure.factory;


import mobi.mpk.chessandroid.domain.figure.Bishop;
import mobi.mpk.chessandroid.domain.figure.Figure;
import mobi.mpk.chessandroid.type.Color;

public class FactoryBishop extends FactoryFigure {

    @Override
    public Figure factoryMethod(Color color) {
        return new Bishop(color);
    }

}