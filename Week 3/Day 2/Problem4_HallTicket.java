class HallTicket {
    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class Problem4_HallTicket {
    public static void main(String[] args) {

        HallTicket priya = new HallTicket("Priya", 32);

        HallTicket copy = priya;

        copy.seatNumber = 45;

        System.out.println("Priya's seat number: " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        HallTicket separate = new HallTicket("Priya", 45);

        System.out.println("separate == priya: " + (separate == priya));
    }
}