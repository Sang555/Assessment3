package com.sapient.assessment3.model;

import javax.persistence.*;


@Entity
@Table(name = "user_details")
public class UserDetails {
    @Id
    @Column(name="user_id")
    private long id;
	private String city;
    private String state;
    private String zipCode;


    public UserDetails()
    {
    	
    }
    public UserDetails(long id, String city, String state, String zipCode) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}


  
}
