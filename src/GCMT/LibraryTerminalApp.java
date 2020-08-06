package GCMT;

import java.util.Scanner;

public class LibraryTerminalApp {

	// ~~~ spacers
	// sysout "are you here to return a book or check out?"
	// display books in a list up front
	// books indexed by number
	// keyword search? then index?
	// option A have, option B dont have
	// A - book checks out, book has due date applied
	// checkout status update, dueDate update
	// extra--recommend other within genre
	// B - book not available, display book dueDate for return
	// after a book is checked out successfully, present updated list with updated
	// checkout status
	// sysout "here's your book, it's due back XX/XX/XXXX"
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		System.out.println("********************Welcome to the Public Library!********************");
		System.out.println("              Please Select From The Following Options:               ");
		System.out.println("**********************************************************************");
		while (choice != 5) {
			System.out.println("1: Display all books");
			System.out.println("2: Check out book");
			System.out.println("3: Check in book");
			System.out.println("4: Search book");
			System.out.println("5: Exit");
			choice = input.nextInt();
		}

	}

}
