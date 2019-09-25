package com.ekart.model;

public class Shipping {
	
	
	private int shipping_id;
	private String pin_code;
	private String state;
	private String city;
	private String name;
	private String address;
	private String contact_number;
	private String email_id;
	public int getShipping_id() {
		return shipping_id;
	}
	public void setShipping_id(int shipping_id) {
		this.shipping_id = shipping_id;
	}
	public String getPin_code() {
		return pin_code;
	}
	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	@Override
	public String toString() {
		return "Shipping [shipping_id=" + shipping_id + ", pin_code=" + pin_code + ", state=" + state + ", city=" + city
				+ ", name=" + name + ", address=" + address + ", contact_number=" + contact_number + ", email_id="
				+ email_id + "]";
	}
	
	
	
	

}
