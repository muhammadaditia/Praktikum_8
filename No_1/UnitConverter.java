package No_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UnitConverter extends JFrame {
    private JTextField inputField;
    private JComboBox<String> unitBox;
    private JButton convertButton;
    private JLabel resultLabel;

    public UnitConverter() {
        setLayout(new FlowLayout());

        inputField = new JTextField(10);
        add(inputField);

        String[] units = {"km", "hm", "dam", "m", "dm", "cm", "mm"};
        unitBox = new JComboBox<>(units);
        add(unitBox);

        convertButton = new JButton("Convert to meters");
        add(convertButton);

        resultLabel = new JLabel("");
        add(resultLabel);

        event e = new event();
        convertButton.addActionListener(e);
    }

    public class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double value = Double.parseDouble(inputField.getText());
            String unit = unitBox.getSelectedItem().toString();

            switch (unit) {
                case "km":
                    value *= 1000;
                    break;
                case "hm":
                    value *= 100;
                    break;
                case "dam":
                    value *= 10;
                    break;
                case "dm":
                    value /= 10;
                    break;
                case "cm":
                    value /= 100;
                    break;
                case "mm":
                    value /= 1000;
                    break;
            }

            resultLabel.setText(Double.toString(value) + " m");
        }
    }

    public static void main(String args[]) {
        UnitConverter gui = new UnitConverter();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(300, 150);
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
        gui.setTitle("Unit Converter");
    }
}