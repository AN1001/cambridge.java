package WordGame.GameElements;

import WordGame.Grid.Grid;
import WordGame.Grid.GridGUI;
import WordGame.View.TileGUI;

import java.util.List;

public class BoardGUI {
    private final GridGUI<Tile> boardGUI;

    public BoardGUI(Grid<Tile> grid, TileGUIFactory tileGUIFactory){
        boardGUI = new GridGUI<>(grid, tileGUIFactory);
    }

    public void makeTilesDeselected(List<Coordinate> coordinates){
        for (Coordinate c: coordinates){
            makeTileDeselected(c);
        }
    }

    public void makeTilesSelected(List<Coordinate> coordinates){
        for (Coordinate c: coordinates){
            makeTileSelected(c);
        }
    }

    public void makeTileDeselected(Coordinate c){
        ((TileGUI) boardGUI.getElementGUI(c)).makeDeselected();
    }

    public void makeTileSelected(Coordinate c){
        ((TileGUI) boardGUI.getElementGUI(c)).makeSelected();
    }

    public void makeTileUsed(Coordinate c){
        ((TileGUI) boardGUI.getElementGUI(c)).makeUsed();
    }

    public GridGUI<Tile> getGUI(){
        return boardGUI;
    }
}
