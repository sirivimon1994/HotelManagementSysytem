package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Customer;



public class CustomerTableModel extends AbstractTableModel {
    private List<Customer> customers;
    private final String[] columnNames = {"ID", "Guest ID", "First Name", "Last Name", "Email", "Phone", "Country", "Birthday", "Create Date", "Update Date"};

    public CustomerTableModel() {
        this.customers = new ArrayList<>();
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return customers.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer customer = customers.get(rowIndex);
        switch (columnIndex) {
            case 0: return customer.getId();
            case 1: return customer.getGuestId();
            case 2: return customer.getFirstname();
            case 3: return customer.getLastname();
            case 4: return customer.getEmail();
            case 5: return customer.getPhone();
            case 6: return customer.getCountry();
            case 7: return customer.getBirthday();
            case 8: return customer.getCreateDate();
            case 9: return customer.getUpdateDate();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}