package WordGame;

import WordGame.GameElements.*;
import WordGame.View.ControlsGUI;
import WordGame.View.ScoreGUI;
import WordGame.View.View;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class Game {
    private Board board;
    private BoardGUI boardGUI;
    private ScoreGUI scoreGUI;
    private final View window;
    private static final List<String> words;
    private int score = 0;

    static {
        try {
            words = Files.readAllLines(Path.of("WordGame/Data/words.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Game(){
        window = new View("Word Game");
        newGame();
    }

    public void newGame(){
        score = 0;
        board = new Board(6,6);
        boardGUI = new BoardGUI(board.getGrid(), new TileGUIFactory(this));
        scoreGUI = new ScoreGUI();
        ControlsGUI controlsGUI = new ControlsGUI(this);

        window.getContentPane().removeAll();
        window.revalidate();
        window.repaint();
        window.drawGUI(boardGUI.getGUI(), controlsGUI);
    }

    public void onTileClick(int x, int y){
        Coordinate clickedTile = new Coordinate(x, y);
        boardGUI.makeTilesDeselected(board.getActiveTiles());
        boardGUI.makeTilesSelected(board.toggleTile(clickedTile));
    }

    public ScoreGUI getScoreGUI(){
        return scoreGUI;
    }

    public void onSubmitClick(){
        String word = board.getSelectedWord();
        if(isValidWord(word)){
            score += board.getSelectedWordScore();
            board.makeActiveTilesUsed();
            for(Coordinate c : board.getUsedTiles()){
                boardGUI.makeTileUsed(c);
            }
        }
        scoreGUI.updateScore(score);
    }

    private boolean isValidWord(String word){
        int index = Collections.binarySearch(words, word.toLowerCase());
        return index >= 0;
    }
}