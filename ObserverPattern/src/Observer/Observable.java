package Observer;

public interface Observable {
	void attatch(Observer observer);

	void detatch(Observer observer);

	void Notify();

	Object getUpdate();
}
