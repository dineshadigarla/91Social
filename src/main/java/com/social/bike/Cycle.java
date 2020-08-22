package com.social.bike;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.social.assembly.ChainAssembly;
import com.social.handlebar.HandleBarWithBrakes;
import com.social.price.CalculatePrice;
import com.social.seating.Seating;
import com.social.wheel.Wheel;

@Component
@Data
public class Cycle implements CalculatePrice {

	@Autowired
	private Wheel wheel;
	@Autowired
	private HandleBarWithBrakes handleBarWithBrakes;
	@Autowired
	private Seating seating;
	@Autowired
	private ChainAssembly chainAssembly;
	@Autowired
	private InteractionContext interactionContext;
	public double calculatePrice() {
		wheel.calculatePrice();
		seating.calculatePrice();
		chainAssembly.calculatePrice();
		handleBarWithBrakes.calculatePrice();
		double chainAssemblyPrice=interactionContext.getChainAssemblyPrice();
		double seatingPrice=interactionContext.getSeatingPrice();
		double wheelPrice=interactionContext.getWheelPrice();
		double handleBarWithBrakesPrice=interactionContext.getHandleBarWithBrakesPrice();
		double price= chainAssemblyPrice+seatingPrice+wheelPrice+handleBarWithBrakesPrice;
		interactionContext.setTotalPrice(price);
		return price;
	}
	
	
	 
}
