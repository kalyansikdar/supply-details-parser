package com.supplyhouse.assessment.processing;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import com.supplyhouse.assessment.model.Product;

/**
 * Reads a .txt file content from an input path 
 * to create Product objects from the file content
 * and create an array list of all the Products   
 * @author Kalyan Sikdar
 */
public class TextFile extends InputFile {
	
	public TextFile(Path file) {
		super(file);
	}
	
	/**
	 * Reads a file content from a particular path 
	 * and creates Product objects for each lines
	 * and creates an array list holding all the Product objects
	 * Sample implementation below.
	 * 
	 * @return {@code ArrayList<Product>}
	 */
	@Override
	public ArrayList<Product> readFile() throws IOException {
		ArrayList<Product> productList = new ArrayList<Product>();
		
		String filePath = file.toString();
		System.out.println("from text file class: " + filePath);
		Scanner scanner = new Scanner(new File(filePath));
		scanner.useDelimiter("\n");
		scanner.next();
		
		while (scanner.hasNext()) {
			String line = scanner.next();
			System.out.println("Line:" + line);
			String[] data = line.split("\t");
			String productID = data[1];
			String productName = data[2];
			String quantity = data[3];
			
			Product product = new Product(productID, productName, quantity);
			productList.add(product);
		}
		scanner.close();
		return productList;
	}
}
