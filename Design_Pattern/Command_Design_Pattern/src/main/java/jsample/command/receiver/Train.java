package jsample.command.receiver;

public class Train {

	private String state;

	public void arrive() {
		state = "arrive";
	}

	public void depart() {
		state = "depart";
	}

	public String getState() {
		return state;
	}
}
