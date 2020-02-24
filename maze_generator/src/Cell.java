import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Cell {
    int x;
    int y;
    int xIndex;
    int yIndex;
    Boolean[] walls;
    Boolean visited;
    Boolean solution;
    ArrayList<Cell> neighbors = new ArrayList<Cell>();
    Color color;
    //float solutionIndex;

    public Cell(int xPos, int yPos, int w) {
        x = xPos*w;
        y = yPos*w;
        xIndex = xPos;
        yIndex = yPos;
        walls = new Boolean[]{true, true, true, true};

        Random ran = new Random();
        /*
        int n = ran.nextInt(3);
        walls[n] = true;
         */
        solution = false;
        visited = false;
    }

    public Cell checkNeighbors(Cell[] grid, int cols, int rows) {
        neighbors.clear();

        int topIndex = index(xIndex, yIndex-1, cols, rows);
        int rightIndex = index(xIndex+1, yIndex, cols, rows);
        int bottomIndex = index(xIndex, yIndex+1, cols, rows);
        int leftIndex = index(xIndex-1, yIndex, cols, rows);
        Cell top = null;
        Cell right = null;
        Cell bottom = null;
        Cell left = null;

        if (topIndex != -1) {
            top = grid[topIndex];
        }
        if (rightIndex != -1) {
            right = grid[rightIndex];
        }
        if (bottomIndex != -1) {
            bottom = grid[bottomIndex];
        }
        if (leftIndex != -1) {
            left = grid[leftIndex];
        }
        if (top != null) {
            if (!top.visited) {
                neighbors.add(top);
                //System.out.println("top");
            }
        }
        if (right != null) {
            if (!right.visited) {
                neighbors.add(right);
                //System.out.println("right");
            }
        }
        if (bottom != null) {
            if (!bottom.visited) {
                neighbors.add(bottom);
                //System.out.println("bottom");
            }
        }
        if (left != null) {
            if (!left.visited) {
                neighbors.add(left);
                //System.out.println("left");
            }
        }

        if (neighbors.size() > 0) {
            if (neighbors.size() == 1) {
                return neighbors.get(0);
            }
            Random ran = new Random();
            int n = ran.nextInt(neighbors.size());
            return neighbors.get(n);
        } else {
            return null;
        }
    }

    public int index(int x, int y, int cols, int rows) {
        if (x < 0 || y < 0 || x > cols-1 || y > rows-1) {
            return -1;
        }
        return x + y * cols;
    }
}
