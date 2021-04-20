package mediator_singleton;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements MessageMediator {
	private List<User> users;

	public ChatRoom() {
		users = new ArrayList<User>();
	}

	@Override
	public void sendMessage(User sender, String message) {
		if (!users.contains(sender))
			return;
		System.out.println("\n" + sender.username + " sent: " + message);
		ChatBot botInstance = null;
		for (var chatUser : this.users) {
			if (chatUser != sender) {
				if (chatUser instanceof ChatBot) {
					botInstance = (ChatBot) chatUser;
					continue;
				}
				chatUser.receiveMessage(sender, message);
			}
		}
		if (botInstance != null)
			botInstance.receiveMessage(sender, message);

		if (message == "addBot") {
			if (botInstance == null) {
				var bot = ChatBot.getInstance();
				bot.setMediator(this);
				addUser(bot);
			}
		}
	}

	@Override
	public void addUser(User user) {
		this.users.add(user);
		if (user instanceof ChatBot)
			System.out.println(ChatBot.username + " has joined the ChatRoom.");
		else
			System.out.println(user.username + " has joined the ChatRoom.");
	}

	@Override
	public void removeUser(User user) {
		this.users.remove(user);
		System.out.println(
				"\n---->[" + user.username + "] has been removed from the ChatRoom for violating a rule.<----\n");
	}
}
