package jsample.state;

/**
 * 
 * State design pattern is one of the behavioral design pattern.
 * 
 * State design pattern is used when an Object changes its behavior based on its
 * internal state.
 * 
 * If requirement is to change the behavior of an object based on its state, a
 * state variable can be declared in the Object. Then if-else condition block
 * can be used to perform different actions based on the state. However, later,
 * if any new state is introduced, it will require changes in existing if-else
 * condition block.
 * 
 * State design pattern is used to overcome this problem.
 * 
 * State design pattern is used to provide a systematic and loosely coupled way
 * to achieve this through Context and State implementations -
 * 
 * 1) Context - Context is the class that contains reference to one of the
 * concrete implementations of the State. Context forwards the request to the
 * state object for processing.
 * 
 * 2) State - State classes are defined for handling different states of the
 * object. There can be multiple state classes. One class correspond to one
 * state of the object.
 *
 */
public interface OfficeState {

	public void performAction();

}
