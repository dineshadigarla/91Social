package com.social.handlebar.impl;

import org.springframework.stereotype.Component;

import com.social.handlebar.Brakes;

@Component
public class BrakesImpl implements Brakes {

	private double price;
	
	public double getPrice() {
		
		return price;
	}

	public void setPrice(double price) {
		
		this.price=price;
	}

}
