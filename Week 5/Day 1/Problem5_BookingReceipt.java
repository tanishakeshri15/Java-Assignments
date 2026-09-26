import java.util.Arrays;

class BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;

        // Defensive copy while receiving the array
        this.seatNumbers = Arrays.copyOf(
            seatNumbers,
            seatNumbers.length
        );
    }

    public String[] getSeatNumbers() {

        // Defensive copy while returning the array
        return Arrays.copyOf(
            seatNumbers,
            seatNumbers.length
        );
    }

    public BookingReceipt withUpdatedSeat(
        int index,
        String newSeat
    ) {
        // Create a copy so the original receipt is not changed
        String[] updatedSeats = getSeatNumbers();

        updatedSeats[index] = newSeat;

        // Return a new receipt
        return new BookingReceipt(
            bookingId,
            updatedSeats
        );
    }
}

class GroupBookingReceipt extends BookingReceipt {

    private final int groupSize;

    public GroupBookingReceipt(
        String bookingId,
        String[] seatNumbers,
        int groupSize
    ) {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }
}

public class Problem5_BookingReceipt {

    static String processNightlySettlement(
        BookingReceipt[] receipts
    ) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (int i = 0; i < receipts.length; i++) {

            if (receipts[i] == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (receipts[i] instanceof GroupBookingReceipt) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | " +
               nullSkipped + " null skipped | " +
               group + " group | " +
               individual + " individual";
    }

    public static void main(String[] args) {

        BookingReceipt b =
            new BookingReceipt(
                "CH-1001",
                new String[]{"A1", "A2"}
            );

        // Test defensive copy from getter
        String[] seats = b.getSeatNumbers();
        seats[0] = "X";

        System.out.println(
            "Original first seat: " +
            b.getSeatNumbers()[0]
        );

        // Test withUpdatedSeat()
        BookingReceipt updated =
            b.withUpdatedSeat(1, "A3");

        System.out.println(
            "Original seats: " +
            Arrays.toString(b.getSeatNumbers())
        );

        System.out.println(
            "Updated seats: " +
            Arrays.toString(updated.getSeatNumbers())
        );

        // Test nightly settlement
        BookingReceipt[] receipts = {

            new GroupBookingReceipt(
                "CH-2002",
                new String[]{"B1", "B2"},
                2
            ),

            null,

            new BookingReceipt(
                "CH-3003",
                new String[]{"C1"}
            )
        };

        System.out.println(
            processNightlySettlement(receipts)
        );
    }
}