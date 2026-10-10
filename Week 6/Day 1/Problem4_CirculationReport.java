class LibraryMember {

    protected String memberId;
    protected int borrowLimit;

    private int booksBorrowed;

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
    }

    public void borrowBook() {

        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String displayInfo() {

        return "General | Books: "
                + booksBorrowed;
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
    public String displayInfo() {

        return "Student | Course: "
                + course
                + " | Books: "
                + getBooksBorrowed();
    }
}


public class Problem4_CirculationReport {

    static String batchPrint(
            LibraryMember[] members) {

        StringBuilder report =
            new StringBuilder();

        for (int i = 0; i < members.length; i++) {

            LibraryMember member = members[i];

            // Polymorphic call
            report.append(member.displayInfo());

            // Downcast only after instanceof check
            if (member instanceof StudentMember) {

                StudentMember student =
                    (StudentMember) member;

                report.append(
                    " [Course via downcast: "
                );

                report.append(
                    student.getCourse()
                );

                report.append("]");
            }

            report.append(" | ");
        }

        return report.toString();
    }


    public static void main(String[] args) {

        LibraryMember general =
            new LibraryMember(
                "LB05",
                3
            );

        StudentMember student =
            new StudentMember(
                "STU6",
                3,
                "ECE"
            );

        LibraryMember[] members = {
            general,
            student
        };

        System.out.println(
            batchPrint(members)
        );
    }
}