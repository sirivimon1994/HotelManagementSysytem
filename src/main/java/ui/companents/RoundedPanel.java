package ui.companents;

import javax.swing.*;
import java.awt.*;


public class RoundedPanel extends JPanel {
    private final int cornerRadius;
    private Color borderColor = new Color(255, 255, 255, 0); // Default border color with transparency

    public RoundedPanel(int radius) {
        this.cornerRadius = radius;
        setOpaque(false);
    }
 
    public void setBorderColor(Color color) {
        this.borderColor = color;
    }

    public void setBorderTransparency(int alpha) {
        // Ensure alpha is within the valid range (0-255)
        alpha = Math.max(0, Math.min(255, alpha));
        this.borderColor = new Color(borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue(), alpha);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw background
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        // Draw border
        g2d.setColor(borderColor);
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        g2d.dispose();
    }
}
