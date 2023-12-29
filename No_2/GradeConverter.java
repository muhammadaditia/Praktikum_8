package No_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GradeConverter extends JFrame {
    private JTextField inputField;
    private JButton convertButton;
    private JLabel resultLabel;

    public GradeConverter() {
        setLayout(new FlowLayout());

        inputField = new JTextField(10);
        add(inputField);

        convertButton = new JButton("Convert");
        add(convertButton);

        resultLabel = new JLabel("");
        add(resultLabel);

        event e = new event();
        convertButton.addActionListener(e);
    }

    public class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = inputField.getText();
            String result = "";

            try {
                int numericGrade = Integer.parseInt(input);
                if (numericGrade >= 85) {
                    result = "A";
                } else if (numericGrade >= 80) {
                    result = "A-";
                } else if (numericGrade >= 75) {
                    result = "B+";
                } else if (numericGrade >= 70) {
                    result = "B";
                } else if (numericGrade >= 65) {
                    result = "B-";
                } else if (numericGrade >= 60) {
                    result = "C";
                } else if (numericGrade >= 50) {
                    result = "D";
                } else {
                    result = "E";
                }
            } catch (NumberFormatException ex) {
                switch (input) {
                    case "A":
                        result = "85-100";
                        break;
                    case "A-":
                        result = "80-84";
                        break;
                    case "B+":
                        result = "75-79";
                        break;
                    case "B":
                        result = "70-74";
                        break;
                    case "B-":
                        result = "65-69";
                        break;
                    case "C":
                        result = "60-64";
                        break;
                    case "D":
                        result = "50-59";
                        break;
                    case "E":
                        result = "0-49";
                        break;
                    default:
                        result = "Invalid input";
                        break;
                }
            }

            resultLabel.setText(result);
        }
    }

    public static void main(String args[]) {
        GradeConverter gui = new GradeConverter();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(300, 150);
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
        gui.setTitle("Grade Converter");
    }
}

