package No_13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathFindingApp extends JFrame {
    private static final int GRID_SIZE = 10;
    private static final int CELL_SIZE = 50;

    private JPanel gridPanel;
    private JButton[][] gridButtons;
    private int[][] grid;

    public ShortestPathFindingApp() {
        setTitle("Shortest Path Finding");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        gridButtons = new JButton[GRID_SIZE][GRID_SIZE];
        grid = new int[GRID_SIZE][GRID_SIZE];

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                gridButtons[row][col] = new JButton();
                gridButtons[row][col].setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                gridButtons[row][col].setBackground(Color.WHITE);
                gridButtons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton button = (JButton) e.getSource();
                        int row = (int) button.getClientProperty("row");
                        int col = (int) button.getClientProperty("col");
                        toggleCell(row, col);
                    }
                });
                gridPanel.add(gridButtons[row][col]);
                gridButtons[row][col].putClientProperty("row", row);
                gridButtons[row][col].putClientProperty("col", col);
            }
        }

        JButton dfsButton = new JButton("DFS");
        dfsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[][] shortestPath = findShortestPathDFS();
                highlightShortestPath(shortestPath);
            }
        });

        JButton bfsButton = new JButton("BFS");
        bfsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[][] shortestPath = findShortestPathBFS();
                highlightShortestPath(shortestPath);
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(dfsButton, BorderLayout.SOUTH);
        mainPanel.add(bfsButton, BorderLayout.SOUTH);

        add(mainPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void toggleCell(int row, int col) {
        if (grid[row][col] == 0) {
            grid[row][col] = 1;
            gridButtons[row][col].setBackground(Color.BLACK);
        } else {
            grid[row][col] = 0;
            gridButtons[row][col].setBackground(Color.WHITE);
        }
    }

    private int[][] findShortestPathDFS() {
        int[][] shortestPath = new int[GRID_SIZE][GRID_SIZE];
        boolean[][] visited = new boolean[GRID_SIZE][GRID_SIZE];
        dfs(0, 0, shortestPath, visited);
        return shortestPath;
    }

    private void dfs(int row, int col, int[][] shortestPath, boolean[][] visited) {
        if (row < 0 || row >= GRID_SIZE || col < 0 || col >= GRID_SIZE || grid[row][col] == 1 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        shortestPath[row][col] = 1;
        dfs(row - 1, col, shortestPath, visited);
        dfs(row + 1, col, shortestPath, visited);
        dfs(row, col - 1, shortestPath, visited);
        dfs(row, col + 1, shortestPath, visited);
    }

    private int[][] findShortestPathBFS() {
        int[][] shortestPath = new int[GRID_SIZE][GRID_SIZE];
        boolean[][] visited = new boolean[GRID_SIZE][GRID_SIZE];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int row = point.x;
            int col = point.y;
            shortestPath[row][col] = 1;
            if (row - 1 >= 0 && !visited[row - 1][col] && grid[row - 1][col] != 1) {
                queue.offer(new Point(row - 1, col));
                visited[row - 1][col] = true;
            }
            if (row + 1 < GRID_SIZE && !visited[row + 1][col] && grid[row + 1][col] != 1) {
                queue.offer(new Point(row + 1, col));
                visited[row + 1][col] = true;
            }
            if (col - 1 >= 0 && !visited[row][col - 1] && grid[row][col - 1] != 1) {
                queue.offer(new Point(row, col - 1));
                visited[row][col - 1] = true;
            }
            if (col + 1 < GRID_SIZE && !visited[row][col + 1] && grid[row][col + 1] != 1) {
                queue.offer(new Point(row, col + 1));
                visited[row][col + 1] = true;
            }
        }
        return shortestPath;
    }

    private void highlightShortestPath(int[][] shortestPath) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (shortestPath[row][col] == 1) {
                    gridButtons[row][col].setBackground(Color.GREEN);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShortestPathFindingApp();
            }
        });
    }
}