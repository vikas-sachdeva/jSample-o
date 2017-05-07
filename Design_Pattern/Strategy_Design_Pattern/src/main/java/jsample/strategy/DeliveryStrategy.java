package jsample.strategy;

/**
 * Strategy design pattern is one of the behavioral design pattern.
 * 
 * Strategy pattern is used when there are multiple algorithm exist for a
 * specific task and client decides the actual implementation to be used at
 * runtime.
 * 
 * Strategy pattern is also known as Policy Pattern.
 * 
 * Multiple algorithms are defined and client application passes the algorithm
 * to be used as a parameter.
 * 
 * One of the best example of strategy pattern is Collections.sort() method that
 * takes Comparator parameter. Based on the different implementations of
 * Comparator interfaces, the Objects are getting sorted in different ways.
 * 
 * Strategy Pattern is very similar to State Pattern. One of the difference is
 * that in state pattern, Context contains state as instance variable and there
 * can be multiple tasks whose implementation can be dependent on the state
 * whereas in strategy pattern, strategy is passed as argument to the method and
 * context object doesn’t have any variable to store it. Another difference is
 * strategy pattern only handle a single, specific task, while state pattern
 * provide the underlying implementation for everything (or almost everything)
 * the context object does.
 *
 */

public interface DeliveryStrategy {

	public void deliver();

}
