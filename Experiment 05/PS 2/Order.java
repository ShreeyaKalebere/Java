package Ecommerce;

public class Order {
    Product product;
    Customer customer;
    int quantity;

    public Order(Product p, Customer c, int q) {
        product = p;
        customer = c;
        quantity = q;
    }

    public void placeOrder() {
        System.out.println("Order Placed:");
        customer.displayCustomerDetails();
        product.displayProductDetails();
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: Rs." + calculateTotalCost());
    }

    public double calculateTotalCost() {
        return product.price * quantity;
    }
}
