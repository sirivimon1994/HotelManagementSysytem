package model;

import java.time.LocalDateTime;

public class Customer extends Person {
    private String guestId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    // Constructor
    public Customer(int id, String guestId, String firstName, String lastName, String email, String phone,
                    String country, String birthday, LocalDateTime createDate, LocalDateTime updateDate) {
        super(id, firstName, lastName, email, phone, country, birthday);
        this.guestId = guestId;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    // Getters and setters
    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}