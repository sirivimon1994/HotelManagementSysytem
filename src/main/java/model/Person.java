package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Person {
	 private int id;

	 private String firstname;
	 private String lastname;
	 private String email;
	 private String phone;
	 private String country;
	 private String birthday;


	  // Constructor
	    public Person(int id, String firstName, String lastName, String email, String phone, String country, String birthday) {
	        this.id = id;
	        this.firstname = firstName;
	        this.lastname = lastName;
	        this.email = email;
	        this.phone = phone;
	        this.country = country;
	        this.birthday = birthday;
	    }
	    

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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


	

	 
}
