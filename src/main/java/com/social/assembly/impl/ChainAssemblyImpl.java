package com.social.assembly.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.social.assembly.Chain;
import com.social.assembly.ChainAssembly;
import com.social.assembly.Gear;
import com.social.assembly.Pedal;
import com.social.assembly.Spocket;
import com.social.bike.InteractionContext;

import lombok.Getter;

@Component
@Getter
public class ChainAssemblyImpl implements ChainAssembly {

	@Autowired
	private Chain chain;
	
	@Autowired
	private Pedal pedal;
	
	@Autowired
	private Spocket spocket;
	
	@Autowired
	private InteractionContext interactionContext;
	
	@Autowired
	private Gear gear;

	public double calculatePrice() {
		
		double price= chain.getPrice()+pedal.getPrice()+spocket.getPrice()+(interactionContext.getIsGear()?gear.getPrice():0) ;
		interactionContext.setChainAssemblyPrice(price);
		return price;
	}

}
