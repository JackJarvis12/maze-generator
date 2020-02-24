import javax.swing.*;
import java.awt.*;

public class Display {

    private JFrame frame;
    public MyCanvas canvas;

    private String title;
    private int width, height;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        canvas = new MyCanvas();

        frame.add(canvas);
        frame.pack();
    }

    class MyCanvas extends Canvas
    {
        private int cols;
        private int rows;
        public int w;
        Cell[] grid;
        Boolean s;

        public MyCanvas() {
            setSize(width, height);
        }
        public void paint(Graphics g) {
            for (int i = 0; i < grid.length; i++) {
                g.setColor(Color.BLACK);
                if (grid[i].walls[0]) {
                    g.drawLine(grid[i].x, grid[i].y, grid[i].x + w, grid[i].y);
                }
                if (grid[i].walls[1]) {
                    g.drawLine(grid[i].x + w, grid[i].y, grid[i].x + w, grid[i].y + w);
                }
                if (grid[i].walls[2]) {
                    g.drawLine(grid[i].x + w, grid[i].y + w, grid[i].x, grid[i].y + w);
                }
                if (grid[i].walls[3]) {
                    g.drawLine(grid[i].x, grid[i].y + w, grid[i].x, grid[i].y);
                }
                if (s && grid[i].solution) {
                    g.setColor(new Color(0, 0, 255, 127));
                    g.fillRect(grid[i].x, grid[i].y, w, w);
                }
            }
        }
        public void showMaze(int w, int cols, int rows, Cell[] grid, Boolean s) {
            this.w = w;
            this.cols = cols;
            this.rows = rows;
            this.grid = grid;
            this.s = s;
            repaint();
        }
    }

}
