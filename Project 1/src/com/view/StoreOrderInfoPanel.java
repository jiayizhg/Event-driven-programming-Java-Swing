/* Name: Jiayi Zhang
 Course: CNT 4714 – Fall 2019
 Assignment title: Program 1 – Event-driven Programming
 Date: Sunday September 22, 2019
*/

package com.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.model.Book;
import com.model.BookOrder;

public class StoreOrderInfoPanel extends JPanel {
	
	private JLabel numItem;
	private JLabel bookId;
	private JLabel bookQty;
	private JLabel itemInfo;
	private JLabel subtotal;

	private JTextField textField_numItem;
	private JTextField textField_bookId;
	private JTextField textField_bookQty;
	private JTextField textField_itemInfo;
	private JTextField textField_subtotal;

	public StoreOrderInfoPanel() {
		
		setBackground(Color.decode("#3A3A3C"));
		setSize(830, 190);
		setLayout(null);

		numItem = new JLabel("Enter number of Items in this order" + ":");
		numItem.setForeground(Color.decode("#EEBA4C"));
		numItem.setBounds(110, 26, 230, 16);
		
		bookId = new JLabel("Enter Book ID for item #1" + ":");
		bookId.setForeground(Color.decode("#EEBA4C"));
		bookId.setBounds(171, 54, 170, 16);
	
		
		bookQty = new JLabel("Enter quantity for item #1" + ":");
		bookQty.setForeground(Color.decode("#EEBA4C"));
		bookQty.setBounds(168, 82, 190, 16);
		
		
		itemInfo = new JLabel("Item #1 info:");
		itemInfo.setForeground(Color.decode("#EEBA4C"));
		itemInfo.setBounds(252, 110, 90, 16);
	
		 
		subtotal = new JLabel("Order subtotal for 0 item(s):");
		subtotal.setForeground(Color.decode("#EEBA4C"));
		subtotal.setBounds(160, 138, 180, 16);
		
		
		add(numItem);
		add(bookId);
		add(bookQty);
		add(itemInfo);
		add(subtotal);
		
		textField_numItem = new JTextField();
		textField_numItem.setBounds(340, 25, 485, 26);
		textField_numItem.setColumns(10);
		
		textField_bookId= new JTextField();
		textField_bookId.setBounds(340, 52, 485, 26);
		textField_bookId.setColumns(10);
		
		textField_bookQty = new JTextField();
		textField_bookQty.setBounds(340, 79, 485, 26);
		textField_bookQty.setColumns(10);
		
		textField_itemInfo = new JTextField();
		textField_itemInfo.setBounds(340, 106, 485, 26);
		textField_itemInfo.setColumns(10);
		
		textField_subtotal = new JTextField();
		textField_subtotal.setBounds(340, 133, 485, 26);
		textField_subtotal.setColumns(10);
		
		add(textField_numItem);
		add(textField_bookId);
		add(textField_bookQty);
		add(textField_itemInfo);
		add(textField_subtotal);
	}
	
	public JTextField getTextField_numItem() {
		return textField_numItem;
	}

	public void setTextField_numItem(JTextField textField_numItem) {
		this.textField_numItem = textField_numItem;
	}

	public JTextField getTextField_bookId() {
		return textField_bookId;
	}

	public void setTextField_bookId(JTextField textField_bookId) {
		this.textField_bookId = textField_bookId;
	}

	public JTextField getTextField_bookQty() {
		return textField_bookQty;
	}

	public void setTextField_bookQty(JTextField textField_numQty) {
		this.textField_bookQty = textField_numQty;
	}

	public JTextField getTextField_itemInfo() {
		return textField_itemInfo;
	}

	public void setTextField_itemInfo(JTextField textField_itemInfo) {
		this.textField_itemInfo = textField_itemInfo;
	}

	public JTextField getTextField_subtotal() {
		return textField_subtotal;
	}

	public void setTextField_subtotal(JTextField textField_subtotal) {
		this.textField_subtotal = textField_subtotal;
	}
	
	public JLabel getNumItem() {
		return numItem;
	}

	public void setNumItem(JLabel numItem) {
		this.numItem = numItem;
	}

	public JLabel getBookId() {
		return bookId;
	}

	public void setBookId(JLabel bookId) {
		this.bookId = bookId;
	}

	public JLabel getBookQty() {
		return bookQty;
	}

	public void setBookQty(JLabel bookQty) {
		this.bookQty = bookQty;
	}

	public JLabel getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(JLabel itemInfo) {
		this.itemInfo = itemInfo;
	}

	public JLabel getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(JLabel subtotal) {
		this.subtotal = subtotal;
	}


}
