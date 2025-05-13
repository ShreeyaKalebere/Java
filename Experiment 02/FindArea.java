import java.util.Scanner;

class Area{
	double length;
	double breadth;

	Area(){
		length = 0;
		breadth = 0;
	}
	
	void setDim(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Length: ");
		length = sc.nextDouble();
		System.out.print("Enter Breadth: ");
		breadth = sc.nextDouble();
	}

	void getArea(){
		System.out.println("Area of Rectangle: " + length*breadth);
	}
}

class FindArea{
	public static void main (String args[]){
		Area ob = new Area();
		ob.setDim();
		ob.getArea();
	}
}
		


			