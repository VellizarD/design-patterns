package Observer;

public class ProductChangeListener implements Observer {
	private Observable product;
	private String name;

	public ProductChangeListener(String name) {
		this.name = name;
	}

	@Override
	public void update() {
		System.out.println(this.name + ": The price " + ((Product) (this.product)).getName() + " has changed to "
				+ this.product.getUpdate());
	}

	@Override
	public void setObservable(Observable observable) {
		product = observable;
	}

}
