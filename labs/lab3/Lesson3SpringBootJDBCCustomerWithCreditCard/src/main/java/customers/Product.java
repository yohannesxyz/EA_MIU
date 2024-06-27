package customers;

public class Product {
	private int productNumber;
	private String productName;
	private double price;
	private Supplier supplier;

	public Product(int productnumber, String productName, double price){
		this.productNumber=productnumber;
		this.productName=productName;
		this.price=price;

	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductnumber() {
		return productNumber;
	}
	public void setProductnumber(int productnumber) {
		this.productNumber = productnumber;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "Product{" +
				"productNumber=" + productNumber +
				", productName='" + productName + '\'' +
				", price=" + price +
				", supplier=" + supplier +
				'}';
	}
}
