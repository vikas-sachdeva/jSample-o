package jsample.state.impl;

import jsample.state.OfficeState;

public class OpenOfficeState implements OfficeState {

	@Override
	public void performAction() {
		System.out.println("Office is open. On electricity and water.");
	}
}
