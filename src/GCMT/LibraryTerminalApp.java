package GCMT;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
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
	private static int cart = 0;

	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();
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
				// break;

			} else if (choice == 3) {
				System.out.println("What would you like to return?\n"); // ask what book they're checking in, check if
																		// its out,check duedate for
				returnBook(input.next()); // late fees,add back to available list
				break;
			} else if (choice == 4) {

				System.out.println("welcome to the search engine would you like to search by keyword or author?");
				System.out.println("Please select 1 for author or 2 for keyword");
				choice = input.nextInt();
				if (choice == 1)
					searchByAuthorName();
				if (choice == 2)
					searchByKeyWord();
				else {
					System.out.println("Please make a valid selection");
				}

			} else if (choice == 5) {
				System.out.println("Goodbye!");
			} else {
				System.out.println("Please enter valid selection.");
			}
		}
	}

	public static ArrayList<Object> searchByAuthorName() {
		try {
			List<String> lines = Files.readAllLines(filePath);
			System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");
			input.nextLine();
			System.out.println("Enter Author Name:");
			String author = input.nextLine();
			int flag = 0;
			System.out.println("\tName\t\t\t\tAuthor");
			System.out.println("**********************************************************************");
			for (String word : lines) {
				String[] parts = word.split("~~~");
				String author1 = parts[1];
				String title = parts[0];
				if (author.equalsIgnoreCase(author1)) {

					System.out.println(" " + parts[0] + "\t\t" + parts[1]);
					flag++;

				}

			}
			if (flag == 0)
				System.out.println("No Books of " + author + " Found.");

		} catch (IOException e) {
			System.out.println("Unable to read file.");
		}
		return new ArrayList<>();

	}

	public static ArrayList<Object> searchByKeyWord() {
		try {
			List<String> lines = Files.readAllLines(filePath);
			System.out.println("\t\t\t\tSEARCH BY KEYWORD");
			input.nextLine();
			System.out.println("Enter a keyword:");
			String keyword = input.nextLine();
			int flag = 0;
			System.out.println("\tName\t\t\t\tAuthor");
			System.out.println("**********************************************************************");
			for (String word : lines) {
				String[] parts = word.split("~~~");
				String author1 = parts[1];
				String title = parts[0];
				if (title.contains(keyword)) {

					System.out.println(" " + parts[0] + "\t\t" + parts[1]);
					flag++;

				}

			}
			if (flag == 0)
				System.out.println("No Books of " + keyword + " Found.");

		} catch (IOException e) {
			System.out.println("Unable to read file.");
		}
		return new ArrayList<>();

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
						replaceLinesOut();
						// break;
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
				//System.out.println(Arrays.deepToString(parts));

				String title = parts[0];
				String author = parts[1];
				String checkedOut = parts[2];
				int dueDate = Integer.parseInt(parts[3]);

				bookShelf.add(new Book(title, author, checkedOut, dueDate));
			}
			return bookShelf;

		} catch (IOException e) {
			System.out.println("Unable to read file.");

			return new ArrayList<>();
//			System.out.println(" " + parts[0] + "\t\t" + parts[1]);    formate list view

		}
	}

	public static void replaceLinesOut() {
		try {
			BufferedReader file = new BufferedReader(new FileReader("Bookshelf.txt"));
			StringBuffer inputBuffer = new StringBuffer();
			String line;

			while ((line = file.readLine()) != null) {
				line.replace("false", "true");
				inputBuffer.append(line);
				inputBuffer.append('\n');
			}
			file.close();

			FileOutputStream fileOut = new FileOutputStream("Bookshelf.txt");
			fileOut.write(inputBuffer.toString().getBytes());
			fileOut.close();

		} catch (Exception e) {
			System.out.println("Problem reading file.");
		}
	}
}
