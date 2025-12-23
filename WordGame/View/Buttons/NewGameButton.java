package WordGame.View.Buttons;

import WordGame.Game;

import java.awt.*;

public class NewGameButton extends ControlButtonGUI{

    public NewGameButton(Game game) {
        super("New Game", game);
        setPreferredSize(new Dimension(250, 75));
    }

    @Override
    public void onClick() {
        game.newGame();
    }
}
