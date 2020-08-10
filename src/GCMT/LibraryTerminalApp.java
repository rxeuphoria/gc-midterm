package GCMT;

import java.awt.print.Book;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LibraryTerminalApp {
	private static Path filePath = Paths.get("Bookshelf.txt");
	public static Scanner input = new Scanner(System.in);
	private static int cart = 0;

	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();
		List<Book> bookShelf = new ArrayList<Book>();
		bookShelf = readFile();
		
		int choice = 0;
		System.out.println("******************* Welcome to the Public Library! *******************");
		System.out.println("              Please Select From The Following Options:               ");
		System.out.println("******************** " + calendar.getTime() + " ********************");
		
		while (!(choice == 5) && (cart <= 3)) {
			System.out.println("1: Display all books");
			System.out.println("2: Check out book");
			System.out.println("3: Check in book");
			System.out.println("4: Search book");
			System.out.println("5: Exit");
			choice = input.nextInt();

			if (choice == 1) {
				System.out.println(readFile());

			} else if (choice == 2) { // ask what book they want, remove from availible list(temp),apply duedate
				System.out.println(" What book would you like?\n");
				rentBook(input.next());

			} else if (choice == 3) {
				System.out.println("What would you like to return?\n"); // ask what book they're checking in, check if
																		// its out,check duedate for
				returnBook(input.next()); // late fees,add back to available list
				break;
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

	public static void searchByAuthorName() {
		List<Book> authorSearch = new ArrayList<>(); // Array that stores 'book' Objects.
		int count = 0; // Counter for No of book objects Added in Array.

		System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");
		input.nextLine();
		System.out.println("Enter Author Name:");
		String author = input.nextLine();
		int flag = 0;
		System.out.println("\t\tName\t\tAuthor");
		for (int i = 0; i < count; i++) {

			if (author.equalsIgnoreCase(GCMT.Book.author)) {

				System.out.println(GCMT.Book.title + "\t\t" + GCMT.Book.author);
				flag++;
				System.out.println(authorSearch);
			}

		}
		if (flag == 0)
			System.out.println("No Books of " + author + " Found.");

	}

	public static void rentBook(String name) {

		Calendar calendar = Calendar.getInstance();
		name = input.next();
		try {
			List<String> lines = Files.readAllLines(filePath);
			List<Book> bookShelf = new ArrayList<>();
			for (String line : lines) {

				if (line.contains(name)) {

					if (line.contains("false")) {
						System.out.println("It is available for rent");
						calendar.add(calendar.DATE, 21);
						System.out.println(" Due back by :" + calendar.getTime());

					} else if (line.contains("true")) {
						System.out.println("Not available for rent");
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Unable to read file.");
		}
	}

	public static void returnBook(String userChoice) {
		userChoice = input.next();
		try {
			List<String> lines = Files.readAllLines(filePath);
			List<Book> bookShelf = new ArrayList<>();
			for (String line : lines) {

				if (line.contains(userChoice)) {

					if (line.contains("false")) {
						System.out.println("It is not due back.");
					} else if (line.contains("true")) {
						System.out.println("Thank you for your return.");
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Unable to read file.");
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
				String checkedOut = parts[2];
				String dueDate = parts[3];

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
