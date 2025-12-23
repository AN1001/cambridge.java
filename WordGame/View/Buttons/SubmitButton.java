package WordGame.View.Buttons;

import WordGame.Game;

import java.awt.*;

public class SubmitButton extends ControlButtonGUI {

    public SubmitButton(Game game) {
        super("Submit Word", game);
    }

    @Override
    public void onClick() {
        game.onSubmitClick();
    }
}
