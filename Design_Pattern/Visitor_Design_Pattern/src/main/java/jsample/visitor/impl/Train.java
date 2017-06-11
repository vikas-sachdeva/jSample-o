package jsample.visitor.impl;

import jsample.visitor.Item;
import jsample.visitor.Visitor;

public class Train implements Item {

	private int farePrice;

	private boolean available;

	public int getFarePrice() {
		return farePrice;
	}

	public void setFarePrice(int farePrice) {
		this.farePrice = farePrice;
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
