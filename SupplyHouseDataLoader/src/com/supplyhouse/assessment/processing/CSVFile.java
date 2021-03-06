package com.supplyhouse.assessment.processing;
import java.nio.file.Path;
import java.util.ArrayList;

import com.supplyhouse.assessment.model.Product;

/**
 * Reads a .csv file content from an input path 
 * to create Product objects from the file content
 * and create an array list of all the Products   
 * @author Kalyan Sikdar
 */
public class CSVFile extends InputFile {
	public CSVFile(Path file) {
		super(file);
	}

	/**
	 * Reads a file content from a particular path 
	 * and creates Product objects for each lines
	 * and creates an array list holding all the Product objects
	 * 
	 * @return {@code ArrayList<Product>}
	 */
	@Override
	public ArrayList<Product> readFile() {
		System.out.println("Read from a CSV file");
		return null;
	}
}
