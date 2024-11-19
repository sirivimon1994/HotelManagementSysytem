package tablemodel;



import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import colors.HotelAppColors;
import model.Room;
import utils.FontConfig;

public class RoomTableCellRenderer extends DefaultTableCellRenderer {
	   
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        RoomAvailableTableModel model = (RoomAvailableTableModel) table.getModel();
        Room room = model.getRoomAt(row);

        if (room.isSelected()) {
            c.setBackground(HotelAppColors.GOLDEN_ROD.getColor());  // Highlight added rows
        } else if (isSelected) {
            c.setBackground(HotelAppColors.TURQUOISE.getColor());  // Selected row color
        } else {
            c.setBackground(row % 2 == 0 ? HotelAppColors.WHITE_SMOKE.getColor() : HotelAppColors.LIGHT_GRAY.getColor());
            c.setForeground(HotelAppColors.CHARCOAL.getColor());
        }
        
        c.setFont(FontConfig.getBodyFont());
        
        return c;
    }
}