package No_15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TSPGeneticAlgorithmApp extends JFrame {
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;
    private static final int POINT_SIZE = 10;
    private static final int POPULATION_SIZE = 100;
    private static final int MAX_GENERATIONS = 1000;

    private JPanel graphPanel;
    private JButton startButton;
    private JLabel generationLabel;
    private JLabel bestDistanceLabel;

    private ArrayList<Point> points;
    private int[][] distanceMatrix;
    private ArrayList<ArrayList<Integer>> population;
    private ArrayList<Integer> bestRoute;

    public TSPGeneticAlgorithmApp() {
        setTitle("TSP Genetic Algorithm");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        graphPanel = new JPanel();
        startButton = new JButton("Start");
        generationLabel = new JLabel("Generation: 0");
        bestDistanceLabel = new JLabel("Best Distance: -");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGeneticAlgorithm();
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(startButton);
        controlPanel.add(generationLabel);
        controlPanel.add(bestDistanceLabel);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(graphPanel, BorderLayout.CENTER);
        contentPane.add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void startGeneticAlgorithm() {
        initializePoints();
        createDistanceMatrix();
        initializePopulation();

        for (int generation = 1; generation <= MAX_GENERATIONS; generation++) {
            evolvePopulation();
            updateBestRoute();
            drawGraph();

            generationLabel.setText("Generation: " + generation);
            bestDistanceLabel.setText("Best Distance: " + calculateDistance(bestRoute));

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void initializePoints() {
        points = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < POPULATION_SIZE; i++) {
            int x = random.nextInt(FRAME_WIDTH - POINT_SIZE);
            int y = random.nextInt(FRAME_HEIGHT - POINT_SIZE);
            points.add(new Point(x, y));
        }
    }

    private void createDistanceMatrix() {
        distanceMatrix = new int[POPULATION_SIZE][POPULATION_SIZE];
        for (int i = 0; i < POPULATION_SIZE; i++) {
            for (int j = 0; j < POPULATION_SIZE; j++) {
                int distance = (int) points.get(i).distance(points.get(j));
                distanceMatrix[i][j] = distance;
                distanceMatrix[j][i] = distance;
            }
        }
    }

    private void initializePopulation() {
        population = new ArrayList<>();
        for (int i = 0; i < POPULATION_SIZE; i++) {
            ArrayList<Integer> route = new ArrayList<>();
            for (int j = 0; j < POPULATION_SIZE; j++) {
                route.add(j);
            }
            Collections.shuffle(route);
            population.add(route);
        }
    }

    private void evolvePopulation() {
        ArrayList<ArrayList<Integer>> newPopulation = new ArrayList<>();
        for (int i = 0; i < POPULATION_SIZE; i++) {
            ArrayList<Integer> parent1 = selectParent();
            ArrayList<Integer> parent2 = selectParent();
            ArrayList<Integer> child = crossover(parent1, parent2);
            mutate(child);
            newPopulation.add(child);
        }
        population = newPopulation;
    }

    private ArrayList<Integer> selectParent() {
        Random random = new Random();
        int index = random.nextInt(POPULATION_SIZE);
        return population.get(index);
    }

    private ArrayList<Integer> crossover(ArrayList<Integer> parent1, ArrayList<Integer> parent2) {
        ArrayList<Integer> child = new ArrayList<>();
        int startPos = (int) (Math.random() * POPULATION_SIZE);
        int endPos = (int) (Math.random() * POPULATION_SIZE);
        for (int i = 0; i < POPULATION_SIZE; i++) {
            if (startPos < endPos && i > startPos && i < endPos) {
                child.add(parent1.get(i));
            } else if (startPos > endPos && !(i < startPos && i > endPos)) {
                child.add(parent1.get(i));
            }
        }
        for (int i = 0; i < POPULATION_SIZE; i++) {
            if (!child.contains(parent2.get(i))) {
                for (int j = 0; j < POPULATION_SIZE; j++) {
                    if (child.get(j) == null) {
                        child.set(j, parent2.get(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    private void mutate(ArrayList<Integer> route) {
        Random random = new Random();
        for (int i = 0; i < POPULATION_SIZE; i++) {
            if (Math.random() < 0.01) {
                int index1 = random.nextInt(POPULATION_SIZE);
                int index2 = random.nextInt(POPULATION_SIZE);
                int temp = route.get(index1);
                route.set(index1, route.get(index2));
                route.set(index2, temp);
            }
        }
    }

    private void updateBestRoute() {
        int bestDistance = Integer.MAX_VALUE;
        for (ArrayList<Integer> route : population) {
            int distance = calculateDistance(route);
            if (distance < bestDistance) {
                bestDistance = distance;
                bestRoute = route;
            }
        }
    }

    private int calculateDistance(ArrayList<Integer> route) {
        int distance = 0;
        for (int i = 0; i < POPULATION_SIZE - 1; i++) {
            distance += distanceMatrix[route.get(i)][route.get(i + 1)];
        }
        distance += distanceMatrix[route.get(POPULATION_SIZE - 1)][route.get(0)];
        return distance;
    }

    private void drawGraph() {
        graphPanel.removeAll();
        for (int i = 0; i < POPULATION_SIZE; i++) {
            Point point = points.get(bestRoute.get(i));
            JLabel label = new JLabel();
            label.setBounds(point.x, point.y, POINT_SIZE, POINT_SIZE);
            label.setOpaque(true);
            label.setBackground(Color.RED);
            graphPanel.add(label);
        }
        graphPanel.revalidate();
        graphPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
  
public void run() {
                new TSPGeneticAlgorithmApp();
            }
        });
    }
}