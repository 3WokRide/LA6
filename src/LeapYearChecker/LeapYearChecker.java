package LeapYearChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearChecker extends JFrame {

    private JTextField yearTextField;
    private JButton checkYearButton;
    private JPanel pMain;

    LeapYearChecker() {
        yearTextField.setName("yearTextField");
        checkYearButton.setName("checkYearButton");

        checkYearButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String input = yearTextField.getText();
                int year = -1;
                try {
                    year = Integer.parseInt(input);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please input a valid year.");
                    return;
                }
                boolean isLeapYear =  (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
                String message = "Leap year";
                if (!isLeapYear) {
                    message = "Not a leap year";
                }
                JOptionPane.showMessageDialog(null, message);
            }
        });
    }

    public static void main(String[] args) {
        LeapYearChecker lyc = new LeapYearChecker();
        lyc.setTitle("Leap Year Checker");
        lyc.setContentPane(lyc.pMain);
        lyc.setSize(400, 200);
        lyc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        lyc.setVisible(true);
    }
}
