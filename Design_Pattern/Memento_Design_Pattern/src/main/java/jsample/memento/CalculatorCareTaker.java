package jsample.memento;

import java.util.HashMap;
import java.util.Map;

public class CalculatorCareTaker {

	private static final String IMAGE_PREFIX = "Image-";
	private Map<Integer, Object> stateMap = new HashMap<>();

	private Integer currentStateCount = 0;

	private CalculatorOriginator calculatorOriginator;

	public CalculatorCareTaker(CalculatorOriginator calculatorOriginator) {
		this.calculatorOriginator = calculatorOriginator;
	}

	public String save() {
		Object state = calculatorOriginator.save();
		stateMap.put(++currentStateCount, state);
		return IMAGE_PREFIX + currentStateCount;
	}

	public void restore(String state) {
		String stateCountStr = state.replace(IMAGE_PREFIX, "");
		Integer stateCountInt = Integer.valueOf(stateCountStr);
		Object obj = stateMap.get(stateCountInt);
		if (obj == null) {
			throw new IllegalArgumentException("Input state is not valid state");
		}
		calculatorOriginator.restore(obj);
	}

	public void restoreToLastSavedPoint() {
		if (currentStateCount == 0) {
			throw new UnsupportedOperationException("No last saved point exist");
		}
		Object obj = stateMap.get(currentStateCount);
		calculatorOriginator.restore(obj);
	}
}