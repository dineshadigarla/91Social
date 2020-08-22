package com.social.assembly;

import com.social.price.CalculatePrice;

public interface ChainAssembly extends CalculatePrice {

	public Chain getChain();
	public Pedal getPedal();
	public Spocket getSpocket();
	public Gear getGear();
}
