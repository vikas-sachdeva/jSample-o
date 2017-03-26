package jsample.chain;

/**
 * Chain of responsibility design pattern is one of the behavioral design
 * pattern.
 */

public interface EventHandler {

	public void setNextEventHandler(EventHandler nextEventHandler);

	public void handle();

}
