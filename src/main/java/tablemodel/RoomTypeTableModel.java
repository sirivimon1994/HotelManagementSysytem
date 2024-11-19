package tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Customer;
import model.Room;
import model.RoomType;

public class RoomTypeTableModel  extends AbstractTableModel {
    private List<RoomType> roomTypes;
    private final String[] columnNames = {
        "RoomTypeID", "RoomTypeName", "RoomName", "PricePerNight",
        "CapacityAdults", "CapacityChildren", "Amenities", "Image"
    };

    public RoomTypeTableModel() {
        this.roomTypes = new ArrayList<>();
    }

    public void setRoomTypes(List<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return roomTypes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RoomType roomType = roomTypes.get(rowIndex);
        switch (columnIndex) {
            case 0: return roomType.getRoomTypeID();
            case 1: return roomType.getRoomTypeName();
            case 2: return roomType.getRoomName();
            case 3: return roomType.getPricePerNight();
            case 4: return roomType.getCapacityAdults();
            case 5: return roomType.getCapacityChildren();
            case 6: return roomType.getAmenities();
            case 7: return roomType.getImage();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void addRow(RoomType roomType) {
        roomTypes.add(roomType);
        fireTableRowsInserted(roomTypes.size() - 1, roomTypes.size() - 1);
    }

    public void removeRow(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < roomTypes.size()) {
            roomTypes.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }
}