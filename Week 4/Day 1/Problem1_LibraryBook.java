class LibraryBook {
    String title;
    String isbn;

    // Constructor when ISBN is available
    public LibraryBook(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    // Constructor when ISBN is not available
    public LibraryBook(String title) {
        this(title, "PENDING");
    }

    void printStatus() {
        System.out.println(
            title + " | " + isbn + " | Catalogued: true"
        );
    }
}

public class Problem1_LibraryBook {
    public static void main(String[] args) {

        String[] titles = {
            "Clean Code",
            "Untitled Draft",
            "1984",
            "Notes"
        };

        String[] isbns = {
            "978-0132350884",
            "",
            "9780451524935",
            ""
        };

        for (int i = 0; i < titles.length; i++) {

            LibraryBook book;

            if (isbns[i].equals("")) {
                book = new LibraryBook(titles[i]);
            } else {
                book = new LibraryBook(titles[i], isbns[i]);
            }

            book.printStatus();
        }
    }
}