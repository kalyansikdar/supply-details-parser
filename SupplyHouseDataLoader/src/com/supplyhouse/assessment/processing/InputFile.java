package com.supplyhouse.assessment.processing;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import com.supplyhouse.assessment.model.Product;

/**
 * Abstract class to design contract for reading of 
 * different file types. Must be extended by all types
 * of files.
 * 
 * @author Kalyan Sikdar
 */
public abstract class InputFile {
	Path file;
	
	public InputFile(Path file) {
		this.file = file;
	}
	
	public abstract ArrayList<Product> readFile() throws IOException;
}
