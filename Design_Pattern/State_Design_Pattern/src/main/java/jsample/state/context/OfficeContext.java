package jsample.state.context;

import jsample.state.OfficeState;

public class OfficeContext {

	private OfficeState officeState;

	public OfficeState getOfficeState() {
		return officeState;
	}

	public void setOfficeState(OfficeState officeState) {
		this.officeState = officeState;
	}

	public void performAction() {
		officeState.performAction();
	}
}
