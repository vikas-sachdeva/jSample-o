package jsample.command.impl;

import jsample.command.Command;
import jsample.command.receiver.Train;

public class TrainDepartCommand implements Command {

	private Train train;

	public TrainDepartCommand(Train train) {
		this.train = train;
	}

	@Override
	public void execute() {
		System.out.println("Train Departed");
		train.depart();
	}
}
