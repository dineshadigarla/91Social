package com.social.wheel.impl;

import org.springframework.stereotype.Component;

import com.social.wheel.Tyre;

@Component
public class TyreImpl implements Tyre {
	
	private double price;

	public double getPrice() {
		
		return this.price;
	}

	public void setPrice(double price) {
		
		this.price=price;
	}

}
