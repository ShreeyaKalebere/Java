import java.util.Scanner;

interface Stack{
    int size = 5;
    void push();
    void pop();
    void display();
    boolean overflow();
    boolean underflow();
}

class IntegerStack implements Stack{
    int stk[] = new int[size];
    int top, ele;

    public IntegerStack(){
        top = -1;
    }

    public void push(){
        if(top == size -1){
            System.out.println("Stack Overflow");
        } else{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Element to Push: ");
            ele = sc.nextInt();
            System.out.println("Element Pushed Sccessfully");
            top++;
            stk[top] = ele;
        }
    }

    public void pop(){
        if(top == -1){
            System.out.println("Stack Underflow");
        } else{
            ele = stk[top];
            top--;
            System.out.println("Element Popped Successfully");
        }
        
    }

    public void display(){
        if(top == -1){
            System.out.println("Stack Underflow");
        } else{
            System.out.println("Elements are: ");
            for(int i = top; i>=0; i--){
                System.out.println(stk[i]+ "  ");
            }
        }
    }

    public boolean overflow() {
        return top == size - 1;
    }

    public boolean underflow() {
        return top == -1;
    }
}

public class StackInterface{
    public static void main(String[] args) {
        IntegerStack s1 = new IntegerStack();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("\nEnter Operation to Perform: ");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Display");
        System.out.println("4. Check Overflow");
        System.out.println("5. Check Underflow");
        System.out.println("6. Exit");

        do {
            System.out.print("\nEnter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: s1.push();
                        break;
                case 2: s1.pop();
                        break;    
                case 3: s1.display();
                        break;
                case 4: if (s1.overflow()) {
                            System.out.println("Stack Overflow");
                        } else {
                            System.out.println("Stack is NOT Full.");
                        }
                        break;
                    
                case 5: if (s1.underflow()) {
                            System.out.println("Stack Underflow");
                        } else {
                            System.out.println("Stack is NOT Empty.");
                        }
                        break;
                    
                case 6: System.out.println("Exiting...");
                        break;
                    
                default: System.out.println("Invalid Choice!");   
            }
        } while (choice != 6);
    }
}
