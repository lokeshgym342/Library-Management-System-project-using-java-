import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    books.add(new Book(id, title));
                    System.out.println("Book Added Successfully!");
                    break;

                case 2:
                    System.out.print("Enter Book ID to Remove: ");
                    int removeId = sc.nextInt();

                    boolean removed = books.removeIf(book -> book.id == removeId);

                    if (removed)
                        System.out.println("Book Removed!");
                    else
                        System.out.println("Book Not Found!");
                    break;

                case 3:
                    System.out.print("Enter Book Title to Search: ");
                    String searchTitle = sc.nextLine();

                    boolean found = false;

                    for (Book book : books) {
                        if (book.title.equalsIgnoreCase(searchTitle)) {
                            System.out.println("Book Found!");
                            System.out.println("ID: " + book.id);
                            System.out.println("Title: " + book.title);
                            found = true;
                        }
                    }

                    if (!found)
                        System.out.println("Book Not Found!");
                    break;

                case 4:
                    System.out.println("\nAvailable Books:");
                    for (Book book : books) {
                        System.out.println(book.id + " - " + book.title);
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}