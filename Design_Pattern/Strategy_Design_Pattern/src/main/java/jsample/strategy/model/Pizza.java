package jsample.strategy.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

	private String baseType;

	private String pizzaName;

	private List<String> toppingList = new ArrayList<>();

	public Pizza(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public List<String> getToppingList() {
		return toppingList;
	}

	public void setToppingList(List<String> toppingList) {
		this.toppingList = toppingList;
	}
}