import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.Scanner;

public class MainSys {
	static String filename = null;
	static Library lib = new Library();
	static Scanner in = new Scanner(System.in);
	static Boolean running = true;

	public static void main(String[] args) {
		while (running) {
			System.out.println("\nEnter 0 for load Library" + "\nEnter 1 for save and quit"
					+ "\nEnter 2 for list all books in library" + "\nEnter 3 for adding books to library"
					+ "\nEnter 4 to Issue Book" + "\nEnter 5 to Return" + "\nEnter 6 to quit without saving file");

			int answer = in.nextInt();

			switch (answer) {
			case 0:
				// load library
				System.out.println("Enter the filename to load");
				loadScript(in.next());
				break;

			case 1:
				// save and quit
				saveAndQuit();
				break;
			case 2:
				// view Books
				System.out.println(lib.toString());
				break;
			case 3:
				// add Books
				addBook();
				break;
			case 4:
				// Issue book
				issue();
				break;
			case 5:
				// return Book
				returnB();
				break;

			case 6:
				//quit
				System.exit(0);
				break;

			}
		}
		System.exit(0);
	}

	private static void returnB() {
		// TODO Auto-generated method stub
		String BookName, ReturnD;
		int id;

		System.out.println("\nEnter Student ID: ");
		id = in.nextInt();
		// System.out.println("\nEnter Book Name: ");
		// BookName = in.next();
		// System.out.println("\nEnter Date of Returning Book: ");
		// ReturnD = in.next();
		BookName = System.console().readLine("\nEnter Book Name: ");
		ReturnD = System.console().readLine("\nEnter Date of Returning Book: ");

		try {
			lib.ReturnBook(id, BookName, ReturnD);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void issue() {
		// TODO Auto-generated method stub
		String IssueDate, ReturnDate;
		int id;
		String BookName;
		System.out.println("\nEnter Student Id: ");
		id = in.nextInt();
		// System.out.println("\nEnter Book name: ");
		// BookName = in.next();
		// System.out.println("\nEnter Book Issue Date in dd/MM/yyyy format: ");
		// IssueDate = in.next();
		// System.out.println("\nEnter Book Return Date in dd/MM/yyyy format: ");
		// ReturnDate = in.next();
		BookName =  System.console().readLine("\nEnter Book Name: ");
		IssueDate =  System.console().readLine("\nEnter Book Issue Date in dd/MM/yyyy format: ");
		ReturnDate =  System.console().readLine("\nEnter Book Return Date in dd/MM/yyyy format: ");

		lib.IssueBook(id, BookName, IssueDate, ReturnDate);
	}

	private static void addBook() {
		// TODO Auto-generated method stub
		int isbn;
		String title, author;
		double price;

		// System.out.println("\nEnter Title without space: ");
		// title = in.next();
		// System.out.println("\nEnter Author without space: ");
		// author = in.next();
		title = System.console().readLine("\nEnter name of Book: ");
		author = System.console().readLine("\nEnter Author name: ");
		System.out.println("\nEnter ISBN: ");
		isbn = in.nextInt();
		System.out.println("\nEnter Price: ");
		price = in.nextDouble();

		Book b = new Book(isbn, title, author, price);
		lib.addBook(b);
	}

	private static void saveAndQuit() {
		// TODO Auto-generated method stub
		System.out.println("Enter filename: ");
		filename = in.next() + ".ser";
		running = false;
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(lib);
			fos.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void loadScript(String name) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		ObjectInputStream in = null;

		File file = new File(name + ".ser");
		if ( file.exists() ) {
			try {
				fis = new FileInputStream(file);
				in = new ObjectInputStream(fis);
				lib = (Library) in.readObject();
				fis.close();
				in.close();

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("\nThe File doesn't exist");
		}

	}
}
