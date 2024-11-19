package hotelmgmt.controller;


import hotelmgmt.view.ReservationView;
import model.Customer;
import model.Reservation;
import model.Room;
import model.dao.ConnectionService;
import tablemodel.SummaryTableModel;
import utils.DateUtils;

import javax.swing.*;
import codegen.UniqueCodeGenerator;
import dailog.CustomDialog;
import dailog.LoadingDialog;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReservationController {
	private ConnectionService service = new ConnectionService();
    private ReservationView view;
    
    public ReservationController(ReservationView view) {
        this.view = view;
    }

    public  void initialize() {
        view.getGenerateCodeButton().addActionListener(e -> generateReservationCode());
        view.getFetchGuestDataButton().addActionListener(e -> fetchGuestData());
        view.getaddCustomerAndRoomsButton().addActionListener(e -> showDialogAddCustomerAndRoom());
        view.getCheckAvailableButton().addActionListener(e -> getAvailableRooms());
        view.getClearAndCreateButton().addActionListener(e -> showDialogClearAndCreate());
        view.getSaveButton().addActionListener(e -> updateAndSave());

    }

    private void generateReservationCode() {
        String code = UniqueCodeGenerator.generateUniqueCode();
        view.getSearchIdField().setText(code);
    }



	private void showDialogAddCustomerAndRoom() {
		if(isAllDataFilled() && isCheckInOutValid()) {
			  if(view.getSummaryTableModel().getRowCount() == 0) {
				  JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(view);
		    	  CustomDialog dialog = new CustomDialog(parent, "Warning", "OK", "Cancel");
		    	  String msg = "Please check guest's data before add room. Are you sure to continue?";
		          JLabel message = new JLabel(msg);
		          dialog.setContent(message);
	
		          ActionListener okListener = e -> {
		        	  addCustomerAndRoom();
		        	  setEnableGuestPanel(false);
		              dialog.dispose();
		          };
		          ActionListener cancelListener = e -> {
		              dialog.dispose();
		          };
		          dialog.setOkActionListener(okListener);
		          dialog.setCancelActionListener(cancelListener);
		          dialog.setVisible(true);
			  }else {
				  addCustomerAndRoom();
			  }
		}else {
  		  showErrorMessage("Please fill all data in form.");
  	}
    }
	

	private void setEnableGuestPanel(boolean isEnable) {
		  view.getSearchIdField().setEnabled(isEnable);
	      view.getGuestIdField().setEnabled(isEnable);
	      view.getFirstNameField().setEnabled(isEnable);
	      view.getLastNameField().setEnabled(isEnable);
	      view.getEmailField().setEnabled(isEnable);
	      view.getPhoneField().setEnabled(isEnable);
	      view.getCountryField().setEnabled(isEnable);
	      view.getDayField().setEnabled(isEnable);
	      view.getMonthField().setEnabled(isEnable);
	      view.getYearField().setEnabled(isEnable);
	      view.getCheckInDateSpinner().setEnabled(isEnable);
	      view.getCheckOutDateSpinner().setEnabled(isEnable);
	      view.getCheckAvailableButton().setEnabled(isEnable);
	      view.getFetchGuestDataButton().setEnabled(isEnable);
	}

	private void addCustomerAndRoom() {
		int selectedRow = view.getRoomTable().getSelectedRow();
    	
    	
   	 if (selectedRow == -1) {
            showErrorMessage("No room selected.");
            return;
        }

        Room selectedRoom = view.getRoomTableModel().getRoomAt(selectedRow);
        if (selectedRoom == null) {
            showErrorMessage("Selected room is not valid.");
            return;
        }

        if (selectedRoom.isSelected()) {
            showWarningMessage("Room has already been added.");
            return;
        }

        if (isValidDates((Date)view.getCheckInDateSpinner().getValue(), (Date)view.getCheckOutDateSpinner().getValue())) {
            Reservation res = createReservation(selectedRoom.getRoomTypeID() ,
							            		 selectedRoom.getRoomName() ,
							            		 selectedRoom.getRoomNumber() ,
							            		 selectedRoom.getPrice());
           		
            view.getSummaryTableModel().addRow(res);
            selectedRoom.setSelected(true);
            view.getRoomTableModel().fireTableRowsUpdated(selectedRow, selectedRow);
        }
	}
    
    private Reservation createReservation( int roomtypeid ,  String roomName , String roomNumber , double price  ) {
		Reservation res = new Reservation();
		res.setReservationID(99); // Set a unique ID in a real scenario
		res.setGuestID(99); // Set guest ID from the guest info
		res.setRoomTypeID(roomtypeid);
		res.setRoomTypename(roomName);
		res.setRoomNumber(roomNumber);
		res.setPricePerNight(price);
		res.setFirstName(view.getFirstNameField().getText());
		res.setLastName(view.getLastNameField().getText());
		res.setEmail(view.getEmailField().getText());
		res.setPhone(view.getPhoneField().getText());
		res.setCountry(view.getCountryField().getText());
		res.setBirthday(getBirthdayField());
		res.setCheckInDate((Date)view.getCheckInDateSpinner().getValue());
		res.setCheckOutDate((Date)view.getCheckOutDateSpinner().getValue());
		res.setCreateDate( DateUtils.getDateTimeNow());
		res.setUpdateDate( DateUtils.getDateTimeNow());
		return res;
	}
    
    private boolean isValidDates(Date checkInDate, Date checkOutDate) {
        if (checkInDate == null || checkOutDate == null) {
            showErrorMessage("Please select valid dates.");
            return false;
        }
        if (!checkInDate.before(checkOutDate) || checkInDate.before(new Date())) {
            showErrorMessage("Check-In Date must be before Check-Out Date and cannot be in the past.");
            return false;
        }
        return true;
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showWarningMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }
    
    private void fetchGuestData() {
   	 String guestId = view.getSearchIdField().getText();
   	 Customer guest  = service.callGuestDataByID(guestId);   
   	 setGuestData(guest);
   }

   private void setGuestData(Customer guest) {
	     view.getGuestIdField().setText(guest.getGuestId());
	     view.getFirstNameField().setText(guest.getFirstname());
	     view.getLastNameField().setText(guest.getLastname());
	     view.getEmailField().setText(guest.getEmail());
	     view.getPhoneField().setText(guest.getPhone());
	     view.getCountryField().setText(guest.getCountry());
	     view.getDayField().setText(guest.getBirthday().substring(8,10));
	     view.getMonthField().setText(guest.getBirthday().substring(5,7));
	     view.getYearField().setText(guest.getBirthday().substring(0,4));
	}
   
    private void getAvailableRooms() {
    	if(isAllDataFilled() && isCheckInOutValid()) {
    		 try {
             	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                 Date checkInDate = (Date) view.getCheckInDateSpinner().getValue();
                 Date checkOutDate = (Date) view.getCheckOutDateSpinner().getValue();
                 String formattedCheckInDate = checkInDate != null ? dateFormat.format(checkInDate) : "";
                 String formattedCheckOutDate = checkOutDate != null ? dateFormat.format(checkOutDate) : "";
                 List<Room> rooms = service.callRoomsAvailability(  formattedCheckInDate ,formattedCheckOutDate ,  0 , 0 , "" );
                if(rooms!= null && rooms.size() > 0  ) {
                	view.getRoomTableModel().setRoomAvailable(rooms);
                    view.getRoomTableModel().fireTableDataChanged();
                }
              
             } catch (Exception e) {
                 e.printStackTrace();
             }
    	}else {
    		  showErrorMessage("Please fill all data in form.");
    	}
    }

    private boolean isAllDataFilled() {
    	return  !view.getFirstNameField().getText().isEmpty()
                && !view.getLastNameField().getText().isEmpty()
                && !view.getEmailField().getText().isEmpty()
                && !view.getPhoneField().getText().isEmpty()
                && view.getCheckInDateSpinner().getValue() != null
                && view.getCheckOutDateSpinner().getValue() != null; 	
    }
    
    private boolean isCheckInOutValid() {
    	boolean isValid = isValidDates((Date)view.getCheckInDateSpinner().getValue(), (Date)view.getCheckOutDateSpinner().getValue());
    	return isValid;
    }
    
    private void showDialogClearAndCreate(){
    	  JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(view);
    	  CustomDialog dialog = new CustomDialog(parent, "Clear", "OK", "Cancel");
    	  String msg = "All data will be deleted. Are you sure you want to continue?";
          JLabel message = new JLabel(msg);
          dialog.setContent(message);

          ActionListener okListener = e -> {
        	  clearFields();
              dialog.dispose();
          };
          ActionListener cancelListener = e -> {
              dialog.dispose();
          };
          dialog.setOkActionListener(okListener);
          dialog.setCancelActionListener(cancelListener);
          dialog.setVisible(true);
    	
    }
    
    private void clearFields() {
    	 setEnableGuestPanel(true);
    	 view.getSearchIdField().setText("");
         view.getGuestIdField().setText("");
         view.getFirstNameField().setText("");
         view.getLastNameField().setText("");
         view.getEmailField().setText("");
         view.getPhoneField().setText("");
         view.getCountryField().setText("");
         view.getDayField().setText("");
         view.getMonthField().setText("");
         view.getYearField().setText("");
         view.getCheckInDateSpinner().setValue(new Date()); // Set to default value
         view.getCheckOutDateSpinner().setValue(new Date()); // Set to default value
         view.getSummaryTableModel().clearData();
         view.getRoomTableModel().clearData();
      
    }

    private void updateAndSave() {
    	 JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(view);
    	 LoadingDialog loadingDialog = new LoadingDialog(parent);  
    	 loadingDialog.show();
    	 String guestID = view.getGuestIdField().getText();
    	 /*
    	  * 1.  Add customer first  ( if customer have ID , add room immediately)
    	  * 2.	Add room
    	  */
    	 try {
    		 if( view.getGuestIdField().getText().equalsIgnoreCase("")) {

    	    		guestID =  service.callAddNewGuest( 
    				    				 view.getFirstNameField().getText() ,
    				    				 view.getLastNameField().getText() ,
    				    				 view.getEmailField().getText().equals(null)? "" : view.getEmailField().getText() , 
    				    				 view.getPhoneField().getText() ,
    				    				 view.getCountryField().getText() , 
    				    				 getBirthdayField() 
    				    			  ) ; 
    	    	 }
    	    	 
    	    	 
    	    	 if( guestID != null &&  !guestID.equals("")) {
    	    		 try {   		
    	     	        
    	        		 SummaryTableModel model = view.getSummaryTableModel();
    	        		 for (int row = 0; row < model.getRowCount() ; row++) {
    	        			 	int guestId = Integer.parseInt(guestID) ;
    	        			 	int roomTypeId = (int) model.getValueAt(row, 2);
    	        	            String roomNumber = model.getValueAt(row, 4).toString();
    	        	            String createDate = model.getValueAt(row, 14).toString();

    	                       Boolean rooms = service.callAddReservation( guestId , roomTypeId ,roomNumber , createDate );
    	                  }       		 
    	              
    	             } catch (Exception e) {
    	                 e.printStackTrace();
    	             }
    	    	 }
    	    	 loadingDialog.hide();
    	    		 
		} catch (Exception e) {
			 e.printStackTrace();
			 loadingDialog.hide();
		}
    }
    
    public String getBirthdayField() {
        String dayText = view.getDayField().getText().trim();
        String monthText = view.getMonthField().getText().trim();
        String yearText = view.getYearField().getText().trim();
        // Validate inputs
        if (dayText.isEmpty() || monthText.isEmpty() || yearText.isEmpty()) {
            showErrorMessage("Please fill all birthday fields.");
            return null;
        }
        int day, month, year;
        try {
            day = Integer.parseInt(dayText);
            month = Integer.parseInt(monthText);
            year = Integer.parseInt(yearText);
        } catch (NumberFormatException e) {
            showErrorMessage("Invalid number format in birthday fields.");
            return null;
        }
        if (day < 1 || day > 31 || month < 1 || month > 12) {
        	 showErrorMessage("Invalid day or month.");
            return null;
        }

        return String.format("%04d-%02d-%02d", year, month, day);
    }
    
    


    
}