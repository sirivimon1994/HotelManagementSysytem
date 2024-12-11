package hotelmgmt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import colors.HotelAppColors;
import hotelmgmt.controller.ReservationController;
import hotelmgmt.view.ReservationView;
import ui.colors.ColoredLineBorder;
import ui.companents.RoundedPanel;
import utils.FontConfig;
import view.CheckInOutPanel;
import view.CustomerPanel;
import view.LoginDialog;
import view.ReportsPanel;
import view.RoomTypePanel;
import view.StaffPanel;

public class MainFrame extends JFrame {

    private JLabel timeLabel;
    private JLabel menuTitleLabel;
    private JPanel contentPanel;
    static ResourceBundle bundle;
    public MainFrame() {
        
        LoginDialog loginDialog = new LoginDialog(this);
        loginDialog.setVisible(true);
        initializeFrame();
    }
    
    
    public void initializeFrame() {
        setTitle("Hotel Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initializeComponents();
        configureLayout();
    }

    private void initializeComponents() {
        contentPanel = new JPanel(new CardLayout());
        initializeContentPanels();
    }

    private void configureLayout() {
        JPanel leftMenuPanel = createLeftMenuPanel();
        JPanel headerAndTabsPanel = createHeaderAndTabsPanel();

        add(leftMenuPanel, BorderLayout.WEST);
        add(headerAndTabsPanel, BorderLayout.CENTER);
    }
    
    private void initializeContentPanels() {
        ReservationView reservationView = new ReservationView();
        ReservationController reservationController = new ReservationController(reservationView);
        reservationView.setController(reservationController);

        contentPanel.add(reservationView, bundle.getString("reservation"));
        contentPanel.add(new CheckInOutPanel(), bundle.getString("checkInOut"));
        contentPanel.add(new CustomerPanel(), bundle.getString("guests"));
        contentPanel.add(new StaffPanel(), bundle.getString("staff"));
        contentPanel.add(new ReportsPanel(), bundle.getString("reports"));
        contentPanel.add(new RoomTypePanel(), bundle.getString("roomTypes"));
    }

    private JPanel createHeaderAndTabsPanel() {
        JPanel headerAndTabsPanel = new JPanel(new BorderLayout());
        headerAndTabsPanel.add(createHeaderPanel(), BorderLayout.NORTH);
        headerAndTabsPanel.add(contentPanel, BorderLayout.CENTER);
        return headerAndTabsPanel;
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);

        JPanel appNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        appNamePanel.setOpaque(false);

        JLabel appNameLabel = new JLabel("Hotel Management System");
        appNameLabel.setFont(FontConfig.getHeaderFont());
        appNamePanel.add(appNameLabel);
    
        JPanel headerContentPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        headerContentPanel.setOpaque(false);

        JLabel headerLabel = new JLabel("Online system: ");
        headerLabel.setFont(FontConfig.getBodyFont());

        timeLabel = new JLabel("Time: ");
        JLabel userLabel = new JLabel("User: " + getCurrentUserName());

        headerContentPanel.add(headerLabel);
        headerContentPanel.add(timeLabel);
        headerContentPanel.add(userLabel);

        topPanel.add(appNamePanel, BorderLayout.WEST);
        topPanel.add(headerContentPanel, BorderLayout.EAST);

        JPanel menuTitlePanel = new JPanel(new BorderLayout());
        menuTitlePanel.setBackground(HotelAppColors.DARK_BLUE2.getColor());

        menuTitleLabel = new JLabel("Reservation");
        menuTitleLabel.setFont(FontConfig.getTitleFont());
        menuTitleLabel.setForeground(Color.WHITE);
        menuTitleLabel.setPreferredSize(new Dimension(0, 100));
        menuTitleLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0)); 
        menuTitlePanel.add(menuTitleLabel, BorderLayout.CENTER);

        headerPanel.add(topPanel, BorderLayout.NORTH);
        headerPanel.add(menuTitlePanel, BorderLayout.SOUTH);

        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        return headerPanel;
    }

    private String getCurrentUserName() {
        return "John Doe"; // Placeholder for current user name
    }

    private void updateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        timeLabel.setText("Time: " + sdf.format(new Date()));
    }


    private JPanel createLeftMenuPanel() {
        JPanel leftMenuPanel = new JPanel(new BorderLayout());
        leftMenuPanel.setBackground(HotelAppColors.DARK_BLUE.getColor());

        JPanel headerLeftPanel = new JPanel(new BorderLayout());
        headerLeftPanel.setOpaque(false);

        JLabel appNameLabel = new JLabel(getCurrentUserName(), SwingConstants.CENTER);
        appNameLabel.setFont(FontConfig.getHeaderPlainFont());
        appNameLabel.setForeground(Color.WHITE);
        appNameLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 30, 0)); 
        
        JLabel splitLabel = new JLabel("___________", SwingConstants.CENTER);
        splitLabel.setForeground(Color.WHITE);
        splitLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0)); 
        headerLeftPanel.add(appNameLabel, BorderLayout.NORTH);
        headerLeftPanel.add(splitLabel, BorderLayout.CENTER);

        leftMenuPanel.add(headerLeftPanel, BorderLayout.NORTH);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setOpaque(false);

     // Assuming 'bundle' is a ResourceBundle instance loaded for the appropriate Locale
        menuPanel.add(createMenuButton(bundle.getString("reservation"), "/images/menu_reservation.png", e -> showPanel("Reservation")));
        menuPanel.add(createMenuButton(bundle.getString("checkInOut"), "/images/menu_checkinout.png", e -> showPanel("Check-In/Out")));
        menuPanel.add(createMenuButton(bundle.getString("guests"), "/images/menu_guests.png", e -> showPanel("Guests")));
        menuPanel.add(createMenuButton(bundle.getString("staff"), "/images/menu_staff.png", e -> showPanel("Staff")));
        menuPanel.add(createMenuButton(bundle.getString("reports"), "/images/menu_reports.png", e -> showPanel("Reports")));
        menuPanel.add(createMenuButton(bundle.getString("roomTypes"), "/images/menu_rooms.png", e -> showPanel("Room Types")));


        leftMenuPanel.add(menuPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

        JButton exitButton = createMenuButton("Exit", "/images/menu_exit.png", e -> System.exit(0));
        bottomPanel.add(exitButton, BorderLayout.SOUTH);

        leftMenuPanel.add(bottomPanel, BorderLayout.SOUTH);

        return leftMenuPanel;
    }

    private JButton createMenuButton(String text, String iconPath, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setFont(FontConfig.getMenuFont());
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(0, 10, 20, 10)); 
        if (iconPath != null) {
            button.setIcon(createScaledIcon(iconPath, 25, 25));
        }

        button.addActionListener(actionListener);
        return button;
    }

    private ImageIcon createScaledIcon(String iconPath, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(getClass().getResource(iconPath));
        Image resizedImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private void showPanel(String panelName) {
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, panelName);
        updateMenuTitle(panelName);
    }

    private void updateMenuTitle(String title) {
        if (menuTitleLabel != null) {
            menuTitleLabel.setText(title);
        } else {
            System.out.println("menuTitleLabel is not initialized.");
        }
    }

    public static void main(String[] args) {
    	
    	    SwingUtilities.invokeLater(() -> {
    	    	 String baseName = "resources.strings";
    	    	    Locale locale = new Locale("de", "DE"); 
    	    	    bundle = ResourceBundle.getBundle(baseName, locale);
    	    	    System.out.println("Locale: " + Locale.getDefault());
    	    	    System.out.println("Bundle loaded: " + bundle.getLocale());
    	        MainFrame mainFrame = new MainFrame();
    	        mainFrame.setVisible(true);
    	    });
    }
}
