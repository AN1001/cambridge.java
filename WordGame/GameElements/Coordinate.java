package WordGame.GameElements;

public record Coordinate(int x, int y) {
    public Coordinate subtract(Coordinate c){
        return new Coordinate(x - c.x, y - c.y);
    }
    public Coordinate add(Coordinate c){
        return new Coordinate(x + c.x, y + c.y);
    }
    public boolean equals(Coordinate c) {
        return (x==c.x && y==c.y);
    }
}
