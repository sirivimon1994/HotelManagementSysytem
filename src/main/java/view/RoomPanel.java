package view;


import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import tablemodel.RoomTypeTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RoomPanel extends JPanel {
    private JTable roomTable;
    private RoomTypeTableModel tableModel;

    public RoomPanel() {
        setLayout(new BorderLayout());

        tableModel = new RoomTypeTableModel();
        roomTable = new JTable(tableModel);

        add(new JScrollPane(roomTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Room");
        JButton updateButton = new JButton("Update Room");
        JButton deleteButton = new JButton("Delete Room");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addRoom());
        updateButton.addActionListener(e -> updateRoom());
        deleteButton.addActionListener(e -> deleteRoom());
    }

    private void addRoom() {
        // Add room logic
    }

    private void updateRoom() {
        // Update room logic
    }

    private void deleteRoom() {
        // Delete room logic
    }

   

   
}
