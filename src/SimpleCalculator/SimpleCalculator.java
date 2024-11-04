package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JPanel pMain;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JTextField tfNumber2;
    private JTextField lblResult;
    private JButton btnCompute;

    public SimpleCalculator() {
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get input
                String input1 = tfNumber1.getText(), input2 = tfNumber2.getText();
                int num1 = -1, num2 = -1;
                try {
                    num1 = Integer.parseInt(input1);
                    num2 = Integer.parseInt(input2);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please input a valid integer.");
                    return;
                }

                // Do operation
                double result = -1;
                switch (cbOperations.getSelectedIndex()) {
                    case 0: // +
                        result = num1 + num2;
                        break;
                    case 1: // -
                        result = num1 - num2;
                        break;
                    case 2: // *
                        result = num1 * num2;
                        break;
                    default: // "/"
                        if (num2 == 0) {
                            JOptionPane.showMessageDialog(null, "Cannot divide by Zero.");
                            return;
                        }
                        result = (double) num1 / num2;
                }

                // Print result
                if ((int) result == result) {
                    lblResult.setText(String.format("%d", (int) result));
                } else {
                    lblResult.setText(String.format("%.2f", result));
                }
            }
        });
    }

    public static void main(String[] args) {
        SimpleCalculator sc = new SimpleCalculator();
        sc.setTitle("Simple Calculator");
        sc.setContentPane(sc.pMain);
        sc.setSize(800, 400);
        sc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        sc.setVisible(true);
    }
}
