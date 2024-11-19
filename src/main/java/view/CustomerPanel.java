package view;


import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import data.CustomerData;
import model.Customer;
import model.dao.CustomerDAO;
import model.dao.RoomTypeDAO;
import tablemodel.CustomerTableModel;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class CustomerPanel  extends JPanel {
    private JTable customerTable;
    private CustomerTableModel tableModel;
    private CustomerDAO customerDAO;
    private CustomerData cusData;
    
    public CustomerPanel() {
    	customerDAO = new CustomerDAO(); 
    	cusData = new CustomerData(); 
        setLayout(new BorderLayout());

        tableModel = new CustomerTableModel();
        customerTable = new JTable(tableModel);

        add(new JScrollPane(customerTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Customer");
        JButton updateButton = new JButton("Update Customer");
        JButton deleteButton = new JButton("Delete Customer");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addCustomer());
        updateButton.addActionListener(e -> updateCustomer());
        deleteButton.addActionListener(e -> deleteCustomer());

        loadCustomerData();
    }

    private void addCustomer() {
        // Add customer logic
    }

    private void updateCustomer() {
        // Update customer logic
    }

    private void deleteCustomer() {
        // Delete customer logic
    }

    private void loadCustomerData() {
        try {
            String json = customerDAO.getAllGuestsAsJson();
            List<Customer> customers = cusData.parseJson(json);
            tableModel.setCustomers(customers);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load customer data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}