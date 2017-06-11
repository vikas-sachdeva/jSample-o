package jsample.visitor.impl;

import jsample.visitor.Visitor;

public class TransportCostCalculator implements Visitor {

	@Override
	public int visit(Car car) {
		int cost = 0;
		if (car.isAvailable()) {
			if (car.getDiscountPercentage() != 0) {
				cost = car.getFarePrice() - car.getFarePrice() * car.getDiscountPercentage() / 100;
			} else {
				cost = car.getFarePrice();
			}
		}
		return cost;
	}

	@Override
	public int visit(Train train) {
		int cost = 0;
		if (train.isAvailable()) {
			cost = train.getFarePrice();
		}
		return cost;
	}
}
