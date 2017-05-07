package jsample;

import jsample.state.OfficeState;
import jsample.state.context.OfficeContext;
import jsample.state.impl.ClosedOfficeState;
import jsample.state.impl.OpenOfficeState;

public class App {
	public static void main(String[] args) {

		OfficeState openOfficeState = new OpenOfficeState();

		OfficeState closedOfficeState = new ClosedOfficeState();

		OfficeContext officeContext = new OfficeContext();
		officeContext.setOfficeState(openOfficeState);

		officeContext.performAction();

		officeContext.setOfficeState(closedOfficeState);
		officeContext.performAction();

	}
}
