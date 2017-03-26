package jsample.command.impl;

import jsample.command.Command;
import jsample.command.receiver.Train;

public class TrainArriveCommand implements Command {
	
	private Train train;
	
	public TrainArriveCommand(Train train) {
		this.train = train;
	}

	@Override
	public void execute() {
		System.out.println("Train Arrived");
		train.arrive();
	}
}
