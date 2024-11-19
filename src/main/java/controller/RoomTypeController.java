//package controller;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.SQLException;
//
//import javax.swing.JOptionPane;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import dao.RoomTypeDAO;
//import model.RoomType;
//import view.RoomTypePanel;
//
//public class RoomTypeController {
//    private RoomTypePanel view;
//    private RoomTypeDAO model;
//
//    public RoomTypeController(RoomTypePanel view, RoomTypeDAO model) {
//        this.view = view;
//        this.model = model;
//
//        // Add listeners to the view
//        this.view.addAddButtonListener(new AddRoomListener());
//        this.view.addDeleteButtonListener(new DeleteRoomListener());
//        this.view.addSaveButtonListener(new SaveChangesListener());
//
//        // Load data into the view
//        loadRoomTypes();
//    }
//
//    private void loadRoomTypes() {
//        try {
//            JSONArray jsonArray = model.getAllRoomTypesAsJson();
//            Object[][] data = new Object[jsonArray.length()][8];
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                data[i] = new Object[]{
//                    jsonObject.getInt("RoomTypeID"),
//                    jsonObject.getString("RoomTypeName"),
//                    jsonObject.getString("RoomName"),
//                    jsonObject.getDouble("PricePerNight"),
//                    jsonObject.getInt("CapacityAdults"),
//                    jsonObject.getInt("CapacityChildren"),
//                    jsonObject.getString("Amenities"),
//                    jsonObject.getString("Image")
//                };
//            }
//            view.updateTableModel(data);
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(view, "Error loading room types: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private class AddRoomListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//        	 try {
//                 // Gather data from the view
//                 String roomTypeID = view.getRoomTypeID();
//                 String roomTypeName = view.getRoomTypeName();
//                 String roomName = view.getRoomName();
//                 double pricePerNight = Double.parseDouble(view.getPricePerNight());
//                 int capacityAdults = Integer.parseInt(view.getCapacityAdults());
//                 int capacityChildren = Integer.parseInt(view.getCapacityChildren());
//                 String amenities = view.getAmenities();
//                 String image = view.getImage();
//
//                 // Create RoomType instance
//                 RoomType roomType = new RoomType(
//                     roomTypeID,
//                     roomTypeName,
//                     roomName,
//                     pricePerNight,
//                     capacityAdults,
//                     capacityChildren,
//                     amenities,
//                     image
//                 );
//
//                 // Add RoomType to model
//                 model.addRoomType(roomType);
//
//                 // Clear fields and refresh the table
//                 view.clearFields();
//                 loadRoomTypes();
//             } catch (NumberFormatException ex) {
//                 JOptionPane.showMessageDialog(view, "Invalid number format: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//             } catch (SQLException ex) {
//                 JOptionPane.showMessageDialog(view, "Error adding room type: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//             }
//        }
//    }
//
//    private class DeleteRoomListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            int selectedRow = view.getRoomTypeTable().getSelectedRow();
//            if (selectedRow >= 0) {
//                // Confirm deletion and remove room type
//                int response = JOptionPane.showConfirmDialog(view,
//                    "Are you sure you want to delete this room?",
//                    "Confirm Delete",
//                    JOptionPane.YES_NO_OPTION,
//                    JOptionPane.WARNING_MESSAGE);
//
//                if (response == JOptionPane.YES_OPTION) {
//                    // Code to delete from the model
//                    // Assuming the model has a method to delete by ID
//                    try {
//                        model.deleteRoomType((String) view.getRoomTypeTable().getValueAt(selectedRow, 0));
//                        loadRoomTypes(); // Refresh the table
//                    } catch (SQLException ex) {
//                        JOptionPane.showMessageDialog(view, "Error deleting room type: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//                    }
//                }
//            } else {
//                JOptionPane.showMessageDialog(view, "Please select a room to delete.");
//            }
//        }
//    }
//
//    private class SaveChangesListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            // Iterate through all rows and save changes to the database
//            int rowCount = view.getRoomTypeTable().getRowCount();
//            for (int i = 0; i < rowCount; i++) {
//                Object roomTypeID = view.getRoomTypeTable().getValueAt(i, 0);
//                Object roomTypeName = view.getRoomTypeTable().getValueAt(i, 1);
//                Object roomName = view.getRoomTypeTable().getValueAt(i, 2);
//                Object pricePerNight = view.getRoomTypeTable().getValueAt(i, 3);
//                Object capacityAdults = view.getRoomTypeTable().getValueAt(i, 4);
//                Object capacityChildren = view.getRoomTypeTable().getValueAt(i, 5);
//                Object amenities = view.getRoomTypeTable().getValueAt(i, 6);
//                Object image = view.getRoomTypeTable().getValueAt(i, 7);
//
//                RoomType roomType = new RoomType(
//                    roomTypeID.toString(),
//                    roomTypeName.toString(),
//                    roomName.toString(),
//                    Double.parseDouble(pricePerNight.toString()),
//                    Integer.parseInt(capacityAdults.toString()),
//                    Integer.parseInt(capacityChildren.toString()),
//                    amenities.toString(),
//                    image.toString()
//                );
//
//                try {
//                    model.addRoomType(roomType);
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(view, "Error saving room types: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//                    return; // Exit on error
//                }
//            }
//        }
//    }
//}
