package mobi.mpk.chessandroid.model.rules.rule.order.figure;

import java.util.List;

import mobi.mpk.chessandroid.model.figure.Figure;
import mobi.mpk.chessandroid.type.Color;

public interface OrderFigureRule {

    List<Figure> orderFigure(Color color);

}
