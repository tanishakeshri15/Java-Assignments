class LibraryMember {

    protected String memberId;
    protected int borrowLimit;

    private int booksBorrowed;

    private int[] fineHistory;
    private int fineCount;

    public LibraryMember(String memberId, int borrowLimit) {

        if (memberId == null ||
            memberId.trim().length() < 4) {

            throw new IllegalArgumentException(
                "Invalid member ID"
            );
        }

        if (borrowLimit <= 0) {
            throw new IllegalArgumentException(
                "Borrow limit must be positive"
            );
        }

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;

        fineHistory = new int[10];
        fineCount = 0;
    }

    public void borrowBook() {

        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    protected void chargeFine(int amount) {

        if (fineCount < fineHistory.length) {
            fineHistory[fineCount] = amount;
            fineCount++;
        }
    }

    public int[] getFineHistory() {

        int[] copy = new int[fineCount];

        for (int i = 0; i < fineCount; i++) {
            copy[i] = fineHistory[i];
        }

        return copy;
    }

    public int getTotalFine() {

        int total = 0;

        for (int i = 0; i < fineCount; i++) {
            total += fineHistory[i];
        }

        return total;
    }

    public void displayInfo() {

        System.out.println(
            "General Member | Books Borrowed: "
            + booksBorrowed
        );
    }
}


class StudentMember extends LibraryMember {

    private String course;

    public StudentMember(
            String memberId,
            int borrowLimit,
            String course) {

        super(memberId, borrowLimit);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    protected void chargeFine(int amount) {

        super.chargeFine(amount / 2);
    }

    @Override
    public void displayInfo() {

        System.out.println(
            "Student Member | Course: "
            + course
            + " | Books Borrowed: "
            + getBooksBorrowed()
        );
    }
}


public class Problem3_FineLedger {

    public static void main(String[] args) {

        StudentMember s =
            new StudentMember(
                "STU5",
                3,
                "CSE"
            );

        s.chargeFine(100);

        System.out.println(
            s.getTotalFine()
        );

        int[] history =
            s.getFineHistory();

        history[0] = 999;

        int[] actualHistory =
            s.getFineHistory();

        System.out.println(
            "[" + actualHistory[0] + "]"
        );
    }
}