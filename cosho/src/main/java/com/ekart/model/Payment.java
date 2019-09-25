package com.ekart.model;

public class Payment {
	
	private int cardId;
	private String card_number;
	private String card_holder_name;
	private int expiry_month;
	private int expiry_year;
	private int cvv;
	private String email_id;
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public String getCard_number() {
		return card_number;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	public String getCard_holder_name() {
		return card_holder_name;
	}
	public void setCard_holder_name(String card_holder_name) {
		this.card_holder_name = card_holder_name;
	}
	
	public int getExpiry_month() {
		return expiry_month;
	}
	public void setExpiry_month(int expiry_month) {
		this.expiry_month = expiry_month;
	}
	public int getExpiry_year() {
		return expiry_year;
	}
	public void setExpiry_year(int expiry_year) {
		this.expiry_year = expiry_year;
	}
	
	
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	@Override
	public String toString() {
		return "Payment [cardId=" + cardId + ", card_number=" + card_number + ", card_holder_name=" + card_holder_name
				+ ", expiry_month=" + expiry_month + ", expiry_year=" + expiry_year + ", cvv=" + cvv + ", email_id="
				+ email_id + "]";
	}
	
	
	

}
