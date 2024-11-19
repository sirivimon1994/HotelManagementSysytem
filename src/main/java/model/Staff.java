package model;

import java.sql.*;

public class Staff extends Person {

    private int id;
    private String staffId;
    private String position;
    private Date startWorkDate;
    private String status;
    private Timestamp createDate;
    private Timestamp updateDate;

    // Parameterized constructor
    public Staff(int id, String staffId, String firstName, String lastName, String email, String phone,
                 String country, String birthday, String position, Date startWorkDate,
                 String status, Timestamp createDate, Timestamp updateDate) {
    	super(id, firstName, lastName, email, phone, country, birthday);
        this.id = id;
        this.staffId = staffId;
        this.position = position;
        this.startWorkDate = startWorkDate;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public java.sql.Date getStartWorkDate() {
        return startWorkDate;
    }

    public void setStartWorkDate(java.sql.Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", staffId='" + staffId + '\'' +
                ", position='" + position + '\'' +
                ", startWorkDate=" + startWorkDate +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", " + super.toString() + // Include details from the Person class
                '}';
    }
}
