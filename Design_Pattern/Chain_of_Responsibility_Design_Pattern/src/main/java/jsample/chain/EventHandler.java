package jsample.chain;

/**
 * Chain of responsibility design pattern is one of the behavioral design
 * pattern.
 */

/**
 * Chain of responsibility pattern is used to achieve loose coupling in software
 * design where a request from client is passed to a chain of objects to process
 * them. Then the object in the chain will decide whether it needs to process
 * the request or not and whether the request should be sent to the next object
 * in the chain or not.
 *
 */
public interface EventHandler {

	public void setNextEventHandler(EventHandler nextEventHandler);

	public void handle();

}
