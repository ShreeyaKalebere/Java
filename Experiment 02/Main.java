class StaticDemo {
    // Static variable
    static int count;
    
    // Static block
    static {
        System.out.println("Static block executed!");
        count = 100;
    }
    
    // Static method
    static void displayCount() {
        System.out.println("Count: " + count);
    }
    
    // Instance method
    void incrementCount() {
        count++;
    }
}

public class Main {
    public static void main(String[] args) {
        StaticDemo.displayCount();
        
        StaticDemo obj1 = new StaticDemo();
        StaticDemo obj2 = new StaticDemo();
        
        obj1.incrementCount();
        obj2.incrementCount();
        
        StaticDemo.displayCount();
    }
}
