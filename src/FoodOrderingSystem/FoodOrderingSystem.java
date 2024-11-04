package FoodOrderingSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame {
    private JPanel pMain;
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JButton btnOrder;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;

    FoodOrderingSystem() {

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = calculateAmount();
                JOptionPane.showMessageDialog(null, "The total price is Php " + String.format("%.2f", amount) + ".");
            }
        });
    }

    private double calculateAmount() {
        double total = 0;
        if (cPizza.isSelected()) {
            total += 100;
        }
        if (cBurger.isSelected()) {
            total += 85;
        }
        if (cFries.isSelected()) {
            total += 65;
        }
        if (cSoftDrinks.isSelected()) {
            total += 55;
        }
        if (cTea.isSelected()) {
            total += 50;
        }
        if (cSundae.isSelected()) {
            total += 40;
        }

        if (rbNone.isSelected()) {
            return total;
        }
        if (rb5.isSelected()) {
            return total * 0.95;
        }
        if (rb10.isSelected()) {
            return total * 0.9;
        }
        return  total * 0.85;
    }

    public static void main(String[] args) {
        FoodOrderingSystem fos = new FoodOrderingSystem();
        fos.setTitle("Food Ordering System");
        fos.setContentPane(fos.pMain);
        fos.setSize(1080, 720);
        fos.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fos.setVisible(true);
    }
}
