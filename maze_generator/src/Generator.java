import java.util.ArrayList;
import java.util.Stack;

public class Generator {

    private int cols, rows, w;
    Cell[] grid;
    Display display;
    Cell current;
    Cell next;
    Stack<Cell> stack = new Stack<Cell>();
    Boolean running = true;
    Boolean s;

    public Generator(String title, int width, int height, int pixels, Boolean solutions) {
        w = pixels;
        cols = width/w;
        rows = height/w;
        grid = new Cell[cols*rows];
        s = solutions;

        display = new Display(title, width, height);
        Generate(width, height);
    }

    public void Generate(int width, int height) {
        int counter = 0;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                grid[counter] = new Cell(x, y, w);
                counter += 1;
            }
        }
        current = grid[0];
        display.canvas.showMaze(w, cols, rows, grid, s);
        //moveCell();
        while (running) {
            Boolean c = false;
            moveCell();
            if (current.xIndex == cols-1 && current.yIndex == rows-1) {
                current.solution = true;
                //current.solutionIndex = 1;
            }
            if (current.xIndex == 0 && current.yIndex == 0) {
                running = false;
            }
        }
    }

    public void moveCell() {

        display.canvas.showMaze(w, cols, rows, grid, s);
        current.visited = true;
        next = current.checkNeighbors(grid, cols, rows);
        if (next != null) {
            next.visited = true;

            stack.push(current);
            removeWalls(current, next);
            current = next;
        } else if (stack.size() > 0) {
            Cell previous = stack.pop();
            if (current.solution) {
                previous.solution = true;
                //previous.solutionIndex = (float) (current.solutionIndex + 0.5/Math.sqrt(cols*cols + rows*rows));
            }
            current = previous;
        }
    }

    public void removeWalls(Cell current, Cell next) {
        int xDiff = current.xIndex - next.xIndex;

        if (xDiff == 1) {
            current.walls[3] = false;
            next.walls[1] = false;
        } else if (xDiff == -1) {
            current.walls[1] = false;
            next.walls[3] = false;
        }
        int yDiff = current.yIndex - next.yIndex;
        if (yDiff == 1) {
            current.walls[0] = false;
            next.walls[2] = false;
        } else if (yDiff == -1) {
            current.walls[2] = false;
            next.walls[0] = false;
        }
    }

}
