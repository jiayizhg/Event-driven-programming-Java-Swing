/* Name: Jiayi Zhang
 Course: CNT 4714 – Fall 2019
 Assignment title: Program 1 – Event-driven Programming
 Date: Sunday September 22, 2019
*/

package com.core;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.controller.MainController;
import com.model.Book;
import com.model.BookOrder;
import com.view.StoreFrame;

public class Estore {


	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				StoreFrame storeFrame = new StoreFrame();
				MainController controller = new MainController(storeFrame);
				controller.initController();
			}
		});
	}
}
