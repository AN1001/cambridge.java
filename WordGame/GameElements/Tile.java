package WordGame.GameElements;

/**
 * A Tile is just mainly a store of
 * a [letter] and a [character]
 */
public record Tile(char letter, int score) {
    @Override
    public String toString() {
        return ("[" + letter + score + "]");
    }
}
