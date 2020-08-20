import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library extends Object implements Serializable{
	private List<Book> collection;

	public Library() {
		collection = new ArrayList<Book>();
	}
	
	public void addBook(Book book) {
		collection.add(book);
	}
	
	public void IssueBook(int ID,String BookName,String IssueD,String ReturnD) {
		int x=2;
		Iterator<Book> i=collection.iterator();
		while(i.hasNext()) {
			Book b=(Book)i.next();
			x=b.compareTitle(BookName);
			if(x==0)	break;
			if(x==1) {
				b.issue(ID,IssueD,ReturnD);
				break;
			}
		}
		if(x==2){
			System.out.println("\nEither you've typed wrong bookname or the book is not available");
		}
	}
	
	public void ReturnBook(int id, String bookName, String returnD) throws ParseException {
		// TODO Auto-generated method stub
		int x=2;
		Iterator<Book> i=collection.iterator();
		while(i.hasNext()) {
			Book b=(Book)i.next();
			x=b.findBook(id,bookName);
			if(x==0)	break;
			if(x==1) {
				b.returnBook(returnD);
				break;
			}
		}
		if(x==2){
			System.out.println("You've typed wrong bookname");
		}
	}
	
	@Override
	public String toString() {
		String total= "\n";
		/*
		for(int i=0;i<collection.size();i++) {
			Book b=collection.get(i);
			total=total+b.toString();
		}*/
		Iterator<Book> i=collection.iterator();
		while(i.hasNext()) {
			Book b=(Book)i.next();
			total=total+b.toString();
		}
		return total;
	}

	
}
