import java.util.Scanner;

class Stack{
    int size=5;
    int stk[] = new int[size];
    int top, ele, i;

    //constructor
    Stack(){
        top = -1;
    }

    void push(){
        if(top == size-1){
            System.out.println("Stack Overflow");
        }else{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Element to Push: ");
            ele = sc.nextInt();
            System.out.println("Element Pushed Successfully");
            top++;
            stk[top] = ele;
        }
    } 

    void pop(){
        if(top == -1){
            System.out.println("Stack Underflow");
        } else{
            ele = stk[top];
            top--;
            System.out.println("Element Popped Successfully");
        }
    }

    void display(){
        if(top == -1){
            System.out.println("Stack Underflow");
        } else{
            System.out.println("Elements are: ");
            for(i = top; i>=0; i--){
                System.out.println(stk[i]+ "  ");
            }
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("Enter Operation to Perform: ");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Display");
        System.out.println("4. Exit");

        do{
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: s.push();
                        break;
                case 2: s.pop();
                        break;
                case 3: s.display();
                        break;
                case 4: System.out.println("Exiting...");
                        break;
                default: System.out.println("Invalid Choice !!!");
            }
        } while(choice != 4);
    }
}