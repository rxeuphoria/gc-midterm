package GCMT;

import java.util.Calendar;

public class Book {
	
	private static String title;
	private static String author;
	private static Boolean checkedOut;
	private static Calendar dueDate;
	
	public Book() {
		
	}
	
	public Book(String title, String author, Boolean checkedOut, Calendar dueDate) {
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

	public static Boolean getCheckedOut() {
		return checkedOut;
	}

	public static void setCheckedOut(Boolean checkedOut) {
		Book.checkedOut = checkedOut;
	}

	public static Calendar getDueDate() {
		return dueDate;
	}

	public static void setDueDate(Calendar dueDate) {
		Book.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "Title" + this.title + " Author " + this.author + " Checked out " + this.checkedOut + "Due Date" + this.dueDate;
	}

	

	
}
