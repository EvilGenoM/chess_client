package mobi.mpk.chessandroid.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.controller.GameController;
import mobi.mpk.chessandroid.model.User;
import mobi.mpk.chessandroid.model.game.ClassicGame;
import mobi.mpk.chessandroid.model.game.Game;

public class GameActivity extends AppCompatActivity {

    private Game game;

    @Inject
    GameController gameController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        game = new ClassicGame(new User("One"), new User("Two"));
        MainActivity.getComponent().inject(this);
        gameController.setGame(game);

        setContentView(R.layout.activity_game);
    }

}