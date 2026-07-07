package classobjectassignment;

public class onlineshopingcart {

	// Small demo runner to show ShoppingCart usage
	public static void main(String[] args) {
		ShoppingCart cart1 = new ShoppingCart("Laptop", 35000.0, 1);
		ShoppingCart cart2 = new ShoppingCart("Headphones", 1800.0, 2);
		ShoppingCart cart3 = new ShoppingCart("Book", 450.0, 3);

		System.out.println(cart1);
		System.out.println(cart2);
		System.out.println(cart3);
	}

}

// ShoppingCart class holds product details and computes total cost
class ShoppingCart {
	private String productName;
	private double price;
	private int quantity;

	public ShoppingCart(String productName, double price, int quantity) {
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	// Getters
	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	// Returns subtotal (price * quantity)
	public double getSubtotal() {
		return price * quantity;
	}

	// Returns total cost after applying discount if applicable.
	// If subtotal > 5000, apply 10% discount.
	public double getTotalCost() {
		double subtotal = getSubtotal(); // use getters internally
		if (subtotal > 5000.0) {
			return subtotal * 0.90; // 10% discount
		}
		return subtotal;
	}

	@Override
	public String toString() {
		return String.format("Product: %s, Price: %.2f, Quantity: %d, Subtotal: %.2f, Total(after discount if any): %.2f",
				getProductName(), getPrice(), getQuantity(), getSubtotal(), getTotalCost());
	}
}
