package jsample.visitor.impl;

import jsample.visitor.Item;
import jsample.visitor.Visitor;

public class Car implements Item {

	private int farePrice;

	private int discountPercentage;

	private boolean available;

	public int getFarePrice() {
		return farePrice;
	}

	public void setFarePrice(int farePrice) {
		this.farePrice = farePrice;
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public int accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
