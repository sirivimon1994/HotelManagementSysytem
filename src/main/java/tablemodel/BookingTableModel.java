package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import model.Booking;


public class BookingTableModel extends AbstractTableModel {
    private List<Booking> bookings = new ArrayList<>();
    private String[] columnNames = {"Booking ID", "Customer ID", "Room Number", "Status"};

    @Override
    public int getRowCount() {
        return bookings.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Booking booking = bookings.get(rowIndex);
        switch (columnIndex) {
            case 0: return booking.getId();
            case 1: return booking.getCustomerId();
            case 2: return booking.getRoomNumber();
            case 3: return booking.getStatus();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
