package Observer;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		var product = new Product("tomato", "0000001", 5.20);
		var observers = List.of(new ProductChangeListener("Listener#1"), new ProductChangeListener("Listener#2"),
				new ProductChangeListener("Listener#3"), new ProductChangeListener("Listener#4"));

		observers.forEach(x -> product.attatch(x));
		product.setPrice(10d);

	}

}
