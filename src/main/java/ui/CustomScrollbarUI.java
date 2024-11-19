package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

import colors.HotelAppColors;

public class CustomScrollbarUI extends BasicScrollBarUI {
    private static final Color THUMB_COLOR = HotelAppColors.PASTEL_BLUE_1.getColor(); // Blue color for the thumb
    private static final Color TRACK_COLOR = HotelAppColors.WHITE_SMOKE.getColor(); // Light gray color for the track

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        // Set the thumb color
        g.setColor(THUMB_COLOR);
        g.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10); // Rounded corners
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        // Set the track color
        g.setColor(TRACK_COLOR);
        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createArrowButton(orientation);
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createArrowButton(orientation);
    }

    private JButton createArrowButton(int orientation) {
        JButton button = new JButton();
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusable(false);

        // You can customize the arrow button as needed here
        // Example: setting an icon or background color for the button
        return button;
    }
}
