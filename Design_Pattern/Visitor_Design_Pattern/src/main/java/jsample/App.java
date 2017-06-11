package jsample;

import jsample.visitor.impl.Car;
import jsample.visitor.impl.Train;
import jsample.visitor.impl.TransportCostCalculator;

public class App {
	public static void main(String[] args) {

		Car car = new Car();
		car.setAvailable(true);
		car.setDiscountPercentage(20);
		car.setFarePrice(100);

		Train train = new Train();
		train.setAvailable(true);
		train.setFarePrice(55);

		TransportCostCalculator transportCostCalculator = new TransportCostCalculator();
		int carFare = transportCostCalculator.visit(car);
		int trainFare = transportCostCalculator.visit(train);

		if (carFare == 0 && trainFare == 0) {
			System.out.println("No transport mode is available");
		} else if (carFare == 0) {
			System.out.println("Only train is available");
		} else if (trainFare == 0) {
			System.out.println("Only car is available");
		} else if (carFare > trainFare) {
			System.out.println("Travelling through train is cheaper");
		} else if (carFare < trainFare) {
			System.out.println("Travelling through car is cheaper");
		} else {
			System.out.println("Travelling through car and train cost same amount");
		}
	}
}
