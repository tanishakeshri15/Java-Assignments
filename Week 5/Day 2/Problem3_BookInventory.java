class BookInventory {

    private int copiesTotal;
    private int copiesAvailable;

    BookInventory(int copiesTotal) {

        if (copiesTotal > 0 && copiesTotal <= 500) {
            this.copiesTotal = copiesTotal;
            this.copiesAvailable = copiesTotal;
        }
    }

    void checkOut() {

        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    void checkIn() {

        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    int getCopiesAvailable() {
        return copiesAvailable;
    }
}

public class Problem3_BookInventory {

    public static void main(String[] args) {

        BookInventory book = new BookInventory(5);

        System.out.println("Available copies: "
                           + book.getCopiesAvailable());

        book.checkOut();
        book.checkOut();

        System.out.println("After 2 check-outs: "
                           + book.getCopiesAvailable());

        book.checkIn();

        System.out.println("After 1 check-in: "
                           + book.getCopiesAvailable());
    }
}