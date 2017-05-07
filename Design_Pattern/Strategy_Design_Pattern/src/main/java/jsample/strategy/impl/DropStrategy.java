package jsample.strategy.impl;

import jsample.strategy.DeliveryStrategy;

public class DropStrategy implements DeliveryStrategy {

	private int houseNo;

	private String streetName;

	private String city;

	public DropStrategy(int houseNo, String streetName, String city) {
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.city = city;
	}

	@Override
	public void deliver() {
		System.out
				.println("Delivery pizaa order at houseNo = " + houseNo + ", streetName = " + streetName + ", city = " + city);
	}
}
