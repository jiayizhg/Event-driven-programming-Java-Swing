/* Name: Jiayi Zhang
 Course: CNT 4714 – Fall 2019
 Assignment title: Program 1 – Event-driven Programming
 Date: Sunday September 22, 2019
*/

package com.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.model.Book;

public class InventoryController {
	
	private final String inventoryFile = "inventory.txt";
	private List<Book> books;

	public InventoryController(List<Book> books) {
		super();
		this.books = books;
	}
	
	public void InitInventoryController() {
		readInventoryFile(books);
	}
	
	private void readInventoryFile (List<Book> books) {
	
		BufferedReader bufferReader = null;
		
		// Read text from inventory file
		try{
			bufferReader = new BufferedReader(new FileReader(inventoryFile));
			
			// Read first line of the file
			String line =  bufferReader.readLine();
			
			// Read the file line by line
			while (line != null){
				String[] parseLine = new String[3];
				StringBuilder strBuilder = new StringBuilder(); 
				Book tempBook = new Book();
				
				// Split line by ","
				parseLine = line.split(",", 3);
				
				// Remove white space at the beginning of the book name
				StringBuilder fixStr = new StringBuilder(parseLine[1]); 
				fixStr.replace(0, 1, "");
				parseLine[1] = fixStr.toString();
				
				String temp = parseLine[2];
				// Replace white space at the beginning of the book price with a "$"
				StringBuilder addDollarSign = new StringBuilder(parseLine[2]); 
				addDollarSign.replace(0, 1, "$");
				parseLine[2] = addDollarSign.toString();
				
				// Build Book Info (contains bookID, bookName, and bookPrice)
				strBuilder.append(parseLine[0]);
				for (int i = 1; i < 3; i++) {
					strBuilder.append(" ");
					strBuilder.append(parseLine[i]);
				}
				
				// Set book values
				tempBook.setBookId(Integer.valueOf(parseLine[0]));
				tempBook.setBookName(parseLine[1]);
				tempBook.setBookPrice(Double.valueOf(temp));
				tempBook.setBookInfo(strBuilder.toString());
				
				// Add current book to book list
				books.add(tempBook);
		
//				System.out.println(tempBook.getBookId());
//				System.out.println(tempBook.getBookName());
//				System.out.println(tempBook.getBookPrice());
//				System.out.println(tempBook.getBookInfo());
				
				line =  bufferReader.readLine();
			}
		} catch(IOException e){
			e.printStackTrace();
		}
		
		// Close file
		try {
			bufferReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
