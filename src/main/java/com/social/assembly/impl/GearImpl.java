package com.social.assembly.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.social.assembly.Gear;
import com.social.bike.InteractionContext;

@Component
public class GearImpl implements Gear {
	
	@Autowired
	private InteractionContext interactionContext;

	private double price;
	private boolean isGear;

	public double getPrice() {
		
		return price;
	}

	public void setPrice(double price) {
		
		this.price=price;
	}
	
	public boolean isGear() {
		return this.isGear;
	}
	
	public void setIsGear(boolean isGear) {
		interactionContext.setIsGear(isGear);
		this.isGear=isGear;
	}
	
	

}
