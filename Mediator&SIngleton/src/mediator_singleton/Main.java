package mediator_singleton;

public class Main {

	public static void main(String[] args) {
		var chat = new ChatRoom();

		var user1 = new ChatUser(chat, "user#1");
		var user2 = new ChatUser(chat, "user#2");
		var user3 = new ChatUser(chat, "user#3");
		var user4 = new ChatUser(chat, "user#4");
		var user5 = new ChatUser(chat, "user#5");

		user1.sendMessage("addBot");
		user1.sendMessage("cat ");
		user2.sendMessage("category");
		user2.sendMessage("concat");
		user2.sendMessage(" cat");
		user3.sendMessage("addBot");
		user3.sendMessage("?cat");
		user4.sendMessage("cat");
		user5.sendMessage("Hello?");
	}

}
