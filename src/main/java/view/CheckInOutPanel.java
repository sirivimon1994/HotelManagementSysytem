package view;

import javax.swing.*;
import java.awt.*;

public class CheckInOutPanel extends JPanel {

    private JTextField promotionCodeField, checkInField, checkOutField, guestIdField;
    private JButton checkInButton, checkOutButton;

    public CheckInOutPanel() {
        initializeComponents();
        setLayout(new BorderLayout());
        add(createMainPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private void initializeComponents() {
        promotionCodeField = new JTextField(20);
        checkInField = new JTextField(20);
        checkOutField = new JTextField(20);
        guestIdField = new JTextField(20);
        checkInButton = new JButton("Check-In");
        checkInButton.addActionListener(e -> handleCheckIn());
        checkOutButton = new JButton("Check-Out");
        checkOutButton.addActionListener(e -> handleCheckOut());
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        panel.add(new JLabel("Guest ID:"));
        panel.add(guestIdField);

        panel.add(new JLabel("Promotion Code:"));
        panel.add(promotionCodeField);

        panel.add(new JLabel("Check-In Date:"));
        panel.add(checkInField);

        panel.add(new JLabel("Check-Out Date:"));
        panel.add(checkOutField);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel.add(checkInButton);
        panel.add(checkOutButton);
        return panel;
    }

    private void handleCheckIn() {
        // Handle check-in logic
    }

    private void handleCheckOut() {
        // Handle check-out logic
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Check-In/Check-Out");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new CheckInOutPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
