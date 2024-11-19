package hotelmgmt.view;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import colors.HotelAppColors;

import java.awt.*;
import java.util.Date;
import java.util.Calendar;

import tablemodel.CustomHeaderRenderer;
import tablemodel.RoomAvailableTableModel;
import tablemodel.RoomTableCellRenderer;
import tablemodel.SummaryTableModel;
import ui.CustomScrollbarUI;
import ui.colors.ColoredLineBorder;
import ui.companents.RoundButton;
import ui.companents.RoundJTextField;
import ui.companents.RoundedPanel;
import utils.FontConfig;
import datetime.CustomSpinnerDateModel;
import hotelmgmt.controller.ReservationController;

public class ReservationView extends JPanel {
	private ReservationController controller;
    // UI components
    private RoundJTextField searchidField,  guestIdField, firstNameField, lastNameField, emailField, phoneField, countryField, birthdayField;
    private RoundJTextField dayField, monthField, yearField ;
    private RoundButton checkAvailableButton, addCustomerAndRoomsButton, saveButton, generateCodeButton, clearAndCreateButton;
    private JButton fetchGuestDataButton;
    private JSpinner checkInDateSpinner, checkOutDateSpinner;
    private JTable roomTable, summaryTable;
    private RoomAvailableTableModel roomTableModel;
    private SummaryTableModel summaryTableModel;

    public ReservationView() {
    	this.setBackground(Color.WHITE);
        initializeComponents();
        setLayout(new BorderLayout());    
 
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Add your panels to the content panel
        contentPanel.add(createSearchPanel(), BorderLayout.NORTH);
        contentPanel.add(createCustomerAddRoomPanel(), BorderLayout.CENTER);
        contentPanel.add(createSummaryPanel(), BorderLayout.SOUTH);

        // Create a scroll pane and add the content panel to it
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Apply custom scrollbar UI
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollbarUI());
        scrollPane.getHorizontalScrollBar().setUI(new CustomScrollbarUI());
        
