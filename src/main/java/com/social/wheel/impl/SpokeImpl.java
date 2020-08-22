package com.social.wheel.impl;

import org.springframework.stereotype.Component;

import com.social.wheel.Spoke;

@Component
public class SpokeImpl implements Spoke {

	private double price;

	public double getPrice() {

		return this.price;
	}

	public void setPrice(double price) {
		
		this.price=price;
	}
	
	

}
