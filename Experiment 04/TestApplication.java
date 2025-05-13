import java.util.Scanner;

class Student{
    int rollNo;

    void setRollNo(int r){
        rollNo = r;
    }

    int getRollNo(){
        return rollNo;
    }
}

class Test extends Student{
    int sub1, sub2;

    void setMarks(int s1, int s2){
        sub1 = s1;
        sub2 = s2;
    }

    void getMarks(){
        System.out.println("Subject 1 Marks: " + sub1);
        System.out.println("Subject 2 Marks: " + sub2);
    }
}

interface Sports{
    int sMarks = 83;
    void setsMarks();
}

class Result extends Test implements Sports{
    int total;

    public void setsMarks(){
        System.out.println("Sports Marks: " + sMarks);
    }

    void displayResult(){
        total = sub1 + sub2 + sMarks;
        System.out.println("\nStudent Result: ");
        System.out.println("Roll No: " + getRollNo());
        getMarks();
        setsMarks();
        System.out.println("Total Marks: " + total);
    }
}

class TestApplication{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Result r = new Result();

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        r.setRollNo(roll);

        System.out.print("Enter Subject 1 Marks: ");
        int marks1 = sc.nextInt();
        System.out.print("Enter Subject 2 Marks: ");
        int marks2 = sc.nextInt();
        r.setMarks(marks1, marks2);

        r.displayResult();
    }
}