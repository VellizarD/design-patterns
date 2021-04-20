package mediator_singleton;

public interface MessageMediator {
	void sendMessage(User user, String message);

	void addUser(User user);

	void removeUser(User user);
}
