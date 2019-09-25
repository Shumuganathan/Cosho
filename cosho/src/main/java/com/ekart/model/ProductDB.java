package com.ekart.model;

import java.sql.Blob;

public class ProductDB {
private String product_id;
private String product_name;
private String brand_name;
private String product_category_id;
private String product_image_name;
private String product_description;
private int item_left_in_stock;
private int product_cost;
private long order_id;
/**
 * @return the product_id
 */
public String getProduct_id() {
	return product_id;
}
/**
 * @param product_id the product_id to set
 */
public void setProduct_id(String product_id) {
	this.product_id = product_id;
}
/**
 * @return the product_name
 */
public String getProduct_name() {
	return product_name;
}
/**
 * @param product_name the product_name to set
 */
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}

public String getBrand_name() {
	return brand_name;
}
public void setBrand_name(String brand_name) {
	this.brand_name = brand_name;
}
/**
 * @return the product_category_id
 */
public String getProduct_category_id() {
	return product_category_id;
}
/**
 * @param product_category_id the product_category_id to set
 */
public void setProduct_category_id(String product_category_id) {
	this.product_category_id = product_category_id;
}

public String getProduct_image_name() {
	return product_image_name;
}
public void setProduct_image_name(String product_image_name) {
	this.product_image_name = product_image_name;
}
/**
 * @return the product_description
 */
public String getProduct_description() {
	return product_description;
}
/**
 * @param product_description the product_description to set
 */
public void setProduct_description(String product_description) {
	this.product_description = product_description;
}
/**
 * @return the item_left_in_stock
 */
public int getItem_left_in_stock() {
	return item_left_in_stock;
}
/**
 * @param item_left_in_stack the item_left_in_stock to set
 */
public void setItem_left_in_stock(int item_left_in_stock) {
	this.item_left_in_stock = item_left_in_stock;
}
/**
 * @return the product_cost
 */
public int getProduct_cost() {
	return product_cost;
}
/**
 * @param product_cost the product_cost to set
 */
public void setProduct_cost(int product_cost) {
	this.product_cost = product_cost;
}

/**
 * @return the order_id
 */
public long getOrder_id() {
	return order_id;
}
/**
 * @param order_id the order_id to set
 */
public void setOrder_id(long order_id) {
	this.order_id = order_id;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "ProductDB [product_id=" + product_id + ", product_name=" + product_name + ", brand_name=" + brand_name
			+ ", product_category_id=" + product_category_id + ", product_image_name=" + product_image_name
			+ ", product_description=" + product_description + ", item_left_in_stock=" + item_left_in_stock
			+ ", product_cost=" + product_cost + ", order_id=" + order_id + "]";
}







}
