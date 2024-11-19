package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffPanel extends JPanel {

    private JTable staffTable;
    private DefaultTableModel tableModel;
    private JTextField nameField, positionField, phoneField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private JButton addButton, removeButton;

    public StaffPanel() {
        setLayout(new BorderLayout());

        // Create and configure the table model
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Position", "Phone", "Role", "Password"}, 0);
        staffTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(staffTable);
        add(scrollPane, BorderLayout.CENTER);

        // Create the panel for form inputs and buttons
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2));

        // Add labels and text fields
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Position:"));
        positionField = new JTextField();
        formPanel.add(positionField);

        formPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        formPanel.add(phoneField);

        // Add a dropdown for selecting the role
        formPanel.add(new JLabel("Role:"));
        String[] roles = {"Reception", "Room Service", "Housekeeper", "Other"};
        roleComboBox = new JComboBox<>(roles);
        formPanel.add(roleComboBox);

        // Add a password field
        formPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        formPanel.add(passwordField);

        // Add buttons to the form panel
        addButton = new JButton("Add Staff");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStaff();
            }
        });
        formPanel.add(addButton);

        removeButton = new JButton("Remove Staff");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeStaff();
            }
        });
        formPanel.add(removeButton);

        add(formPanel, BorderLayout.SOUTH);
    }

    private void addStaff() {
        String name = nameField.getText();
        String position = positionField.getText();
        String phone = phoneField.getText();
        String role = (String) roleComboBox.getSelectedItem(); // Get selected role
        char[] password = passwordField.getPassword();

        if (name.isEmpty() || position.isEmpty() || phone.isEmpty() || role.isEmpty() || password.length == 0) {
            JOptionPane.showMessageDialog(this, "All fields must be filled out", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Add staff to table (in a real application, you'd also save this data to a database)
        int newId = tableModel.getRowCount() + 1; // Simple ID generation for demonstration
        tableModel.addRow(new Object[]{newId, name, position, phone, role, new String(password)});

        // Clear the fields
        nameField.setText("");
        positionField.setText("");
        phoneField.setText("");
        passwordField.setText("");
        roleComboBox.setSelectedIndex(0); // Reset the role dropdown to the first option
    }

    private void removeStaff() {
        int selectedRow = staffTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a staff member to remove", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
