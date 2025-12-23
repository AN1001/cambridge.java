package WordGame.GameElements;

import WordGame.Game;
import WordGame.Grid.GridElementGUIFactory;
import WordGame.View.TileGUI;

public class TileGUIFactory implements GridElementGUIFactory<Tile> {
    private final Game game;
    public TileGUIFactory(Game game){
        this.game = game;
    }

    @Override
    public TileGUI create(Tile tile, int x, int y) {
        TileGUI tileGUI = new TileGUI(tile);
        tileGUI.addActionListener(_ -> onClick(x, y));

        return tileGUI;
    }

    private void onClick(int x, int y){
        game.onTileClick(x, y);
    }
}