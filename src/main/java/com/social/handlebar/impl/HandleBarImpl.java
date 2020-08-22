package com.social.handlebar.impl;

import org.springframework.stereotype.Component;

import com.social.handlebar.HandleBar;

@Component
public class HandleBarImpl implements HandleBar {

	private double price;

	public double getPrice() {

		return price;
	}

	public void setPrice(double price) {
		
		this.price=price;		
	}
}
