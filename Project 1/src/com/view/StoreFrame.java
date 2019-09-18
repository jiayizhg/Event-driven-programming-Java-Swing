/* Name: Jiayi Zhang
 Course: CNT 4714 – Fall 2019
 Assignment title: Program 1 – Event-driven Programming
 Date: Sunday September 22, 2019
*/

package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.controller.*;

public class StoreFrame extends JFrame {

	private StoreToolBar toolBar; 
	private StoreOrderInfoPanel panel;

	public StoreFrame() {
		
		toolBar = new StoreToolBar();
		panel = new StoreOrderInfoPanel();

		getContentPane().add(toolBar);
		getContentPane().add(panel);
		
		setBounds(350, 150, 830, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
	}
	
	public StoreToolBar getToolBar() {
		return toolBar;
	}

	public StoreOrderInfoPanel getPanel() {
		return panel;
	}

}
