package dailog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class DialogActionHandler implements ActionListener {
    private CustomDialog dialog;
    private ActionListener okActionListener;
    private ActionListener cancelActionListener;

    public DialogActionHandler(CustomDialog dialog, ActionListener okActionListener, ActionListener cancelActionListener) {
        this.dialog = dialog;
        this.okActionListener = okActionListener;
        this.cancelActionListener = cancelActionListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dialog.getOkButton()) {
            if (okActionListener != null) {
                okActionListener.actionPerformed(e);
            }
            dialog.dispose();
        } else if (e.getSource() == dialog.getCancelButton()) {
            if (cancelActionListener != null) {
                cancelActionListener.actionPerformed(e);
            }
            dialog.dispose();
        }
    }
}
