package jsample.command;

/**
 * Command Pattern is one of the Behavioral Design Pattern.
 * 
 * Command design pattern is used to implement loose coupling in a
 * request-response model.
 * 
 * The Command design pattern can be used for doing smart things instead of just
 * delegating request to Receiver, e.g. it can be used to record and queue up
 * the request for processing, can perform undo operations and can perform
 * pre-processing operation e.g. logging request for auditing etc.
 * 
 */
public interface Command {

	public void execute();

}
