interface Shape{
    double area();
}

class Rectangle implements Shape{
    double width;
    double height;

    Rectangle(double w, double h){
        width = w;
        height = h;
    }

    public double area(){
        return width*height;
    }
}

class Triangle implements Shape{
    double base;
    double height;

    Triangle(double b, double h){
        base = b;
        height = h;
    }

    public double area(){
        return 0.5*base*height;
    }
}

public class ShapeInterface{
    public static void main(String[] args){
        Rectangle r = new Rectangle(5,10);
        Triangle t = new Triangle(10,20);

        System.out.println("Rectangle Area: " + r.area());
        System.out.println("Triangle Area: " + t.area());
    }
}