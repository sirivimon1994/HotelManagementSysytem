package hotelmgmt.view;

import javax.swing.JPanel;
import javax.swing.JTable;

import colors.HotelAppColors;
import model.dao.CustomerDAO;
import tablemodel.CustomerTableModel;

public class CustomerMgmtView extends JPanel {
	
	private JTable customerTable;
	private CustomerTableModel customerTableModel;
	
	
	public CustomerMgmtView() {
		this.setBackground(HotelAppColors.WHITE_SMOKE.getColor());
		

	}
	
	public static void main(String[] args) {
	

	}

}
