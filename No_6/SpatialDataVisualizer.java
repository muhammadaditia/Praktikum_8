package No_6;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class SpatialDataVisualizer extends JFrame {
    private JPanel panel;

    public SpatialDataVisualizer() {
        panel = new MapPanel();
        add(panel);
    }

    private class MapPanel extends JPanel {
        private final int POINT_DIAMETER = 10;

        // Sample data: array of latitude and longitude pairs
        private double[][] data = {
                {-6.2088, 106.8456}, // Jakarta
                {-7.7956, 110.3695}, // Yogyakarta
                {-8.3405, 115.0920}, // Bali
                // Add more data as needed
        };

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            for (double[] point : data) {
                drawPoint(g2d, point[0], point[1]);
            }
        }

        private void drawPoint(Graphics2D g2d, double lat, double lon) {
            // Convert latitude and longitude to x and y for simplicity
            // This is not a correct conversion, for a real application you would need to use a map projection
            int x = (int) ((lon + 180) * (getWidth() / 360.0));
            int y = (int) ((-lat + 90) * (getHeight() / 180.0));

            Shape point = new Ellipse2D.Double(x - POINT_DIAMETER / 2, y - POINT_DIAMETER / 2, POINT_DIAMETER, POINT_DIAMETER);
            g2d.fill(point);
        }
    }

    public static void main(String[] args) {
        SpatialDataVisualizer frame = new SpatialDataVisualizer();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Spatial Data Visualizer");
    }
}