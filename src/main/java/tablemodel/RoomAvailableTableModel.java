package tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Room;

public class RoomAvailableTableModel extends AbstractTableModel {
    private List<Room> rooms;
    private final String[] columnNames = {
        "RoomTypeID", 
        "RoomTypeName", 
        "RoomNumber",
        "PricePerNight",
        "CapacityAdults", 
        "CapacityChildren",
        "RoomCount",
        "Amenities", 
        "Image"
    };

    
    public RoomAvailableTableModel() {
        this.rooms = new ArrayList<>();
    }

    public void setRoomAvailable(List<Room> rooms) {
        this.rooms = rooms;
        fireTableDataChanged();
    }

    public Room getRoomAt(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < rooms.size()) {
            return rooms.get(rowIndex);
        }
        return null;
    }
    
    @Override
    public int getRowCount() {
        return rooms.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Room roomType = rooms.get(rowIndex);
        switch (columnIndex) {
            case 0: return roomType.getRoomTypeID();
            case 1: return roomType.getRoomName();
            case 2: return roomType.getRoomNumber();
            case 3: return roomType.getPrice();
            case 4: return roomType.getPrice();
            case 5: return roomType.getAdult();
            case 6: return roomType.getChildren();
            case 7: return roomType.getRoomCount();
            case 8: return roomType.getAmenities();
            case 9: return roomType.getImage();
            default: return null;
        }
    }

    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void addRow(Room roomType) {
    	rooms.add(roomType);
        fireTableRowsInserted(rooms.size() - 1, rooms.size() - 1);
    }

    public void removeRow(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < rooms.size()) {
        	rooms.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }
    
    public void clearData() {
    	rooms.clear();
        fireTableDataChanged(); // Notify listeners that data has changed
    }
    
}
