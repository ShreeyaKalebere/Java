abstract class Shape{
    double dim1, dim2;
    Shape(double d1, double d2){
        dim1 = d1;
        dim2 = d2;
    }
    abstract double area();
}

class Rectangle extends Shape {
    Rectangle (double a, double b){
        super(a,b);
    }
    double area(){
        return dim1*dim2;
    }
}

class Triangle extends Shape{
    Triangle(double a, double b){
        super(a,b);
    }
    double area(){
        return 0.5*dim1*dim2;
    }
}

class abstractDemo{
    public static void main(String[] args) {
        Rectangle r = new Rectangle(5,10);
        Triangle t = new Triangle(10,20);

        Shape s1;
        s1 = r;
        System.out.println("Rectangle Area: "+ s1.area());

        s1 = t;
        System.out.println("Triangle Area: "+ s1.area());
    }
}