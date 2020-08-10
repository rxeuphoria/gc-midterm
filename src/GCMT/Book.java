package GCMT;

import java.util.Calendar;

public class Book {

	static String title;
	static String author;
	static String checkedOut;
	static int dueDate;

	public Book() {

	}

	public Book(String title, String author, String checkedOut, int dueDate) {
		this.title = title;
		this.author = author;
		this.checkedOut = checkedOut;
		this.dueDate = dueDate;
	}

	public static String getTitle() {
		return title;
	}

	public static void setTitle(String title) {
		Book.title = title;
	}

	public static String getAuthor() {
		return author;
	}

	public static void setAuthor(String author) {
		Book.author = author;
	}

	public static String getCheckedOut() {
		return checkedOut;
	}

	public static void setCheckedOut(String checkedOut) {
		Book.checkedOut = checkedOut;
	}

	public static int getDueDate() {
		return dueDate;
	}

	public static void setDueDate(int dueDate) {
		Book.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "Title" + this.title + " Author " + this.author + " Checked out " + this.checkedOut + "Due Date"
				+ this.dueDate;
	}

}
