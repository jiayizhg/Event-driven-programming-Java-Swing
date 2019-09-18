/* Name: Jiayi Zhang
 Course: CNT 4714 – Fall 2019
 Assignment title: Program 1 – Event-driven Programming
 Date: Sunday September 22, 2019
*/

package com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.model.Book;
import com.model.BookOrder;
import com.view.StoreFrame;
import com.view.StoreOrderInfoPanel;
import com.view.StoreToolBar;

public class ButtonController {
	
	private String numItemText;
	private String bookIdText;
	private String bookQtyText;
	private String itemInfoText;
	private String subtotalText;
	private String filename = "transactions.txt";
	private String daterPermutation;
	
	private int orderNum;
	private int numItems;
	private int couter;
	private long bookId;
	private double bookPrice;
	private double subtotal;
	private String orderDate;

	private List<Book> books;
	private List<BookOrder> bookOrders;
	private StoreOrderInfoPanel infoPanel;
	private StoreToolBar toolBar;
	private StoreFrame storeFrame;
	private DateFormat df = new SimpleDateFormat("MM/dd/yy hh:mm:ss a z");
	private DateFormat dfPermutation = new SimpleDateFormat("ddMMYYYYhhmm");
	
	private JTextField button;
	
	public ButtonController(List<Book> books, StoreFrame storeFrame) {
		super();
		this.books = books;
		this.storeFrame = storeFrame;
		this.infoPanel = storeFrame.getPanel();
		this.toolBar = storeFrame.getToolBar();
	}
	

	public void InitButtonController() {
		
		orderNum = 1;
		numItems = -1;
		bookOrders = new ArrayList<BookOrder>();
		toolBar.getProcessItemBtn().addActionListener(e -> processItemHandler());
		toolBar.getConfirmItemBtn().addActionListener(e -> confirmItemHandler());
		toolBar.getViewOrderBtn().addActionListener(e -> viewOrderHandler());
		toolBar.getFinishOrderBtn().addActionListener(e -> finishOrderHandler());
		toolBar.getNewOrderBtn().addActionListener(e -> newOrderHandler());
		toolBar.getExitBtn().addActionListener(e -> exitHandler());
	}
	
	private String hasBook(long bookId) {
		
		for (Book book : books) {
			if (book.getBookId() == bookId)
				return book.getBookInfo();
		}
		
		return null;
	}
	
