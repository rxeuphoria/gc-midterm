package GCMT;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.InputMismatchException;
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
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		int choice = 0;
		System.out.println("******************* Welcome to the Public Library! *******************");
		System.out.println("              Please Select From The Following Options:               ");
		System.out.println("******************** "+ calendar.getTime() +  " ********************");
		while (!(choice == 5)) {
			System.out.println("1: Display all books");
			System.out.println("2: Check out book");
			System.out.println("3: Check in book");
			System.out.println("4: Search book");
			System.out.println("5: Exit");
			choice = input.nextInt();

			if (choice == 1) {
				System.out.println(readFile());

			} else if (choice == 2) { // ask what book they want, remove from availible list(temp),apply duedate

				        System.out.println(readFile());        
				        System.out.println(" What book would you like?\n");
				        boolean checkedIn= rentBook(input.next());
				        if (checkedIn) {
				        	System.out.println("It is available for rent.\n");
				        }


				
			} else if (choice == 3) {
				System.out.println("Check"); // ask what book they're checking in, check if its out,check duedate for
												// late fees,add back to avabile list
			} else if (choice == 4) {
				System.out.println("words"); // ask user to choose if the want to search by author or keyword,search
				searchByAuthorName();

			} else if (choice == 5) {
				System.out.println("Goodbye!");
			} else {
				System.out.println("Please enter valid selection.");
			}
		}
		}
		public static void searchByAuthorName(){
			  List<Book> authorSearch = new ArrayList<>();   // Array that stores 'book' Objects.
			int count=0;    // Counter for No of book objects Added in Array.
			
			
		    System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");
		    input.nextLine();
		    System.out.println("Enter Author Name:");
		    String author = input.nextLine();
		    int flag = 0;
		    System.out.println("\t\tName\t\tAuthor");
		    for (int i=0; i<count; i++){

		        if (author.equalsIgnoreCase(GCMT.Book.author)){

		            System.out.println( GCMT.Book.title + "\t\t" + GCMT.Book.author
		               );
		            flag++;
		        System.out.println(authorSearch);
		        }

		    }
		    if (flag == 0)
		        System.out.println("No Books of " + author + " Found.");
	
	}

	
	
	public static boolean rentBook (String userChoice) {
		String available= null;
		for( int i =0; i < readFile().size(); i++) {
			     
		   if(userChoice.equals(readFile().get(i).getCheckedOut())== false) {
			  System.out.println("That book is available for rent.");
		 }
       } return true;
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

				// bookShelf.add(Book(title, author, checkedOut, dueDate));// add to list new
				// list
			}
			return bookShelf;

		} catch (IOException e) {
			System.out.println("Unable to read file.");

			return new ArrayList<>();
		}
	}

	/*
	 * public void showAllBooks() { int count;
	 * System.out.println("Heres what we have in stock");//use tabs to format later
	 * System.out.println("Title\t\tAuthor"); for(int i=0;i<count;i++) {
	 * System.out.println(Book[i].name + Book[i].author);
	 */

}
