package jsample.memento;

/**
 * 
 * Memento design pattern is one of the behavioral design pattern.
 * 
 * Memento design pattern is used when requirement is to save the state of an
 * object so that it can be restored later i.e. for providing undo or restore
 * functionality.
 * 
 * Memento pattern is used to implement this in such a way that the saved state
 * data of the object is not accessible outside of the object, this protects the
 * integrity of saved state data.
 * 
 * There are 3 participants in this design pattern -
 * 
 * 1) Originator - Originator is the object whose state needs to be saved and
 * restored. It uses Memento object for saving and restoring its internal state.
 * 
 * 2) Memento - Stores internal state of the Originator object. The state can
 * include any number of state variables. The Memento must have two interfaces -
 * one is for CareTaker and one is for Originator. CareTaker interface must not
 * allow any operations or any access to internal state stored by the Memento
 * and thus honors encapsulation. The Originator interface allows the Originator
 * to access any state variables necessary for the Originator to restore its
 * previous state.
 * 
 * 3) CareTaker - CareTaker is the helper class that is responsible for storing
 * and restoring the Originator’s state through Memento object. It is
 * responsible for keeping the Memento objects. The Memento is opaque to the
 * CareTaker, and the CareTaker must not operate on it.
 * 
 *
 */
public class CalculatorOriginator {

	private int firstNumber;

	private int secondNumber;

	private int total;

	public int getTotal() {
		total = firstNumber + secondNumber;
		return total;
	}

	public int getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}

	public int getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}

	public CalculatorMemento save() {
		return new CalculatorMemento(firstNumber, secondNumber);
	}

	public void restore(Object obj) {
		CalculatorMemento calculatorMemento = (CalculatorMemento) obj;
		this.firstNumber = calculatorMemento.getFirstNumber();
		this.secondNumber = calculatorMemento.getSecondNumber();
	}

	private class CalculatorMemento {

		private int firstNumber;

		private int secondNumber;

		public CalculatorMemento(int firstNumber, int secondNumber) {
			this.firstNumber = firstNumber;
			this.secondNumber = secondNumber;
		}

		public int getFirstNumber() {
			return firstNumber;
		}

		public int getSecondNumber() {
			return secondNumber;
		}
	}
}