	private void transactionFileHandler() {
		
		try {
			FileWriter file = new FileWriter(filename, true);
			BufferedWriter writer = new BufferedWriter(file);
			for (BookOrder bookOrder : bookOrders) {
				writer.write(bookOrder.getDatePermutation() + ", ");
				writer.write(bookOrder.getBookId()  + ", "); 
				writer.write(bookOrder.getBookName()  + ", "); 
				writer.write(bookOrder.getBookPrice()  + ", "); 
				writer.write(bookOrder.getBookQty()  + ", "); 
				writer.write(bookOrder.getBookDisc() * 0.01  + ", "); 
				writer.write("$" + bookOrder.getTotalPrice()  + ", "); 
				writer.write(bookOrder.getOrderDate());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int setBookDisc(int bookQty) {
		
		if (bookQty >=1 && bookQty <= 4)
			return 0;
		else if (bookQty >= 5 && bookQty <= 9)
			return 10;
		else if (bookQty >= 10 && bookQty <= 14)
			return 15;
		else if (bookQty >= 15)
			return 20;
		
		return -1;
	}
	
	private String getBookName (long bookId) {
		
		for (Book book : books) {
			if (book.getBookId() == bookId)
				return book.getBookName();
		}
		
		return null;
	}
	
	private double getBookPrice(long bookId) {
		
		for (Book book : books) {
			if (book.getBookId() == bookId) {
				return book.getBookPrice();
			}
		}
		
		return -1;
	}

	private void exitHandler() {
		// close window and exit program
		storeFrame.dispose();
	}

	private void newOrderHandler() {
		// Reset all variables
		orderNum = 1;
		numItems = -1;
		bookId = 0;
		bookPrice = 0;
		subtotal = 0;
		orderDate = "";
		bookOrders.clear();
		
		// Clear all text fields
		infoPanel.getTextField_bookId().setText("");
		infoPanel.getTextField_bookQty().setText("");
		infoPanel.getTextField_itemInfo().setText("");
		infoPanel.getTextField_numItem().setText("");
		infoPanel.getTextField_subtotal().setText("");
		
		// Reset all buttons
		toolBar.getProcessItemBtn().setEnabled(true);
		toolBar.getConfirmItemBtn().setEnabled(false);
		toolBar.getProcessItemBtn().setText("Process Item #1");
		toolBar.getConfirmItemBtn().setText("Confirm Item #1");
		toolBar.getFinishOrderBtn().setEnabled(false);
		toolBar.getViewOrderBtn().setEnabled(false);

		// Reset all labels
		infoPanel.getBookId().setText("Enter Book ID for item #1:");
		infoPanel.getBookQty().setText("Enter quantity for item #1:");
		infoPanel.getSubtotal().setText("Order subtotal for 0 item(s):");
		infoPanel.getItemInfo().setText("Item #1 info:");
		
		// Enable all text fields
		infoPanel.getTextField_itemInfo().setEnabled(true);
		infoPanel.getTextField_bookId().setEnabled(true);
		infoPanel.getTextField_bookQty().setEnabled(true);
		infoPanel.getTextField_numItem().setEnabled(true);
		infoPanel.getTextField_subtotal().setEnabled(true);

	}

	private void finishOrderHandler() {
		String message = "";
		
		df.setTimeZone(TimeZone.getTimeZone("EST5EDT"));
		orderDate = df.format(new Date());
		
		dfPermutation.setTimeZone(TimeZone.getTimeZone("EST5EDT"));
		daterPermutation = dfPermutation.format(new Date());
		
		for (BookOrder bookOrder : bookOrders) {
			bookOrder.setOrderDate(orderDate);
			bookOrder.setDatePermutation(daterPermutation);
		}
		
		message += "Date: " + orderDate + "\n\n";
		message += "Number of line items: " + numItems + "\n\n";
		message += "Item# / ID / Title / Price / Qty / Disc % / Subtotal:\n\n";
		
		for (BookOrder bookOrder : bookOrders) {
			message += bookOrder.getOrderNum() + ". " + bookOrder.getBookInfo() + "\n";
		}
		
		message += "\n" + "Order subtotal: $" + subtotal + "\n\n";
		message += "Tax rate: 6%\n\n";
		double taxAmount = subtotal * 0.06;
		taxAmount = Math.round(taxAmount * 100.0) / 100.0;
		message += "Tax amount: $" + taxAmount + "\n\n";
		message += "Order total: $" + subtotal + "\n\n";
		message += "Thanks for shopping at E-BookStore!";
		JOptionPane.showMessageDialog(null, message);
		
		// Write to transaction file
		transactionFileHandler();
	}

	private void viewOrderHandler() {
		String message = "";
	
		for (BookOrder bookOrder : bookOrders) {
			message += bookOrder.getOrderNum() + ". " + bookOrder.getBookInfo() + "\n";
		}
		
		JOptionPane.showMessageDialog(null, message.trim());
	}

	private void confirmItemHandler() {
	
		for (BookOrder bookOrder : bookOrders) {
			if (bookOrder.getOrderNum() == orderNum) {
				if (bookOrder.getBookInfo() != null) {
					JOptionPane.showMessageDialog(null, "Item #" + bookOrder.getOrderNum() + " accepted");
					bookPrice = bookOrder.getBookPrice();
					subtotal += bookPrice;
					subtotal = Math.round(subtotal * 100.0) / 100.0;
					bookOrder.setBookName(getBookName(bookOrder.getBookId()));
				}
			}
		}
		
		infoPanel.getTextField_bookId().setText("");
		infoPanel.getTextField_bookQty().setText("");
		String subtotalStr = "$" + subtotal;
		infoPanel.getTextField_subtotal().setText(subtotalStr);
		
		if (orderNum == numItems) {
			toolBar.getProcessItemBtn().setText("Process Item");
			toolBar.getConfirmItemBtn().setText("Confirm Item");
			toolBar.getProcessItemBtn().setEnabled(false);
			toolBar.getConfirmItemBtn().setEnabled(false);
			toolBar.getViewOrderBtn().setEnabled(true);
			toolBar.getFinishOrderBtn().setEnabled(true);
			infoPanel.getTextField_itemInfo().setEnabled(false);
			infoPanel.getTextField_bookId().setEnabled(false);
			infoPanel.getTextField_bookQty().setEnabled(false);
			infoPanel.getTextField_numItem().setEnabled(false);
			infoPanel.getTextField_subtotal().setEnabled(false);
			infoPanel.getBookId().setText("");
			infoPanel.getBookQty().setText("");
		}
		else {
			// Increase order number by 1
			orderNum++;
			toolBar.getProcessItemBtn().setText("Process Item #" + orderNum);
			toolBar.getProcessItemBtn().setEnabled(true);
			toolBar.getConfirmItemBtn().setText("Confirm Item #" + orderNum);
			toolBar.getConfirmItemBtn().setEnabled(false);
			
			toolBar.getViewOrderBtn().setEnabled(true);
			toolBar.getFinishOrderBtn().setEnabled(true);
			
			infoPanel.getBookId().setText("Enter Book ID for item #" + orderNum + ":");
			infoPanel.getBookQty().setText("Enter quantity for item #" + orderNum + ":");
			infoPanel.getSubtotal().setText("Order subtotal for " + (orderNum - 1) + " item(s):");
			infoPanel.getItemInfo().setText("Item #" + (orderNum - 1) + " info:");
			
		}
	}

	private void processItemHandler() {

		BookOrder bookOrder = new BookOrder();
		
		// Get texts from text fields then set fields of bookOrder
		if (!infoPanel.getTextField_numItem().getText().isEmpty()) {
			numItems = Integer.valueOf(infoPanel.getTextField_numItem().getText());
		}
		
		if (!infoPanel.getTextField_numItem().getText().isEmpty()) {
			numItemText = infoPanel.getTextField_numItem().getText();
			bookOrder.setNumItems(Integer.valueOf(numItemText));
		}
		
		if (!infoPanel.getTextField_bookId().getText().isEmpty()) {
			
			bookIdText = infoPanel.getTextField_bookId().getText();
			bookOrder.setBookId(Long.valueOf(bookIdText));
			
		}
		
		if (!infoPanel.getTextField_bookQty().getText().isEmpty()) {
			bookQtyText = infoPanel.getTextField_bookQty().getText();
			bookOrder.setBookQty(Integer.valueOf(bookQtyText));
		}
		
		bookOrder.setOrderNum(orderNum);
		bookOrder.setBookDisc(setBookDisc(bookOrder.getBookQty()));
		
		bookId = bookOrder.getBookId();
		
		double pricePerBook = getBookPrice(bookOrder.getBookId());

		itemInfoText = hasBook(bookOrder.getBookId());
	
		// Display item info
		if (itemInfoText != null) {
			
			// Enable Confirm Item button
			toolBar.getConfirmItemBtn().setEnabled(true);
			// Disable Process Item button
			toolBar.getProcessItemBtn().setEnabled(false);
			
		
			StringBuilder strBuilder = new StringBuilder(itemInfoText);
			strBuilder.append(" " + bookOrder.getBookQty());
			strBuilder.append(" " + bookOrder.getBookDisc() + "%");
			
			// Calculate total price
			double disc = (100 - bookOrder.getBookDisc()) * 0.01;
			double totalPrice = pricePerBook * bookOrder.getBookQty() * disc;
			// Round totalPrice to 2 decimal points
			totalPrice = Math.round(totalPrice * 100.0) / 100.0;
			
			bookOrder.setBookPrice(pricePerBook);
			bookOrder.setTotalPrice(totalPrice);
			
			strBuilder.append(" $" + totalPrice);
			
			itemInfoText = strBuilder.toString();
			
			infoPanel.getTextField_itemInfo().setText(itemInfoText);
			bookOrder.setBookInfo(itemInfoText);
			bookOrders.add(bookOrder);
		}
		else if (itemInfoText == null) {
			JOptionPane.showMessageDialog(null, "Book ID " + bookId + " not in file");
		}
			
	}
	
	
}
