package LibraryManagement;

public class Book{
	String title;
	String author;
	String ISBN;

	public Book(String t, String a, String i){
		title = t;
		author = a;
		ISBN = i;
	}

	public void displayBook(){
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
		System.out.println("ISBN: " + ISBN);
	}
}