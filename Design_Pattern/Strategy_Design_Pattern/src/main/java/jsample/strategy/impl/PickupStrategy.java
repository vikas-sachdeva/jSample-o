package jsample.strategy.impl;

import jsample.strategy.DeliveryStrategy;

public class PickupStrategy implements DeliveryStrategy {

	private int counterNo;

	public PickupStrategy(int counterNo) {
		this.counterNo = counterNo;
	}

	@Override
	public void deliver() {
		System.out.println("Pick pizaa order at counter number = " + counterNo);
	}
}
