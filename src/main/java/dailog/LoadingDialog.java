package dailog;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LoadingDialog {
	private JDialog dialog;
	
	public LoadingDialog(JFrame parentFrame) {
		dialog = new JDialog(parentFrame , "Loading" , true);
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(new JLabel("Loading , please wait...") , SwingConstants.CENTER);
		dialog.getContentPane().add(panel);
		dialog.setSize(200,100);
		dialog.setLocationRelativeTo(parentFrame);
		
	}
	
	public void show() {
		dialog.setVisible(true);
	}

	public void hide() {
		dialog.setVisible(false);
	}
}
