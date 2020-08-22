package com.social.wheel;

import com.social.price.CalculatePrice;

public interface Wheel extends CalculatePrice {
	public Spoke getSpoke();
	public Tube getTube();
	public Tyre getTyre();

}
