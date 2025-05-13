package Ecommerce;

public class Customer {
    int customerId;
    String customerName;

    public Customer(int cid, String cname) {
        customerId = cid;
        customerName = cname;
    }

    public void displayCustomerDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + customerName);
    }
}
