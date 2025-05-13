import LibraryManagement.Book;
import LibraryManagement.Member;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter book author: ");
        String author = sc.nextLine();
        System.out.print("Enter book ISBN: ");
        String ISBN = sc.nextLine();

        System.out.print("Enter member name: ");
        String name = sc.nextLine();
        System.out.print("Enter member ID: ");
        int memberId = sc.nextInt();

        Book book1 = new Book(title, author, ISBN);
        Member member1 = new Member(name, memberId);

        System.out.println("\nBook Details:");
        book1.displayBook();
        System.out.println("\nMember Details:");
        member1.displayMember();
    }
}
