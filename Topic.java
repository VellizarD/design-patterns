package observer;

import java.util.ArrayList;
import java.util.List;

public class Topic implements Observable {
	public List<Observer> observers;
	public String topic;

	public Topic() {
		this.observers = new ArrayList<>();
	}

	@Override
	public void subscribe(Observer observer) {
		observers.add(observer);
		observer.setTopic(this);
	}

	@Override
	public void unsubscribe(Observer observer) {
		observers.remove(observer);

	}

	@Override
	public void notifyObservers() {
		for (Observer observer : this.observers) {
			observer.Update();
		}
	}

	@Override
	public String getUpdate() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
		this.notifyObservers();
	}

}
