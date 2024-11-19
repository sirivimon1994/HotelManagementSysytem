package view;


import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import tablemodel.BookingTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BookingPanel extends JPanel {
    private JTable bookingTable;
    private BookingTableModel tableModel;

    public BookingPanel() {
        setLayout(new BorderLayout());

        tableModel = new BookingTableModel();
        bookingTable = new JTable(tableModel);

        add(new JScrollPane(bookingTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton bookButton = new JButton("Book Room");
        JButton checkInButton = new JButton("Check In");
        JButton checkOutButton = new JButton("Check Out");

        buttonPanel.add(bookButton);
        buttonPanel.add(checkInButton);
        buttonPanel.add(checkOutButton);

        add(buttonPanel, BorderLayout.SOUTH);

        bookButton.addActionListener(e -> bookRoom());
        checkInButton.addActionListener(e -> checkIn());
        checkOutButton.addActionListener(e -> checkOut());
    }

    private void bookRoom() {
        // Book room logic
    }

    private void checkIn() {
        // Check-in logic
    }

    private void checkOut() {
        // Check-out logic
    }

   


}