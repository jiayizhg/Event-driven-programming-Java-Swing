/* Name: Jiayi Zhang
 Course: CNT 4714 – Fall 2019
 Assignment title: Program 1 – Event-driven Programming
 Date: Sunday September 22, 2019
*/

package com.model;

import java.util.List;

public class Book {
	
	private long bookId;
	private double bookPrice;
	private String bookName;
	private String bookInfo;

	public Book(long bookId, double bookPrice, String bookName, String bookInfo) {
		super();
		this.bookId = bookId;
		this.bookPrice = bookPrice;
		this.bookName = bookName;
		this.bookInfo = bookInfo;
	}
	
	public Book() {
		super();
	}
	
	public long getBookId() {
		return bookId;
	}
	
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	
	public double getBookPrice() {
		return bookPrice;
	}
	
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getBookInfo() {
		return bookInfo;
	}
	
	public void setBookInfo(String bookInfo) {
		this.bookInfo = bookInfo;
	}
}
