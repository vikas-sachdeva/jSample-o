package jsample;

import jsample.command.Command;
import jsample.command.impl.TrainArriveCommand;
import jsample.command.impl.TrainDepartCommand;
import jsample.command.invoker.TrainMaster;
import jsample.command.receiver.Train;

/**
 * In command pattern, the request is send to the invoker and invoker pass it to
 * the encapsulated command object.
 * 
 * Command object passes the request to the appropriate method of Receiver to
 * perform the specific action.
 * 
 * The client program create the receiver object and then attach it to the
 * Command. Then it creates the invoker object and attach the command object to
 * perform an action.
 * 
 * Now when client program executes the action, it’s processed based on the
 * command and receiver object.
 *
 */
public class App {
	public static void main(String[] args) {
		Train train = new Train();

		Command command1 = new TrainArriveCommand(train);

		Command command2 = new TrainDepartCommand(train);

		TrainMaster master = new TrainMaster(command1);
		master.invokeCommand();

		master = new TrainMaster(command2);
		master.invokeCommand();

	}
}
