package jsample.mediator;

public interface User {
	
	public void setName(String name);
	
	public String getName();

	public void postMessage(String message);
	
	public void setMediator(Mediator mediator);
	
	public void receiveNotification(String message);

}
