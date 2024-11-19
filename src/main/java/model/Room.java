package model;

public class Room {

    private int roomTypeID;
    private String roomName;
    private String roomNumber;
    private int adult;
    private int children;
    private double price;
    private String amenities;
    private int roomCount;
    private String image;    
    private boolean selected;
    
    public Room() {
    	
    }
    
    // Constructor, getters, and setters
    public Room(int roomTypeID, int adult, int children, double price, int roomCount,
            String amenities, String image ,String roomName ,String roomNumber  ) {
        this.roomTypeID = roomTypeID;
        this.roomName = roomName;
        this.roomNumber = roomNumber;
        this.adult = adult;
        this.children = children;
        this.price = price;
        this.roomCount = roomCount;
        this.amenities = amenities;
        this.image = image;
    }
    
    // Getters and setters
    public int getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(int roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    public boolean isSelected() {
		return selected; 
	}
    
    public void setSelected(boolean selected) {
		this.selected = selected;
	}
    
    @Override
    public String toString() {
        return "Room [roomTypeID=" + roomTypeID + ", roomName=" + roomName + ", adultCapacity=" + adult
                + ", childrenCapacity=" + children + ", price=" + price + ", roomCount=" + roomCount
                + ", amenities=" + amenities + ", image=" + image + "]";
    }
    
}
