package com.social.bike;

import org.springframework.stereotype.Component;


@Component
public class InteractionContext {

	private ThreadLocal<Integer> counterId=new ThreadLocal<>();
	private ThreadLocal<String> cycleName=new ThreadLocal<>();
	private ThreadLocal<Boolean> isLeather= new ThreadLocal<>();
	private ThreadLocal<Boolean> isGear= new ThreadLocal<>();
	private ThreadLocal<Boolean> isTube=new ThreadLocal<>();
	
	private ThreadLocal<Double> wheelPrice=new ThreadLocal<>();
	private ThreadLocal<Double> chainAssemblyPrice=new ThreadLocal<>();
	private ThreadLocal<Double> handleBarWithBrakesPrice=new ThreadLocal<>();
	private ThreadLocal<Double> seatingPrice=new ThreadLocal<>();
	private ThreadLocal<Double> totalPrice=new ThreadLocal<>();

	
	public Integer getCounterId() {
		if(counterId.get()==null) {
			return 0;
		}
		return counterId.get();
	}
	
	public void setCounterId(Integer counterId) {
		this.counterId.set(counterId);
	}
	
	public String getCycleName() {
		if(cycleName.get()==null) {
			return "";
		}
		return cycleName.get();
	}
	
	public void setCycleName(String cycleName) {
		this.cycleName.set(cycleName);
	}
	
	public Boolean getIsLeather() {
		if(isLeather.get()==null) {
			return false;
		}
		return isLeather.get();
	}
	public void setIsLeather(Boolean isLeather) {
		this.isLeather.set(isLeather);
	}
	
	public void setIsGear(Boolean isGear) {
		this.isGear.set(isGear);
	}
	
	public Boolean getIsGear() {
		if(isGear.get()==null) {
			return false;
		}
		return isGear.get();
	}
	public void setIsTube(Boolean isTube) {
		this.isTube.set(isTube);
	}
	
	public Boolean getIsTube() {
		if(isTube.get()==null)
			return false;
		return isTube.get();
	}
	public void setWheelPrice(Double wheelPrice) {
		this.wheelPrice.set(wheelPrice);
	}
	public Double getWheelPrice() {
		if(wheelPrice.get()==null)
			return 0.0;
		return wheelPrice.get();
	}
	
	public void setChainAssemblyPrice(Double chainAssemblyPrice) {
		this.chainAssemblyPrice.set(chainAssemblyPrice);
	}
	public Double getChainAssemblyPrice() {
		if(chainAssemblyPrice.get()==null)
			return 0.0;
		return chainAssemblyPrice.get();
	}
	
	public void setHandleBarWithBrakesPrice(Double handleBarWithBrakesPrice) {
		this.handleBarWithBrakesPrice.set(handleBarWithBrakesPrice);
	}
	public Double getHandleBarWithBrakesPrice() {
		if(handleBarWithBrakesPrice.get()==null)
			return 0.0;
		return handleBarWithBrakesPrice.get();
	}
	
	public void setSeatingPrice(Double seatingPrice) {
		this.seatingPrice.set(seatingPrice);
	}
	public Double getSeatingPrice() {
		if(seatingPrice.get()==null)
			return 0.0;
		return seatingPrice.get();
	}
	
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice.set(totalPrice);
	}
	public Double getTotalPrice() {
		if(totalPrice.get()==null)
			return 0.0;
		return totalPrice.get();
	}
	
	
	public void reset() {
		counterId.remove();
		cycleName.remove();
		isLeather.remove();
		isGear.remove();
		isTube.remove();
		wheelPrice.remove();
		chainAssemblyPrice.remove();
		handleBarWithBrakesPrice.remove();
		seatingPrice.remove();
		totalPrice.remove();
	}
}
