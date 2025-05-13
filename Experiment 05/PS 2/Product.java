package Ecommerce;

public class Product{
    int id;
    String name;
    double price;

    public Product(int pid, String pname, double pprice){
        id = pid;
        name = pname;
        price = pprice;
    }

    public void displayProductDetails() {
        System.out.println("Product ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: Rs." + price);
    }
}