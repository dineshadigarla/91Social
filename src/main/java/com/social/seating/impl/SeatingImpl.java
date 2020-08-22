package com.social.seating.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.social.bike.InteractionContext;
import com.social.seating.Leather;
import com.social.seating.Seating;

import lombok.Getter;

@Component
@Getter
public class SeatingImpl implements Seating  {

	@Autowired
	private Leather leather;
	
	@Autowired
	private InteractionContext interactionContext;

	public double calculatePrice() {
		boolean isLeather=interactionContext.getIsLeather()?true:false;
		interactionContext.setSeatingPrice(isLeather?leather.getPrice():0);
		return leather.getPrice();
	}	

}
