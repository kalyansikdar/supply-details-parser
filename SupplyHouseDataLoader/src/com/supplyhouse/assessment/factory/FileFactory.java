package com.supplyhouse.assessment.factory;
import java.nio.file.Path;

import com.supplyhouse.assessment.processing.CSVFile;
import com.supplyhouse.assessment.processing.ExcelFile;
import com.supplyhouse.assessment.processing.InputFile;
import com.supplyhouse.assessment.processing.TextFile;

/**
 * FileFactory class generates a File object 
 * based on the input file extension type
 * 
 * @author Kalyan Sikdar
 */
public class FileFactory {
	/**
	 * Creates an InputFile object based 
	 * on the input file's extension
	 * 
	 * @param fileNames directory location of the file 
	 * @return an InputFile object
	 */
	public InputFile makeFile(Path fileNames) {
		InputFile newFile = null;
		
		String fileName = fileNames.getFileName().toString();
		String fileExt = getFileExtension(fileName);
		
		switch(fileExt) {
			case "csv":
				newFile = new CSVFile(fileNames);
				break;
			case "xls":
				newFile = new ExcelFile(fileNames);
				break;
			case "txt":
				newFile = new TextFile(fileNames);
				break;
			default:
				newFile = null;
				break;
		}
		return newFile;
	}
	/**
	 * Finds the extension of a file
	 * 
	 * @param fileName
	 * @return {@code String}: extension of file
	 */
	private String getFileExtension(String fileName) {
		int index = fileName.lastIndexOf('.');
		return fileName.substring(index+1);
	}
}
