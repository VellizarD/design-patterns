package observer;

public class TopicSubscriber implements Observer {
	private Observable topic;
	private String name;

	public String getName() {
		return this.name;
	}

	public TopicSubscriber(String name) {
		this.name = name;
	}

	@Override
	public void Update() {
		String newTopic = this.topic.getUpdate();
		System.out.println(this.getName() + " received an update: " + newTopic);

	}

	@Override
	public void setTopic(Observable topic) {
		this.topic = topic;

	}

}
