package jsample.command.invoker;

import jsample.command.Command;

public class TrainMaster {

	private Command command;

	public TrainMaster(Command command) {
		this.command = command;
	}

	public void invokeCommand() {
		System.out.println("Invoking train command");
		command.execute();
	}
}
