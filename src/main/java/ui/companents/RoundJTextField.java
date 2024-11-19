package ui.companents;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class RoundJTextField extends JTextField implements FocusListener {
    private int radius;
    private String hint;
    private boolean showingHint;
    private Insets padding;
    private Insets margin;

    public RoundJTextField(int radius, String hint) {
        this(radius, hint, new Insets(5, 10, 5, 10), new Insets(2, 2, 2, 2)); // Default padding and margin
    }

    public RoundJTextField(int radius, String hint, Insets padding, Insets margin) {
        this.radius = radius;
        this.hint = hint;
        this.padding = padding;
        this.margin = margin;
        this.showingHint = true;

        // Set initial hint text
        setText(hint);
        setForeground(Color.GRAY); // Hint text color
        setOpaque(false); // Make the background of the text field transparent
        setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        addFocusListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Paint the background
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(margin.left, margin.top, getWidth() - margin.left - margin.right, getHeight() - margin.top - margin.bottom, radius, radius);

        // Paint the text field contents
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Paint border with rounded corners
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.GRAY); // Border color
        g2.drawRoundRect(margin.left, margin.top, getWidth() - margin.left - margin.right - 1, getHeight() - margin.top - margin.bottom - 1, radius, radius);
        g2.dispose();
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (showingHint) {
            setText("");
            setForeground(Color.BLACK); // Text color when focused
            showingHint = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getText().isEmpty()) {
            setText(hint);
            setForeground(Color.GRAY); // Hint text color
            showingHint = true;
        }
    }

    @Override
    public String getText() {
        return showingHint ? "" : super.getText();
    }

    @Override
    public void setBorder(Border border) {
        // Prevent setting a regular border
    }
    
    @Override
    public Insets getInsets() {
        return new Insets(padding.top + margin.top, padding.left + margin.left, padding.bottom + margin.bottom, padding.right + margin.right);
    }

    @Override
    public Insets getInsets(Insets insets) {
        insets.set(padding.top + margin.top, padding.left + margin.left, padding.bottom + margin.bottom, padding.right + margin.right);
        return insets;
    }
}
