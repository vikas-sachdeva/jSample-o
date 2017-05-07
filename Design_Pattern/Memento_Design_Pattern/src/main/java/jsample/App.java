package jsample;

import jsample.memento.CalculatorCareTaker;
import jsample.memento.CalculatorOriginator;

public class App {
	public static void main(String[] args) {

		CalculatorOriginator calculatorOriginator = new CalculatorOriginator();
		calculatorOriginator.setFirstNumber(123);
		calculatorOriginator.setSecondNumber(432);
		System.out.println(calculatorOriginator.getTotal());

		CalculatorCareTaker calculatorCareTaker = new CalculatorCareTaker(calculatorOriginator);
		String firstSavedState = calculatorCareTaker.save();

		calculatorOriginator.setSecondNumber(115);
		System.out.println(calculatorOriginator.getTotal());

		String secondSavedState = calculatorCareTaker.save();

		calculatorCareTaker.restore(firstSavedState);
		System.out.println(calculatorOriginator.getTotal());

		calculatorCareTaker.restore(secondSavedState);
		System.out.println(calculatorOriginator.getTotal());

		calculatorCareTaker.restoreToLastSavedPoint();
		System.out.println(calculatorOriginator.getTotal());

	}
}
