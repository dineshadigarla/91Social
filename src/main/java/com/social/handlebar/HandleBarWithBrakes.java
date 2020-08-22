package com.social.handlebar;

import com.social.price.CalculatePrice;

public interface HandleBarWithBrakes extends CalculatePrice {
	
	public Brakes getBrakes();
	public HandleBar getHandleBar();
}
