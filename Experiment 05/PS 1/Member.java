package LibraryManagement;

public class Member{
	String name;
	int memberId;

	public Member(String n, int id){
		name = n;
		memberId = id;
	}

	public void displayMember(){
		System.out.println("Member Name: " + name);
        System.out.println("Member ID: " + memberId);
	}
}