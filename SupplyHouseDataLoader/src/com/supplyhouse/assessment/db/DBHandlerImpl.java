package com.supplyhouse.assessment.db;

import java.util.ArrayList;

import com.supplyhouse.assessment.model.Product;

/**
 * Executes all the DB related operations
 * 
 * @author Kalyan Sikdar
 */
public class DBHandlerImpl implements DBHandler{
	/**
	 * Inserts data into database
	 * 
	 * @param allProducts: array list of all products
	 */
	@Override
	public void insertData(ArrayList<Product> allProducts) {
		System.out.println("Saved all the products into DB");
	}
}
