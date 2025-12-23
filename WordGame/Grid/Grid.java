package WordGame.Grid;

/**
 * A Grid is just a 2D collection of Objects (of any kind).
 */
public class Grid<T> {
    private final T[][] cells;
    private final int width;
    private final int height;

    public Grid(int height, int width){
        this.height = height;
        this.width = width;

        if(width < 1 || height < 1){
            throw new IllegalArgumentException("One of board dimensions is not positive");
        } else {
            cells = (T[][]) new Object[height][width];
        }
    }

    public int getWidth(){ return width; }
    public int getHeight(){ return height; }

    public T getCell(int x, int y){
        return cells[y][x];
    }

    public void setCell(int x, int y, T cell){
        cells[y][x] = cell;
    }

    @Override
    public String toString(){
        StringBuilder out = new StringBuilder();
        for (T[] row: cells){
            for (T cell: row){
                out.append(cell.toString());
            }
            out.append('\n');
        }
        return out.toString();
    }
}
