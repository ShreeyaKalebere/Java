import java.util.Scanner;

class Employee {
    String name, address, jobTitle;
    float salary, bonus;

    void getData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name:");
        name = sc.nextLine();
        System.out.println("Enter address:");
        address = sc.nextLine();
        System.out.println("Enter job title:");
        jobTitle = sc.nextLine();
        System.out.println("Enter salary:");
        salary = sc.nextFloat();
    }

    void calculateBonus() {
        bonus = salary * 0.1f; // 10% bonus
        System.out.println("Bonus: " + bonus);
    }

    void display() {
        System.out.println("\nEmployee Info:");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Salary: " + salary);
    }

    void performanceReport() {
        System.out.println(name + " is performing well in the company.");
    }
}

class Manager extends Employee {
    void calculateBonus() {
        bonus = salary * 0.2f; // 20% bonus for managers
        System.out.println("Bonus: " + bonus);
    }

    void performanceReport() {
        System.out.println(name + " (Manager) is leading teams effectively.");
    }
}

class Developer extends Employee {
    void calculateBonus() {
        bonus = salary * 0.15f; // 15% bonus for developers
        System.out.println("Bonus: " + bonus);
    }

    void performanceReport() {
        System.out.println(name + " (Developer) is writing clean and efficient code.");
    }
}

class Programmer extends Employee {
    void calculateBonus() {
        bonus = salary * 0.12f; // 12% bonus for programmers
        System.out.println("Bonus: " + bonus);
    }

    void performanceReport() {
        System.out.println(name + " (Programmer) is debugging and optimizing code effectively.");
    }
}

public class EmpTest {
    public static void main(String[] args) {
        Manager m1 = new Manager();
        Developer d1 = new Developer();
        Programmer p1 = new Programmer();

        System.out.println("\nEnter details for Manager:");
        m1.getData();
        m1.display();
        m1.calculateBonus();
        m1.performanceReport();

        System.out.println("\nEnter details for Developer:");
        d1.getData();
        d1.display();
        d1.calculateBonus();
        d1.performanceReport();

        System.out.println("\nEnter details for Programmer:");
        p1.getData();
        p1.display();
        p1.calculateBonus();
        p1.performanceReport();
    }
}
