// String address = System.console().readLine("Enter your Address: ");

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book implements Serializable{
	private int isbn;
	private String title, author;
	private double price;
	
	private String status;
	private String IssueDate;
	private int StudentID;
	private String ReturnDate;
	
	public Book(){
		isbn=0;
		title=null;
		author=null;
		price=0;
	}
	
	public Book(int isbn,String title,String author,double price) {
		this.isbn=isbn;
		this.title=title;
		this.author=author;
		this.price=price;
		
		this.status=null;
		this.IssueDate=null;
		this.StudentID=0;
		this.ReturnDate=null;
	}
	
	public int compareTitle(String BookName) {
		String s="Issued";
		if(BookName.equals(title)) {
			if(s.equals(status)) {
				System.out.println("\nBook is already issued by someone else");
				return 0;
			}
			return 1;
		}
		return 2;
	}
	
	public void issue(int id,String IssueD,String ReturnD) {
		this.StudentID=id;
		this.status="Issued";
		this.IssueDate=IssueD;
		this.ReturnDate=ReturnD;
		
		System.out.println("Book issued by "+id+".");
	}
	
	public int findBook(int id, String bookName) {
		if(bookName.equals(title)) {
			if(this.StudentID != id) {
				System.out.println("This Book is not issued by Student ID no. "+ id);
				return 0;
			}
			return 1;
		}
		return 2;
	}
	
	public void returnBook(String returnD) throws ParseException {
		// TODO Auto-generated method stub
		Date RetDate=new SimpleDateFormat("dd/MM/yyyy").parse(this.ReturnDate);
		Date todayDate=new SimpleDateFormat("dd/MM/yyyy").parse(returnD);
		
		if( (RetDate.after(todayDate)) || (RetDate.equals(todayDate) ) ){
			this.status=null;
			this.IssueDate=null;
			this.StudentID=0;
			this.ReturnDate=null;
			System.out.println("Book " + title + " is Returned");
		}
		else {
			System.out.println("You have delayed in returning book,Your Book can only be returned after paying late Return Charges");
		}
	}
	
	@Override
	public String toString() {
		return "\nTitle: " + title + "\nAuthor: " + author + "\nISBN: " +isbn + "\nPrice: " + price + "\n";
	}	
}
