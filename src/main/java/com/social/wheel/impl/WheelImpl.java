package com.social.wheel.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.social.bike.InteractionContext;
import com.social.wheel.Spoke;
import com.social.wheel.Tube;
import com.social.wheel.Tyre;
import com.social.wheel.Wheel;

import lombok.Getter;

@Component
@Getter
public class WheelImpl implements Wheel {
	
	@Autowired
	private Spoke spoke;
	
	@Autowired
	private Tube tube;
	
	@Autowired
	private Tyre tyre;
	
	@Autowired
	private InteractionContext interactionContext;


	public double calculatePrice() {
		double price= spoke.getPrice()+(interactionContext.getIsTube()?tube.getPrice():0)+tyre.getPrice();
		interactionContext.setWheelPrice(price);
		return price;
	}

}
