package com.social.wheel.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.social.bike.InteractionContext;
import com.social.wheel.Tube;

@Component
public class TubeImpl implements Tube {
	
	@Autowired
	private InteractionContext interactionContext;
	
	private double price;
	private boolean isTube;
	
	public boolean isTube() {
		return this.isTube;
	}

	public double getPrice() {

		return this.price;
	}

	public void setPrice(double price) {
		
		this.price=price;
	}

	public void setIsTube(boolean isTube) {
		interactionContext.setIsTube(isTube);
		this.isTube=isTube;
		
	}

}
