class LoanReceipt {

    private final String memberName;
    private final String[] bookIds;

    LoanReceipt(String memberName, String[] bookIds) {
        this.memberName = memberName;

        this.bookIds = new String[bookIds.length];

        for (int i = 0; i < bookIds.length; i++) {
            this.bookIds[i] = bookIds[i];
        }
    }

    public String getMemberName() {
        return memberName;
    }

    public String[] getBookIds() {

        String[] copy = new String[bookIds.length];

        for (int i = 0; i < bookIds.length; i++) {
            copy[i] = bookIds[i];
        }

        return copy;
    }

    public LoanReceipt withCorrectedBookId(
            int index, String newId) {

        String[] copy = getBookIds();

        if (index >= 0 && index < copy.length) {
            copy[index] = newId;
        }

        return new LoanReceipt(memberName, copy);
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {

    ReferenceOnlyLoanReceipt(
            String memberName, String[] bookIds) {

        super(memberName, bookIds);
    }
}

class CirculationLedger {

    static int totalProcessed = 0;
    static int nullSkipped = 0;
    static int referenceOnly = 0;

    static {
        totalProcessed = 0;
        nullSkipped = 0;
        referenceOnly = 0;
    }

    static String processNightlyCirculation(
            LoanReceipt[] receipts) {

        int processed = 0;
        int nullCount = 0;
        int referenceCount = 0;

        for (int i = 0; i < receipts.length; i++) {

            if (receipts[i] == null) {
                nullCount++;
            } else {

                processed++;

                if (receipts[i]
                        instanceof ReferenceOnlyLoanReceipt) {

                    referenceCount++;
                }
            }
        }

        totalProcessed = processed;
        nullSkipped = nullCount;
        referenceOnly = referenceCount;

        int regular = processed - referenceCount;

        return processed + " processed | "
                + nullCount + " null skipped | "
                + referenceCount + " reference-only | "
                + regular + " regular";
    }
}

public class Problem5_LoanReceipt {

    public static void main(String[] args) {

        String[] books1 = {"B101", "B102"};

        LoanReceipt receipt1 =
                new LoanReceipt("Tanisha", books1);

        LoanReceipt corrected =
                receipt1.withCorrectedBookId(1, "B999");

        String[] books2 = {"B201"};

        ReferenceOnlyLoanReceipt receipt2 =
                new ReferenceOnlyLoanReceipt(
                        "Rahul", books2);

        LoanReceipt[] receipts = {
            receipt1,
            receipt2,
            null,
            corrected
        };

        System.out.println(
                CirculationLedger.processNightlyCirculation(
                        receipts));
    }
}