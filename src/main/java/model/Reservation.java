package model;

import java.util.Date;

public class Reservation {

    private int reservationID;
    private int guestID;
    private int roomTypeID;
    private String roomTypename;
    private String roomNumber;
    private double pricePerNight;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String country;
    private String birthday;
    private Date checkInDate;
    private Date checkOutDate;
    private String createDate;
    private String updateDate;

    public Reservation() {
    	
    }
    // Constructor
    public Reservation( int reservationID, 
    					int guestID, 
    					int roomTypeID,
    					String roomTypename , 
    					String roomNumber,
                        double pricePerNight, 
                        String firstName, 
                        String lastName, 
                        String email, 
                        String phone, 
                        String country, 
                        String birthday, 
                        Date checkInDate, 
                        Date checkOutDate,
                        String createDate, 
                        String updateDate) {
        this.reservationID = reservationID; // 99 : pending  
        this.guestID = guestID;
        this.roomTypeID = roomTypeID;
        this.roomTypename = roomTypename;
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.birthday = birthday;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    // Getters and Setters
    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public int getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(int roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public String getRoomTypename() {
        return roomTypename;
    }

    public void setRoomTypename(String roomTypename) {
        this.roomTypename = roomTypename;
    }
    
    
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    // Optional: Override toString() for better readability
    @Override
    public String toString() {
        return "Reservation{" +
                "reservationID=" + reservationID +
                ", guestID=" + guestID +
                ", roomTypeID=" + roomTypeID +
                ", roomNumber='" + roomNumber + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                ", birthday=" + birthday +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
