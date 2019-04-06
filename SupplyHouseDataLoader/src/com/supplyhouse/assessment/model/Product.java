package com.supplyhouse.assessment.model;

/**
 * Defines Model structure of a Product object in DB
 * @author Kalyan Sikdar
 */
public class Product {
	String productID;
	String productName;
	String quantity;
	
	/**
	 * Constructor to create a Product object
	 * 
	 * @param productID id of a product
	 * @param productName name of a product
	 * @param quantity quantity of the product
	 */
	public Product(String productID, String productName, String quantity) {
		this.productID = productID;
		this.productName = productName;
		this.quantity = quantity;
	}
}
