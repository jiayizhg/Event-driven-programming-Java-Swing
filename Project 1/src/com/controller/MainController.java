/* Name: Jiayi Zhang
 Course: CNT 4714 – Fall 2019
 Assignment title: Program 1 – Event-driven Programming
 Date: Sunday September 22, 2019
*/

package com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.model.Book;
import com.model.BookOrder;
import com.view.StoreFrame;
import com.view.StoreOrderInfoPanel;
import com.view.StoreToolBar;

public class MainController {

	private StoreFrame storeFrame;
	private List<Book> books;
	private StoreOrderInfoPanel infoPanel;
	private StoreToolBar toolBar;
	
	private InventoryController inventoryController;
	private ButtonController buttonController;
	
	public MainController(StoreFrame storeFrame) {
		super();
		this.storeFrame = storeFrame;
		this.infoPanel = storeFrame.getPanel();
		this.toolBar = storeFrame.getToolBar();
		this.books = new ArrayList<>();
	}	
	
	public void initController() {
		
		inventoryController = new InventoryController(books);
		inventoryController.InitInventoryController();
		
//		storeFrame.getToolBar().getProcessItemBtn().setEnabled(false);
		
//		for (Book book : books) {
//			System.out.println(book.getBookId());
//		}
	
		buttonController = new ButtonController(books, storeFrame);
		buttonController.InitButtonController();
	}
}
