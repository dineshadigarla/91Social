package com.social.assembly.impl;

import org.springframework.stereotype.Component;

import com.social.assembly.Chain;

@Component
public class ChainImpl implements Chain{

	private double price;

	public double getPrice() {

		return this.price;
	}

	public void setPrice(double price) {
		
		this.price=price;
	}

}
