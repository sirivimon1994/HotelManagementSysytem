package tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.Reservation;
import model.Room;

public class SummaryTableModel extends AbstractTableModel {
    private List<Reservation> reservations;
    private final String[] columnNames = {
        "ReservationID", 
        "GuestID", 
        "RoomTypeID",
        "RoomTypeName",
        "RoomNumber",
        "PricePerNight", 
        "FirstName", 
        "LastName", 
        "Email", 
        "Phone",
        "Country", 
        "Birthday",
        "CheckInDate",
        "CheckOutDate" ,  
        "CreateDate" 
    };

    public SummaryTableModel() {
        this.reservations = new ArrayList<>();
    }

    public void setSummary(List<Reservation> reservations) {
        this.reservations = reservations;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return reservations.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reservation reservation = reservations.get(rowIndex);
        switch (columnIndex) {
            case 0: return reservation.getReservationID();
            case 1: return reservation.getGuestID();
            case 2: return reservation.getRoomTypeID();
            case 3: return reservation.getRoomTypename();
            case 4: return reservation.getRoomNumber();
            case 5: return reservation.getPricePerNight();
            case 6: return reservation.getFirstName();
            case 7: return reservation.getLastName();
            case 8: return reservation.getEmail();
            case 9: return reservation.getPhone();
            case 10: return reservation.getCountry();
            case 11: return reservation.getBirthday();
            case 12: return reservation.getCheckInDate();
            case 13: return reservation.getCheckOutDate();
            case 14: return reservation.getCreateDate() ;           
            default: return null;
        }
    } 
    

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void addRow(Reservation res) {
    	reservations.add(res);
        fireTableRowsInserted(reservations.size() - 1, reservations.size() - 1);
    }

    public void removeRow(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < reservations.size()) {
        	reservations.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }
   
    
    public void clearData() {
    	reservations.clear();
        fireTableDataChanged(); // Notify listeners that data has changed
    }
    
    
}
