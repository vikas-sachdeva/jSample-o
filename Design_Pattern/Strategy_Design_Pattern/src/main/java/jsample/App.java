package jsample;


import jsample.strategy.context.PizzaOrderCartContext;
import jsample.strategy.impl.DropStrategy;
import jsample.strategy.impl.PickupStrategy;
import jsample.strategy.model.Pizza;

public class App {
	public static void main(String[] args) {

		Pizza pizza1 = new Pizza("Quattro Premium");
		pizza1.setBaseType("Hand-Tossed");
		pizza1.getToppingList().add("Cheese");
		pizza1.getToppingList().add("Olive");

		Pizza pizza2 = new Pizza("Spicy Deluxe");
		pizza2.setBaseType("Mille-Feuille");
		pizza2.getToppingList().add("Cherry Tomato");

		PizzaOrderCartContext pizzaOrderCartContext = new PizzaOrderCartContext();
		pizzaOrderCartContext.addPizaa(pizza1);
		pizzaOrderCartContext.addPizaa(pizza2);

		pizzaOrderCartContext.deliver(new PickupStrategy(2));

		pizzaOrderCartContext.deliver(new DropStrategy(23, "2777 S. Crystal Drive", "Arlington"));
	}
}
