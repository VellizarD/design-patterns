package mediator_singleton;

public class ChatUser extends User {
	public ChatUser(MessageMediator mediator, String name) {
		this.username = name;
		this.mediator = mediator;
		mediator.addUser(this);
	}

	@Override
	public void sendMessage(String message) {
		this.mediator.sendMessage(this, message);
	}

	@Override
	public void receiveMessage(User sender, String message) {
		System.out.println(this.username + " received: " + message + " from [" + sender.username + "].");
	}

}
