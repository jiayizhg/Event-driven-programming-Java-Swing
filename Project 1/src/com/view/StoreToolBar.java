/* Name: Jiayi Zhang
 Course: CNT 4714 – Fall 2019
 Assignment title: Program 1 – Event-driven Programming
 Date: Sunday September 22, 2019
*/

package com.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.controller.ButtonController;

public class StoreToolBar extends JPanel {

	private JButton processItemBtn;
	private JButton confirmItemBtn;
	private JButton viewOrderBtn;
	private JButton finishOrderBtn;
	private JButton newOrderBtn;
	private JButton exitBtn;
	
	public StoreToolBar() {
			
		processItemBtn = new JButton("Process Item #1");
		
		confirmItemBtn = new JButton("Confirm Item #1");
		confirmItemBtn.setEnabled(false);
		
		viewOrderBtn = new JButton("View Order");
		viewOrderBtn.setEnabled(false);
		
		finishOrderBtn = new JButton("Finish Order");
		finishOrderBtn.setEnabled(false);
		
		newOrderBtn = new JButton("New Order");
		newOrderBtn.setEnabled(true);
		
		exitBtn  = new JButton("Exit");
		exitBtn.setEnabled(true);
		
		setBounds(0, 189, 830, 40);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(Color.decode("#A9DDD9"));
		
		add(processItemBtn);
		add(confirmItemBtn);
		add(viewOrderBtn);
		add(finishOrderBtn);
		add(newOrderBtn);
		add(exitBtn);
	}	
	
	public JButton getProcessItemBtn() {
		return processItemBtn;
	}

	public void setProcessItemBtn(JButton processItemBtn) {
		this.processItemBtn = processItemBtn;
	}

	public JButton getConfirmItemBtn() {
		return confirmItemBtn;
	}

	public void setConfirmItemBtn(JButton confirmItemBtn) {
		this.confirmItemBtn = confirmItemBtn;
	}

	public JButton getViewOrderBtn() {
		return viewOrderBtn;
	}

	public void setViewOrderBtn(JButton viewOrderBtn) {
		this.viewOrderBtn = viewOrderBtn;
	}

	public JButton getFinishOrderBtn() {
		return finishOrderBtn;
	}

	public void setFinishOrderBtn(JButton finishOrderBtn) {
		this.finishOrderBtn = finishOrderBtn;
	}

	public JButton getNewOrderBtn() {
		return newOrderBtn;
	}

	public void setNewOrderBtn(JButton newOrderBtn) {
		this.newOrderBtn = newOrderBtn;
	}

	public JButton getExitBtn() {
		return exitBtn;
	}

	public void setExitBtn(JButton exitBtn) {
		this.exitBtn = exitBtn;
	}
}
