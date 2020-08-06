package GCMT;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class LibraryTerminalApp {
	private static Path filePath = Paths.get("Bookshelf.txt");

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
		switch (choice) {
		case 1: // Display all books;
			readFile();// bookshelf list
			break;
		case 2:
			System.out.println(BookList);// Check out book
		
			break;
		case 3: // check in;
			System.out.println("Check");
			break;
		case 4: // search book
			System.out.println("words");
			break;
		case 5: // exit
			System.out.println("there");
			break;
		}
	}

	// Read all the objects from a file and store them in a List.
	public static List<Book> readFile() {
		try {
			List<String> lines = Files.readAllLines(filePath);
			List<Book> bookShelf = new ArrayList<>();

			for (String word : lines) {
				// System.out.println(word);

				String[] parts = word.split("~~~");
				System.out.println(Arrays.deepToString(parts));// separate each part based on index

				String title = parts[0];
				String author = parts[1];
				boolean checkedOut = parts[2] != null;
				int dueDate = Integer.parseInt(parts[3]);

				bookShelf.add(Book(title, author, checkedOut, dueDate));// add to list new list
			}
			return bookShelf;

		} catch (IOException e) {
			System.out.println("Unable to read file.");

			return new ArrayList<>();
		}
	}

	private static Book Book(String title, String author, boolean checkedOut, int dueDate) {
		// TODO Auto-generated method stub
		return null;
	}
	public void showAllBooks() {
		
		System.out.println("Heres what we have in stock");//use tabs to format later
		System.out.println("Title\t\tAuthor");
		for(int i=0;i<count;i++) {
		System.out.println(Book[i].name + Book[i].author);
		}	
	}
	
}
