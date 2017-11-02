package mobi.mpk.chessandroid.interactor.out;

import mobi.mpk.chessandroid.interactor.stategame.StateGame;
import mobi.mpk.chessandroid.presenter.game.in.GamePresenterIn;

public class NetInteractorOut implements InteractorOut {

    private GamePresenterIn presenter;

    private StateGame stateGame;

    public NetInteractorOut(GamePresenterIn presenter, StateGame stateGame) {

        this.presenter = presenter;
        this.stateGame = stateGame;

    }

    @Override
    public void sendMove(String move) {

        presenter.makeMove(move);

    }

    @Override
    public void abortGame() {

        presenter.stopGame();

    }

}
