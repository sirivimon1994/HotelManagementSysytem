package model;

public class RoomType {
    private String roomTypeID;
    private String roomTypeName;
    private String roomName;
    private double pricePerNight;
    private int capacityAdults;
    private int capacityChildren;
    private String amenities;
    private String image;

    // Constructor
    public RoomType(String roomTypeID, String roomTypeName, String roomName,
                    double pricePerNight, int capacityAdults, int capacityChildren,
                    String amenities, String image) {
        this.roomTypeID = roomTypeID;
        this.roomTypeName = roomTypeName;
        this.roomName = roomName;
        this.pricePerNight = pricePerNight;
        this.capacityAdults = capacityAdults;
        this.capacityChildren = capacityChildren;
        this.amenities = amenities;
        this.image = image;
    }

    public String getRoomTypeID() {
		return roomTypeID;
	}

	public void setRoomTypeID(String roomTypeID) {
		this.roomTypeID = roomTypeID;
	}

	public String getRoomTypeName() {
		return roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public int getCapacityAdults() {
		return capacityAdults;
	}

	public void setCapacityAdults(int capacityAdults) {
		this.capacityAdults = capacityAdults;
	}

	public int getCapacityChildren() {
		return capacityChildren;
	}

	public void setCapacityChildren(int capacityChildren) {
		this.capacityChildren = capacityChildren;
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

	@Override
    public String toString() {
        return "RoomType{" +
                "roomTypeID='" + roomTypeID + '\'' +
                ", roomTypeName='" + roomTypeName + '\'' +
                ", roomName='" + roomName + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", capacityAdults=" + capacityAdults +
                ", capacityChildren=" + capacityChildren +
                ", amenities='" + amenities + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
