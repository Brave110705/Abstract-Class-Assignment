import java.util.List;
import java.util.ArrayList;

/**
 * Support Class: Field
 * Represents the environment/grid where animals live
 */
public class Field {

    private Object[][] grid;
    
    public Field(int height, int width) {
        grid = new Object[height][width];
    }
    
    public int getHeight() {
        return grid.length;
    }
    
    public int getWidth() {
        return grid[0].length;
    }
    
    public void clear(Position pos) {
        grid[pos.getRow()][pos.getCol()] = null;
    }
    
    public void place(Object obj, Position pos) {
        grid[pos.getRow()][pos.getCol()] = obj;
    }
    
    public Object getObjectAt(Position pos) {
        return grid[pos.getRow()][pos.getCol()];
    }
    
    public Position getFreeAdjacentPosition(Position pos) {
        List<Position> freeSpots = new ArrayList<>();
        for (Position adjacent : getAdjacentPositions(pos)) {
            if (getObjectAt(adjacent) == null) {
                freeSpots.add(adjacent);
            }
        }
        return freeSpots.isEmpty() ? null : freeSpots.get(0);
    }
    
    public List<Position> getAdjacentPositions(Position pos) {
        List<Position> positions = new ArrayList<>();
        int row = pos.getRow();
        int col = pos.getCol();
        
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue;
                
                int newRow = row + dr;
                int newCol = col + dc;
                
                if (newRow >= 0 && newRow < grid.length &&
                    newCol >= 0 && newCol < grid[0].length) {
                    positions.add(new Position(newRow, newCol));
                }
            }
        }
        return positions;
    }

    public void printFieldWithStats() {
        int foxCount = 0;
        int rabbitCount = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                Object animal = grid[row][col];
                if (animal instanceof Fox) {
                    System.out.print("X ");
                    foxCount++;
                } else if (animal instanceof Rabbit) {
                    System.out.print("o ");
                    rabbitCount++;
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }

        System.out.println("---------------------------");
        System.out.println("Total Foxes (X): " + foxCount);
        System.out.println("Total Rabbits (o): " + rabbitCount);
        System.out.println();
    }
}
