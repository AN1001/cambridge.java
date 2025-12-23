package WordGame.GameElements;

import WordGame.Grid.Grid;
import WordGame.Data.TileData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Board stores all the tiles and
 * handles their logic including
 * Randomising on startup
 */
public class Board {
    // NxN square of tiles
    private final Grid<Tile> board;
    private final List<Coordinate> activeTiles = new ArrayList<>();
    private final List<Coordinate> usedTiles = new ArrayList<>();

    public Board(int height, int width){
        board = new Grid<>(height, width);
        randomiseBoard();
    }

    public Grid<Tile> getGrid(){
        return board;
    }

    private void randomiseBoard(){
        for(int y=0; y<board.getHeight(); y++){
            for(int x=0; x<board.getWidth(); x++){
                board.setCell(x, y, getRandomTile());
            }
        }
    }

    public String getSelectedWord(){
        StringBuilder output = new StringBuilder();
        activeTiles.forEach(
                (c) -> output.append(board.getCell(c.x(), c.y()).letter())
        );
        return output.toString();
    }

    public int getSelectedWordScore(){
        int total = 1;
        for(Coordinate c: activeTiles){
            total *= board.getCell(c.x(), c.y()).score();
        }
        return total;
    }

    private Tile getRandomTile(){
        int index = getRandomIndex();
        return new Tile(
                TileData.LETTER[index],
                TileData.VALUE[index]
        );
    }

    private int getRandomIndex(){
        // Gets random index based off weights (in FREQUENCY)
        int num = ThreadLocalRandom.current().nextInt(98);

        int index = 0;
        for (int el: TileData.FREQUENCY){
            num -= el;
            if(num<0){return index;}
            index++;
        }

        return index;
    }

    public List<Coordinate> toggleTile(Coordinate clickedTile){
        if (!usedTiles.contains(clickedTile)) {
            if (activeTiles.contains(clickedTile)) {
                removeActiveTile(clickedTile);
            } else {
                addActiveTile(clickedTile);
            }
        }
        return activeTiles;
    }

    public List<Coordinate> getActiveTiles(){
        return activeTiles;
    }

    public List<Coordinate> getUsedTiles(){
        return usedTiles;
    }

    public void makeActiveTilesUsed(){
        usedTiles.addAll(activeTiles);
        activeTiles.clear();
    }

    private void removeActiveTile(Coordinate c){
        int index = activeTiles.indexOf(c);
        if(index==-1){
            throw new RuntimeException("Tried to remove a tile that was not selected");
        } else {
            activeTiles.subList(index, activeTiles.size()).clear();
        }
    }

    private void addActiveTile(Coordinate c) {
        if (activeTiles.isEmpty()) {
            activeTiles.add(c);
        }

        Coordinate first = activeTiles.getFirst();
        Coordinate last  = activeTiles.getLast();

        Coordinate direction = (activeTiles.size() > 1)
                ? activeTiles.get(1).subtract(activeTiles.getFirst())
                : c.subtract(first);

        if (c.equals(last.add(direction)) && isValidStep(direction)) {
            activeTiles.addLast(c);
        }

        if (c.equals(first.subtract(direction)) && isValidStep(direction)) {
            activeTiles.addFirst(c);
        }
    }

    private boolean isValidStep(Coordinate dir) {
        int maxDist = Math.max(Math.abs(dir.x()), Math.abs(dir.y()));
        return maxDist == 1;
    }
}
