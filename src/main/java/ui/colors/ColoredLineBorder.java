package ui.colors;
import javax.swing.border.AbstractBorder;
import java.awt.*;

import javax.swing.border.AbstractBorder;
import java.awt.*;

public class ColoredLineBorder extends AbstractBorder {
    private final Color color;
    private final int thickness;

    public ColoredLineBorder(Color color, int thickness) {
        this.color = color;
        this.thickness = thickness;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawRect(x, y, width - thickness, height - thickness);
        g2d.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness);
    }
}
