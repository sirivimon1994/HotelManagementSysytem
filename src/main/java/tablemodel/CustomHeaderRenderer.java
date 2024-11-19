package tablemodel;



import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import colors.HotelAppColors;
import utils.FontConfig;

public class CustomHeaderRenderer extends DefaultTableCellRenderer {
    private static final int PADDING_LEFT = 10; // Left padding
    private static final int PADDING_RIGHT = 10; // Right padding
    private static final int PADDING_TOP = 5; // Top padding
    private static final int PADDING_BOTTOM = 5; // Bottom padding
    private static final int BORDER_THICKNESS = 1; // Thickness of the column border
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Set custom font and color for header
        c.setFont(FontConfig.getMenuFont());
        c.setForeground(HotelAppColors.DEEP_BLUE.getColor());
        c.setBackground(HotelAppColors.PASTEL_BLUE.getColor());
        setHorizontalAlignment(CENTER); // Center-align the header text

        // Apply padding
        JTableHeader header = table.getTableHeader();
        if (header != null) {
            ((JLabel) c).setBorder(BorderFactory.createMatteBorder(0, 0, BORDER_THICKNESS, BORDER_THICKNESS, HotelAppColors.DEEP_BLUE.getColor()));
        }
        return c;
    }
    
    public static void applyHeaderCustomization(JTable table) {
        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 40)); // Set header row height
        header.setDefaultRenderer(new CustomHeaderRenderer()); // Apply custom renderer
    }
}