package com.social.assembly.impl;

import org.springframework.stereotype.Component;

import com.social.assembly.Spocket;

@Component
public class SpocketImpl implements Spocket {

	private double price;

	public double getPrice() {
		
		return price;
	}

	public void setPrice(double price) {
		
		this.price=price;
	}

	
}
