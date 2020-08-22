package com.social.seating.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.social.bike.InteractionContext;
import com.social.seating.Leather;

@Component
public class LeatherImpl implements Leather {
	
	@Autowired
	private InteractionContext interactionContext;

	private double price;
	private boolean isLeather;
	public double getPrice() {
		
		return price;
	}

	public void setIsLeather(boolean isLeather) {

		interactionContext.setIsLeather(isLeather);
		this.isLeather= isLeather;
	}
	
	public boolean isLeather() {

		
		return isLeather?true:false;
	}

	public void setPrice(double price) {
		
		this.price=price;
	}

	
}
