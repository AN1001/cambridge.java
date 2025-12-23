package WordGame.Grid;

import WordGame.GameElements.Coordinate;

import javax.swing.*;
import java.awt.*;

/**
 * GridGUI creates a Grid of UI elements
 * from a Grid of regular elements using a
 * provided factory
 */
public class GridGUI<T> extends JPanel{
    protected final GridElementGUIFactory<T> factory;
    protected final Grid<JButton> gridElementGUIs;

    public GridGUI(Grid<T> grid, GridElementGUIFactory<T> factory){
        this.factory = factory;
        super(new GridLayout(grid.getHeight(), grid.getWidth()));
        gridElementGUIs = new Grid<>(grid.getHeight(), grid.getWidth());
        fillGridElementGUIs(grid);
    }

    public JButton getElementGUI(Coordinate c){
        return gridElementGUIs.getCell(c.x(), c.y());
    }

    private void fillGridElementGUIs(Grid<T> grid){
        for (int y = 0; y < grid.getHeight(); y++) {
            for (int x = 0; x < grid.getWidth(); x++) {
                T cell = grid.getCell(x,y);
                JButton cellGUI = factory.create(cell, x, y);
                gridElementGUIs.setCell(x, y, cellGUI);
                add(cellGUI);
            }
        }
    }
}

