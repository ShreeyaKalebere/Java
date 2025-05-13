import Ecommerce.Customer;
import Ecommerce.Order;
import Ecommerce.Product;


public class Main {
    public static void main(String[] args) {
        Product p = new Product(101, "Mobile", 18000);
        Customer c = new Customer(201, "Shubham");
        Order o = new Order(p, c, 2);

        o.placeOrder();
    }
}
