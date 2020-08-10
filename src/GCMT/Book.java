package GCMT;

public class Book {

	private String title;
	private String author;
	private String checkedOut;
	private int dueDate;

	public Book() {

	}

	public Book(String title, String author, String checkedOut, int dueDate) {
		this.title = title;
		this.author = author;
		this.checkedOut = checkedOut;
		this.dueDate = dueDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(String checkedOut) {
		this.checkedOut = checkedOut;
	}

	public int getDueDate() {
		return dueDate;
	}

	public void setDueDate(int dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "Title: " + this.title + "\tAuthor: " + this.author + "\tChecked out:  " + this.checkedOut + "\tDue Date: "
				+ this.dueDate;
	}

}
