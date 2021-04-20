package mediator_singleton;

public abstract class User {
	protected String username;
	protected MessageMediator mediator;

	protected abstract void sendMessage(String message);

	protected abstract void receiveMessage(User user, String message);
}
