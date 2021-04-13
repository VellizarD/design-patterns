package Observer;

import java.util.ArrayList;
import java.util.List;

public class Product implements Observable {
	private String name;
	private String productNumber;
	private double price;
	public List<Observer> observers;

	public Product(String name, String productNumber, double price) {
		this.observers = new ArrayList<Observer>();
		this.price = price;
		this.name = name;
		this.productNumber = productNumber;
	}

	@Override
	public void attatch(Observer observer) {
		observers.add(observer);
		observer.setObservable(this);

	}

	@Override
	public void detatch(Observer observer) {
		observers.remove(observer);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
		this.Notify();
	}

	@Override
	public void Notify() {
		observers.forEach(x -> x.update());
	}

	@Override
	public Object getUpdate() {
		return this.price;
	};
}
