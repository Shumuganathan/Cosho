package com.ekart.model;

public class Product {
private String product_category_id;

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

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Product [product_category_id=" + product_category_id + "]";
}




}

