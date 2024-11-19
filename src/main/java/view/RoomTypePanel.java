package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import data.RoomTypeData;
import model.Customer;
import model.RoomType;
import model.dao.ConnectionService;
import model.dao.RoomTypeDAO;
import tablemodel.RoomTypeTableModel;

public class RoomTypePanel extends JPanel {
	private ConnectionService service = new ConnectionService();
    private JTable roomTypeTable;
    private JTextField roomNameField;
    private JTextField amenitiesField;
    private JTextField capacityAdultsField;
    private JTextField capacityChildrenField;
    private JTextField pricePerNightField;
    private JTextField imageField;
    private JTextField roomTypeIDField;
    private JTextField roomTypeNameField;
    private JButton addButton;
    private JButton deleteButton;
    private JButton saveButton;
    private RoomTypeTableModel tableModel;
    private RoomTypeDAO roomTypeDAO;
    private RoomTypeData roomData;
    
    public RoomTypePanel() {
        roomTypeDAO = new RoomTypeDAO();  // Initialize RoomTypeDAO
        roomData = new RoomTypeData(); 
        setLayout(new BorderLayout());

        // Create and set up the table
        String[] columnNames = {
            "RoomTypeID", "RoomTypeName", "RoomName", "PricePerNight",
            "CapacityAdults", "CapacityChildren", "Amenities", "Image"
        };
        tableModel = new RoomTypeTableModel();
        roomTypeTable = new JTable(tableModel) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (isCellSelected(row, column)) {
                    c.setBackground(Color.YELLOW);
                } else {
                    c.setBackground(Color.WHITE);
                }
                return c;
            }
        };
        JScrollPane scrollPane = new JScrollPane(roomTypeTable);
        add(scrollPane, BorderLayout.CENTER);

        // Create and set up the input panel
        JPanel inputPanel = createInputPanel();
        add(inputPanel, BorderLayout.NORTH);

        // Create and set up the button panel
        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Load data from the database
        loadRoomTypes();
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Room Type ID:"), gbc);

        roomTypeIDField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(roomTypeIDField, gbc);

        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Room Type Name:"), gbc);

        roomTypeNameField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(roomTypeNameField, gbc);

        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Room Name:"), gbc);

        roomNameField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(roomNameField, gbc);

        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Amenities:"), gbc);

        amenitiesField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(amenitiesField, gbc);

        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Capacity Adults:"), gbc);

        capacityAdultsField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(capacityAdultsField, gbc);

        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Capacity Children:"), gbc);

        capacityChildrenField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(capacityChildrenField, gbc);

        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Price Per Night:"), gbc);

        pricePerNightField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(pricePerNightField, gbc);

        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Image:"), gbc);

        imageField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(imageField, gbc);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();

        addButton = new JButton("Add Room");
        addButton.addActionListener(e -> addRoom());
        panel.add(addButton);

        deleteButton = new JButton("Delete Room");
        deleteButton.addActionListener(e -> deleteRoom());
        panel.add(deleteButton);

        saveButton = new JButton("Save Changes");
        saveButton.addActionListener(e -> saveChanges());
        panel.add(saveButton);

        return panel;
    }

    private void addRoom() {
    	 String roomTypeID = roomTypeIDField.getText();
         String roomTypeName = roomTypeNameField.getText();
         String roomName = roomNameField.getText();
         String amenities = amenitiesField.getText();
         String capacityAdults = capacityAdultsField.getText();
         String capacityChildren = capacityChildrenField.getText();
         String pricePerNight = pricePerNightField.getText();
         String image = imageField.getText();

         RoomType roomType = new RoomType(
             roomTypeID,
             roomTypeName,
             roomName,
             Double.parseDouble(pricePerNight),
             Integer.parseInt(capacityAdults),
             Integer.parseInt(capacityChildren),
             amenities,
             image
         );

         tableModel.addRow(roomType);

         int lastRow = tableModel.getRowCount() - 1;
         roomTypeTable.setRowSelectionInterval(lastRow, lastRow);
         roomTypeTable.repaint();

         clearFields();
    }

    private void clearFields() {
        roomTypeIDField.setText("");
        roomTypeNameField.setText("");
        roomNameField.setText("");
        amenitiesField.setText("");
        capacityAdultsField.setText("");
        capacityChildrenField.setText("");
        pricePerNightField.setText("");
        imageField.setText("");
    }


    private void deleteRoom() {
        int selectedRow = roomTypeTable.getSelectedRow();
        if (selectedRow >= 0) {
            int response = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this room?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                tableModel.removeRow(selectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a room to delete.");
        }
    }

    private void saveChanges() {
        int rowCount = tableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Object roomTypeID = tableModel.getValueAt(i, 0);
            Object roomTypeName = tableModel.getValueAt(i, 1);
            Object roomName = tableModel.getValueAt(i, 2);
            Object pricePerNight = tableModel.getValueAt(i, 3);
            Object capacityAdults = tableModel.getValueAt(i, 4);
            Object capacityChildren = tableModel.getValueAt(i, 5);
            Object amenities = tableModel.getValueAt(i, 6);
            Object image = tableModel.getValueAt(i, 7);

            try {
                RoomType roomType = new RoomType(
                    roomTypeID.toString(),
                    roomTypeName.toString(),
                    roomName.toString(),
                    Double.parseDouble(pricePerNight.toString()),
                    Integer.parseInt(capacityAdults.toString()),
                    Integer.parseInt(capacityChildren.toString()),
                    amenities.toString(),
                    image.toString()
                );
                roomTypeDAO.addRoomType(roomType);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error saving room types: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        resetRowColors();
    }

    private void resetRowColors() {
        for (int i = 0; i < roomTypeTable.getRowCount(); i++) {
            roomTypeTable.setRowSelectionInterval(i, i);
            roomTypeTable.setSelectionBackground(Color.WHITE);
        }
    }

    
    private void loadRoomTypes() {
            List<RoomType> roomTypes = service.callAllRoomTypesAsJson();
            tableModel.setRoomTypes(roomTypes);
    }
} 