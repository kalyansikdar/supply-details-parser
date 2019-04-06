package com.supplyhouse.assessment;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.supplyhouse.assessment.db.DBHandler;
import com.supplyhouse.assessment.db.DBHandlerImpl;
import com.supplyhouse.assessment.factory.FileFactory;
import com.supplyhouse.assessment.model.Product;
import com.supplyhouse.assessment.processing.InputFile;

/**
 * This driver Program reads files of different types 
 * such as .txt, .xls, or .csv from SupplyHouse's 
 * common file directory and creates a file object of 
 * type TextFile, ExcelFile, or CSVFile respectively 
 * using Factory Design Pattern. 
 * In Factory design pattern objects are created 
 * without exposing the creation logic to the client 
 * and refer to common objects using a common 
 * interface. Additionally, in case any new type of 
 * file type such as .pdf file has to be processed, 
 * only a new class PDFFile extending abstract class
 * InputFile has to be added. Sample implementation 
 * of how data from each file type will be read has been 
 * shown in TextFile class. 
 *  
 * @author "Kalyan Sikdar"
 */
public class Main {

	public static void main(String[] args) {
		
		ArrayList<Product> products = new ArrayList<>();
		ArrayList<Product> allProducts = new ArrayList<>();
		
		try {
			FileFactory fileFactory = new FileFactory();
			
			//reads files from the directory /fileDirectory
			List<Path> fileList = Files.list(Paths.get("/fileDirectory"))
					.collect(Collectors.toList());
			
			for (Path f : fileList) {
				InputFile fileRef = fileFactory.makeFile(f); //creates a reference for each file
				//reads each file content and stores into array list-products
				products = fileRef.readFile();
				// stores all products objects into the array list allProducts
				allProducts.addAll(products);  
				
			}
			
			// Pluggable DB implementation
			DBHandler dbHanndler = new DBHandlerImpl();
			dbHanndler.insertData(allProducts); // inserts data into the database
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
