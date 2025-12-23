package WordGame.View;

import WordGame.GameElements.Tile;
import WordGame.Grid.GridGUI;

import javax.swing.*;

public class View extends JFrame{
    public View(String windowName){
        super(windowName);
        setResizable(true);
    }

    public void drawGUI(GridGUI<Tile> boardGUI, ControlsGUI controlsGUI){
        JPanel UI = new JPanel();
        UI.setLayout(new BoxLayout(UI, BoxLayout.Y_AXIS));

        UI.add(boardGUI);
        UI.add(controlsGUI);
        add(UI);

        pack();
        setVisible(true);
    }
}
