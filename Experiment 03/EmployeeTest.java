import java.util.*;

class Employee {
    String name, address, job;
    float salary, bonus;

    void setdata() {
        System.out.println("Enter the name");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        System.out.println("Enter the address");
        address = sc.nextLine();
        System.out.println("Enter the job title");
        job = sc.nextLine();
        System.out.println("Enter the salary");
        salary = sc.nextFloat();
        System.out.println("Enter the bonus");
        bonus = sc.nextFloat();
    }

}

class Manager extends Employee {

    void display() {
        System.out.println("***Manager***");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("job title: " + job);
        System.out.println("salary: " + salary);
        System.out.println("salary after bonus: " + (salary + bonus));
    }
}

class Developer extends Employee {
    void display() {
        System.out.println("***Developer***");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("job title: " + job);
        System.out.println("salary: " + salary);
        System.out.println("salary after bonus: " + (salary + bonus));
    }
}

class Programmer extends Employee {

    void display() {
        System.out.println("***Programmer***");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("job title: " + job);
        System.out.println("salary: " + salary);
        System.out.println("salary after bonus: " + (salary + bonus));
    }
}

class EmployeeTest {
    public static void main(String args[]) {
        // System.out.println("Hello");
        Manager m1 = new Manager();
        m1.setdata();
        m1.display();
        System.out.println();
        Developer d1 = new Developer();
        d1.setdata();
        d1.display();
        System.out.println();
        Programmer p1 = new Programmer();
        p1.setdata();
        p1.display();
    }
}