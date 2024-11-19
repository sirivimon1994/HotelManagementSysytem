package dailog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CustomDialog extends JDialog {
    private JButton okButton;
    private JButton cancelButton;

    public CustomDialog(JFrame parent, String title, String okText, String cancelText) {
        super(parent, title, true);
        setLayout(new BorderLayout());

        okButton = new JButton(okText);
        cancelButton = new JButton(cancelText);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setSize(300, 150);
        setLocationRelativeTo(parent); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void setOkActionListener(ActionListener listener) {
        okButton.addActionListener(listener);
    }

    public void setCancelActionListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }

    public void setContent(JComponent component) {
        add(component, BorderLayout.CENTER);
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}
