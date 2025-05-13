import java.util.Scanner;

class Employee {
	String fName;
	String lName;
	double mSal, ySal, inc;

	Employee(){
		fName = "";
		lName = "";
		mSal = 0;
	}

	void getInfo(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter First Name: ");
		fName = sc.next();
		System.out.print("Enter Last Name: ");
		lName = sc.next();
		System.out.print("Enter Monthly Salary: ");
		mSal = sc.nextDouble();

		if(mSal<0){
			mSal=0;
		}
	}

	void setInfo(){
		System.out.println("First Name: " + fName);
		System.out.println("Last Name: " + lName);
		System.out.println("Monthly Salary: " + mSal);

		ySal = mSal*12;
		System.out.println("Yearly Salary: "+ ySal);
	}

	void raiseSal(){
		inc= ySal*0.10;
		ySal = ySal + inc;
		System.out.println("Incremented Salary: " + ySal);
	}
}

class EmployeeTest{
	public static void main(String[] args) {
		Employee ob1 = new Employee();
		Employee ob2 = new Employee();

		System.out.println("Employee 1: ");
		ob1.getInfo();
		ob1.setInfo();
		ob1.raiseSal();

		System.out.println("Employee 2: ");
		ob2.getInfo();
		ob2.setInfo();
		ob2.raiseSal();
	}
}