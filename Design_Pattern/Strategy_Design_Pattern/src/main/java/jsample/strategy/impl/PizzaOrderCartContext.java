package jsample.strategy.impl;

import java.util.ArrayList;
import java.util.List;

import jsample.strategy.DeliveryStrategy;
import jsample.strategy.model.Pizza;

public class PizzaOrderCartContext {

	private List<Pizza> pizzaList = new ArrayList<>();

	public void addPizaa(Pizza pizza) {
		pizzaList.add(pizza);
	}

	public List<Pizza> getPizzaList() {
		return pizzaList;
	}

	public void deliver(DeliveryStrategy deliveryStrategy) {
		deliveryStrategy.deliver();
	}

}
