package No_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SpatialVisualizationApp extends JFrame {
    private JPanel mapPanel;
    private List<Point> dataPoints;

    public SpatialVisualizationApp() {
        setTitle("Spatial Visualization App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        mapPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawDataPoints(g);
            }
        };
        mapPanel.setBackground(Color.WHITE);

        dataPoints = new ArrayList<>();

        JButton visualizeButton = new JButton("Visualize Data");
        visualizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic to visualize spatial data here
                // For simplicity, let's randomly generate a point and add it to the map
                addRandomDataPoint();
                mapPanel.repaint(); // Repaint the map to reflect the new data point
            }
        });

        add(mapPanel, BorderLayout.CENTER);
        add(visualizeButton, BorderLayout.SOUTH);
    }

    private void drawDataPoints(Graphics g) {
        for (Point point : dataPoints) {
            g.setColor(Color.RED);
            g.fillOval(point.x, point.y, 10, 10);
        }
    }

    private void addRandomDataPoint() {
        int x = (int) (Math.random() * mapPanel.getWidth());
        int y = (int) (Math.random() * mapPanel.getHeight());
        dataPoints.add(new Point(x, y));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SpatialVisualizationApp().setVisible(true);
            }
        });
    }
}