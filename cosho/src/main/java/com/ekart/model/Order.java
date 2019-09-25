package com.ekart.model;

public class Order {
  long order_id;
  String email_id;
  String product_id;
  int total_amount;
  private String shipping_address;
  
  public Order() {}
  
  public Long getOrder_id() { return Long.valueOf(order_id); }
  
  public void setOrder_id(long order_id) {
    this.order_id = order_id;
  }
  
  public String getEmail_id() { return email_id; }
  
  public void setEmail_id(String email_id) {
    this.email_id = email_id;
  }
  
  public String getProduct_id() { return product_id; }
  
  public void setProduct_id(String product_id) {
    this.product_id = product_id;
  }
  
  public int getTotal_amount() { return total_amount; }
  
  public void setTotal_amount(int total_amount) {
    this.total_amount = total_amount;
  }
  
  public String getShipping_address() { return shipping_address; }
  
  public void setShipping_address(String shipping_address) {
    this.shipping_address = shipping_address;
  }
}