package view;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import colors.HotelAppColors;
import ui.companents.RoundButton;
import ui.companents.RoundJTextField;
import ui.companents.RoundedPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginDialog extends JDialog {
    
    private JTextField usernameField;
    private RoundJTextField passwordField;
    private RoundButton loginButton;
    private boolean loginSuccessful = false;
    
    public LoginDialog(Frame parent) {
        super(parent, "Login", true);
        initComponents(parent);
    }
    
    private void initComponents(Frame parent) {
        setSize(400 , 300);
        setLocationRelativeTo(parent);
        setUndecorated(true); 
        setLayout(new BorderLayout());

        // Create content panel with padding
        RoundedPanel contentPanel = new RoundedPanel(20);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(HotelAppColors.DEEP_BLUE.getColor());
        add(contentPanel, BorderLayout.CENTER);

        // Add close icon
        addCloseIcon(contentPanel);

        // Username field
        usernameField = new RoundJTextField(15, "Username");
        styleTextField(usernameField);
        
        // Password field
        passwordField = new RoundJTextField(15, "Password");
        styleTextField(passwordField);

        // Buttons panel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setBackground(HotelAppColors.DEEP_BLUE.getColor());
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        // Login button
        loginButton = new RoundButton("Login" , 20);
        styleButton(loginButton);
        loginButton.addActionListener(e -> login());

        // Add components
        addComponents(contentPanel, buttonsPanel);
    }

    private void addCloseIcon(JPanel contentPanel) {
        // Create a label for the close icon
        JLabel closeLabel = new JLabel("X");
        closeLabel.setForeground(Color.WHITE);
        closeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        closeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        
        // Add a mouse listener to handle the click event
        closeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose(); // Close the dialog when the close icon is clicked
            }
        });

        // Create a panel to hold the close icon and set its alignment
        JPanel closePanel = new JPanel();
        closePanel.setLayout(new BoxLayout(closePanel, BoxLayout.X_AXIS));
        closePanel.setBackground(HotelAppColors.DEEP_BLUE.getColor());
        closePanel.add(Box.createHorizontalGlue()); // Push the close icon to the right
        closePanel.add(closeLabel);

        // Add the close panel to the content panel
        contentPanel.add(closePanel);
    }

    private void addComponents(JPanel contentPanel, JPanel buttonsPanel) {
        // Create and center icon label
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/loginicon.png"));
        JLabel iconLabel = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add components to content panel
        contentPanel.add(iconLabel);
        contentPanel.add(Box.createVerticalStrut(10)); 
        contentPanel.add(usernameField);
        contentPanel.add(Box.createVerticalStrut(10)); 
        contentPanel.add(passwordField);

        // Add buttons to button panel
        buttonsPanel.add(loginButton);

        // Add buttons panel to the content panel
        contentPanel.add(Box.createVerticalStrut(20)); 
        contentPanel.add(buttonsPanel);
    }

    private void styleTextField(JTextField textField) {
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBackground(new Color(240, 240, 240));
        textField.setPreferredSize(new Dimension(200, 30));
        textField.setCaretColor(Color.BLACK);

    }

    private void styleButton(JButton button) {
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(HotelAppColors.LIGHT_GRAY.getColor());
        button.setForeground(HotelAppColors.DEEP_BLUE.getColor());
        button.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorderPainted(false);
    }
    
    private void login() {
        loginSuccessful = true; // MOCK for successful login
        dispose();
    }

    public boolean isLoginSuccessful() {
        return loginSuccessful;
    }
}
