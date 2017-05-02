package jsample.mediator;

/**
 * Mediator design pattern is one of the behavioral design pattern, so it deals
 * with the behaviors of objects.
 * 
 * Mediator design pattern is used to handle complex communications between
 * related objects, helping with decoupling of those objects.
 * 
 * The system objects that communicate each other are called Colleagues.
 * 
 */
public interface Mediator {

	public void sendNotification(String message, User user);

	public void addFollower(User user, User follower);

}
