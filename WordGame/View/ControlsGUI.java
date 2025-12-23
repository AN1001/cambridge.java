package WordGame.View;

import WordGame.Game;
import WordGame.View.Buttons.NewGameButton;
import WordGame.View.Buttons.SubmitButton;

import javax.swing.*;

public class ControlsGUI extends JPanel {
    public ControlsGUI(Game game){
        add(new NewGameButton(game));
        add(new SubmitButton(game));
        add(game.getScoreGUI());
    }
}
