package com.supplyhouse.assessment.db;

import java.util.ArrayList;

import com.supplyhouse.assessment.model.Product;

/**
 * Interface to design contract for all
 * DB oprations. 
 * @author Kalyan Sikdar
 *
 */
public interface DBHandler {

	public void insertData(ArrayList<Product> allProducts);
}
