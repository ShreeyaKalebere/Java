import java.util.Scanner;

class Queue {
    int size = 5;
    int queue[] = new int[size];
    int front, rear, ele;

    Queue() {
        front = -1;
        rear = -1;
    }

    void enqueue() {
        if (rear == size - 1) {
            System.out.println("Queue Overflow");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Element to Enqueue: ");
            ele = sc.nextInt();
            System.out.println("Element Enqueued Successfully");

            if (front == -1) front = 0;
            rear++;
            queue[rear] = ele;
        }
    }

    void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow");
        } else {
            ele = queue[front];
            System.out.println("Element Dequeued Successfully");
            front++;

            if (front > rear) {
                front = -1;
                rear = -1;
            }
        }
    }

    void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println("Elements are: ");
            for (int i = front; i <= rear; i++) {
                System.out.println(queue[i] + "  ");
            }
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("Enter Operation to Perform: ");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Display");
        System.out.println("4. Exit");

        do {
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    q.enqueue();
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice !!!");
            }
        } while (choice != 4);
    }
}
