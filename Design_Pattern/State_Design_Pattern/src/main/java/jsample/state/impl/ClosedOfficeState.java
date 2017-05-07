package jsample.state.impl;

import jsample.state.OfficeState;

public class ClosedOfficeState implements OfficeState {

	@Override
	public void performAction() {
		System.out.println("Office is closed. Off electricity and water.");
	}
}
