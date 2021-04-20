package mediator_singleton;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ChatBot extends User {
	public static String username = "chatBot";
	private static MessageMediator mediator;
	private static ChatBot instance = new ChatBot();

	public static ChatBot getInstance() {
		synchronized (ChatBot.class) {
			if (instance == null)
				instance = new ChatBot();
			return instance;
		}
	}

	public void setMediator(MessageMediator mediator) {
		ChatBot.mediator = mediator;
	}

	public void sendMessage(String message) {
		System.out.println(ChatBot.username + " sent: " + message);
		ChatBot.mediator.sendMessage(this, message);
	}

	public void receiveMessage(User sender, String message) {
		Pattern pattern = Pattern.compile("([\\W]{1}cat[\\W]?)|(^cat[\\W]+)|(^cat$)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(message);
		if (matcher.lookingAt()) {
			ChatBot.mediator.removeUser(sender);
		}
	}
}
