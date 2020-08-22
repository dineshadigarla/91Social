package com.social.handlebar.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.social.bike.InteractionContext;
import com.social.handlebar.Brakes;
import com.social.handlebar.HandleBar;
import com.social.handlebar.HandleBarWithBrakes;

import lombok.Getter;

@Component
@Getter
public class HandleBarWithBrakesImpl implements HandleBarWithBrakes {
	
	@Autowired
	private Brakes brakes;
	
	@Autowired
	private InteractionContext interactionContext;
	
	@Autowired
	private HandleBar handleBar;

	public double calculatePrice() {
		double price=brakes.getPrice()+handleBar.getPrice();
		interactionContext.setHandleBarWithBrakesPrice(price);
		return price;
	}	
	
	
	

}