        // Add the scroll pane to the main panel
        add(scrollPane, BorderLayout.CENTER);
        
        
    }
    
    private void initializeComponents() {
    	System.out.println("Check Availability Button Clicked");
        initializeTextFields();
        initializeDatePickers();
        initializeButtons();
        initializeTables();
   
    }

    private void initializeTextFields() {
//    	searchidField = new RoundJTextField(15 , "Search Guest by Guest ID" );
        guestIdField = new RoundJTextField(10 , "" );
        firstNameField = new RoundJTextField(10 , "" );
        lastNameField = new RoundJTextField(10 , "" );
        emailField = new RoundJTextField(10 , "" );
        phoneField = new RoundJTextField(10 , "" );
        countryField = new RoundJTextField(10 , "" );
        birthdayField = new RoundJTextField(10 , "" );
        dayField =  new RoundJTextField(3,"");
        dayField.setPreferredSize(new Dimension(40, 25));
        monthField =   new RoundJTextField(3,"");
        monthField.setPreferredSize(new Dimension(40, 25));
        yearField = new RoundJTextField(3,"");
        yearField.setPreferredSize(new Dimension(80, 25));
    }


    private void initializeDatePickers() {
        checkInDateSpinner = createDateSpinner();
        checkOutDateSpinner = createDateSpinner();
    }

    private JSpinner createDateSpinner() {
        CustomSpinnerDateModel model = new CustomSpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        JSpinner spinner = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "yyyy-MM-dd");
        spinner.setEditor(editor);
        return spinner;
    }

    private void initializeButtons() {
        checkAvailableButton = createButton("Available rooms");
        clearAndCreateButton = createButton("Clear");
        addCustomerAndRoomsButton = createButton("Add Room");
        fetchGuestDataButton = createIconButton("Fetch");
        generateCodeButton = createButton("Generate");
        saveButton = createButton("Save");
    }
    
    private JButton createIconButton(String text) {
    	  JButton button = new JButton();
    	  ImageIcon icon = new ImageIcon(getClass().getResource("/images/search.png"));
    	  Image originalImage = icon.getImage();
    	  
    	  button.setOpaque(false); 
          button.setBorder(BorderFactory.createEmptyBorder()); 
          button.setContentAreaFilled(false);   	 

          Image resizedImage = originalImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
          ImageIcon resizedIcon = new ImageIcon(resizedImage);
          button.setIcon(resizedIcon);

    	  return button;
    }

    private RoundButton createButton(String text) {
    	RoundButton button = new RoundButton(text , 20);	  
    	 button.setFocusPainted(false);
         button.setFont(FontConfig.getBodyFont());
         button.setForeground(HotelAppColors.LIGHT_GRAY.getColor());
         button.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
         button.setCursor(new Cursor(Cursor.HAND_CURSOR));
         button.setBorderPainted(false);
        return button;
    }


    
    private void initializeTables() {
        roomTableModel = new RoomAvailableTableModel();
        roomTable = new JTable(roomTableModel);
        CustomHeaderRenderer.applyHeaderCustomization(roomTable);
        roomTable.setShowGrid(true);
        roomTable.setDefaultRenderer(Object.class, new RoomTableCellRenderer());
        
        
        summaryTableModel = new SummaryTableModel();
        summaryTable = new JTable(summaryTableModel);
        CustomHeaderRenderer.applyHeaderCustomization(summaryTable);
        summaryTable.getTableHeader().setDefaultRenderer(new CustomHeaderRenderer());
    }
    

    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.setOpaque(false);

        // Reservation label on the left
        JLabel reservationLabel = new JLabel("Reservation");
        reservationLabel.setFont(FontConfig.getTitleFont());
        reservationLabel.setForeground(HotelAppColors.DEEP_BLUE.getColor());
        searchPanel.add(reservationLabel, BorderLayout.WEST);

        // Search field and button on the right
        JPanel searchFieldPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchFieldPanel.setOpaque(false);

        if (searchidField == null) {
              searchidField = new RoundJTextField(15 , "Search Guest by Guest ID" );
        }
        searchidField.setPreferredSize(new Dimension(200, 30));  // Ensure it's visible

        // Initialize the fetch button if not already done
        if (fetchGuestDataButton == null) {
            fetchGuestDataButton = createIconButton("Fetch");
        }

        // Add the search field and button to the search panel
        searchFieldPanel.add(searchidField);
        searchFieldPanel.add(fetchGuestDataButton);
        searchPanel.add(searchFieldPanel, BorderLayout.EAST);

		JPanel wrapperPanel = new JPanel(new BorderLayout());
		wrapperPanel.setOpaque(false); 
		wrapperPanel.setBorder(BorderFactory.createEmptyBorder(10, 40 , 0, 40)); // Additional padding
		wrapperPanel.add(searchPanel, BorderLayout.CENTER);
		
        return wrapperPanel;
    }
    
    private JPanel createCustomerAddRoomPanel() {
        JPanel combinedPanel = new JPanel(new BorderLayout());
        combinedPanel.setOpaque(false); 
        combinedPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20)); 
        combinedPanel.setPreferredSize(new Dimension(0, 600));
        JPanel customerPanel = createCustomerPanel();
        JPanel roomPanel = createRoomPanel();

        combinedPanel.add(customerPanel, BorderLayout.WEST);
        combinedPanel.add(roomPanel, BorderLayout.CENTER);

        return combinedPanel;
    }
    

    private JPanel createCustomerPanel() {
    	
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
     
        
        JPanel custPanel = new JPanel(new BorderLayout());
        custPanel.setOpaque(false);
        custPanel.setLayout(new GridLayout(12, 2, 10, 10));

        JPanel searchGuestpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchGuestpanel.setOpaque(false);
        
//        searchGuestpanel.add(searchidField);
//        searchGuestpanel.add(fetchGuestDataButton); 
        
//        panel.add(new JLabel("Search Guest by Guest ID"));
//        panel.add(searchGuestpanel);
  
        custPanel.add(new JLabel("Guest ID:"));
        guestIdField.setEnabled(false);
        custPanel.add(guestIdField);

        custPanel.add(new JLabel("First Name:"));
        custPanel.add(firstNameField);

        custPanel.add(new JLabel("Last Name:"));
        custPanel.add(lastNameField);

        custPanel.add(new JLabel("Email:"));
        custPanel.add(emailField);

        custPanel.add(new JLabel("Phone:"));
        custPanel.add(phoneField);

        custPanel.add(new JLabel("Country:"));
        custPanel.add(countryField);

        // Birthday section
        JPanel birthdayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        birthdayPanel.setOpaque(false);
        birthdayPanel.add(dayField);
        birthdayPanel.add(new JLabel("/")); // Separator
        birthdayPanel.add(monthField);
        birthdayPanel.add(new JLabel("/")); // Separator
        birthdayPanel.add(yearField);
        
        custPanel.add(new JLabel("Birthday"));
        custPanel.add(birthdayPanel);
        
        custPanel.add(new JLabel("Check-In Date:"));
        custPanel.add(checkInDateSpinner);

        custPanel.add(new JLabel("Check-Out Date:"));
        custPanel.add(checkOutDateSpinner);

               
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setOpaque(false);
        checkAvailableButton.setPreferredSize(new Dimension(150, 30));  
        checkAvailableButton.setBackground(HotelAppColors.TEAL.getColor());
        addCustomerAndRoomsButton.setPreferredSize(new Dimension(150, 30)); 
        addCustomerAndRoomsButton.setBackground(HotelAppColors.DEEP_BLUE.getColor());
        buttonPanel.add(checkAvailableButton);
        buttonPanel.add(addCustomerAndRoomsButton);
    
        panel.add(custPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        
        // padding 1 

		JPanel wrapperPanel = new JPanel(new BorderLayout());
		wrapperPanel.setOpaque(false); 
		wrapperPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Additional padding
		wrapperPanel.add(panel, BorderLayout.CENTER);
        
        return wrapperPanel;
    }

    private JPanel createRoomPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.add(new JScrollPane(roomTable), BorderLayout.CENTER);
       
        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.setOpaque(false);
        wrapperPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
        wrapperPanel.add(panel, BorderLayout.CENTER);

        return wrapperPanel;
    }
    

    
    private JPanel createSummaryPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.add(new JScrollPane(summaryTable), BorderLayout.CENTER);
 
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setOpaque(false);
        saveButton.setPreferredSize(new Dimension(120, 30));  
        saveButton.setBackground(HotelAppColors.DEEP_BLUE.getColor());
        clearAndCreateButton.setPreferredSize(new Dimension(120, 30)); 
        clearAndCreateButton.setBackground(HotelAppColors.PRIMARY_RED.getColor());
        buttonPanel.add(saveButton);
        buttonPanel.add(clearAndCreateButton);
        
        panel.add(buttonPanel, BorderLayout.SOUTH);     
        panel.setPreferredSize(new Dimension(400, 400));
        
        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.setOpaque(false);
        wrapperPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 20, 20)); 
        wrapperPanel.add(panel, BorderLayout.CENTER);

        
        return wrapperPanel;
    }

    public JDialog createLoadingDialog(JFrame parentFrame) {
        JDialog dialog = new JDialog(parentFrame, "Loading", true);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Loading, please wait..."), BorderLayout.CENTER);
        dialog.getContentPane().add(panel);
        dialog.setSize(200, 100);
        dialog.setLocationRelativeTo(parentFrame);
        return dialog;
    } 
    
    public void setController(ReservationController controller) {
        this.controller = controller;
        if (controller != null) {
            controller.initialize(); // Setup action listeners
        }
    }
    
 // Getters for UI components
    public JTextField getSearchIdField() { return searchidField; }
    public JTextField getGuestIdField() { return guestIdField; }
    public JTextField getFirstNameField() { return firstNameField; }
    public JTextField getLastNameField() { return lastNameField; }
    public JTextField getEmailField() { return emailField; }
    public JTextField getPhoneField() { return phoneField; }
    public JTextField getCountryField() { return countryField; }
    public JTextField getDayField() { return dayField; }
    public JTextField getMonthField() { return monthField; }
    public JTextField getYearField() { return yearField; }
    public JSpinner getCheckInDateSpinner() { return checkInDateSpinner; }
    public JSpinner getCheckOutDateSpinner() { return checkOutDateSpinner; }
    public JButton getCheckAvailableButton() { return checkAvailableButton; }
    public JButton getaddCustomerAndRoomsButton() { return addCustomerAndRoomsButton; }
    public JButton getFetchGuestDataButton() { return fetchGuestDataButton; }
    public JButton getGenerateCodeButton() { return generateCodeButton; }
    public JButton getClearAndCreateButton() { return clearAndCreateButton; }
    public JButton getSaveButton() { return saveButton; }
    public JTable getRoomTable() { return roomTable; }
    public JTable getSummaryTable() { return summaryTable; }
    public RoomAvailableTableModel getRoomTableModel() { return roomTableModel;}
    public SummaryTableModel getSummaryTableModel() { return summaryTableModel; }
    
    
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test Frame");
            ReservationView view = new ReservationView();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(view);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
