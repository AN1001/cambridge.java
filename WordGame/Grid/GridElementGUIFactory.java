package WordGame.Grid;

import javax.swing.*;

public interface GridElementGUIFactory<T> {
    /**
     * create() creates a renderable element (e.g. JButton) based off the
     * implementation from a grid element
     */
    JButton create(T element, int x, int y);
}